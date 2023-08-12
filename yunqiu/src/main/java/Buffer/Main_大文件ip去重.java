package Buffer;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 底层设备永远只接受字节数据，有时候要写字符串到底层设备，需要将字符串转成字节再进行写入。
 * 字符流是字节流的包装，字符流则是直接接受字符串，它内部将串转成字节，再写入底层设备，
 */
public class Main_大文件ip去重 {
    public static void main(String args[]) throws IOException {
        /**
         * 方法一：借助 hash 思想，把一个大文件哈希分割到多个小文件中，根据哈希冲突可知ip相同的一定会在同一个小文件中，
         *        从而保证了子问题的独立性，最后通过对小文件进行快速排序来去重合并得到结果
         */
        // 文件拆分
        Set<String> splitFiles = splitFileFuntion("leetcode/jobs/src/Buffer/ip.txt", 128, "leetcode/jobs/src/Buffer/");
        // 单个文件hashSet去重再合并成一个大文件
        try {
            distinctAndMergeFile(splitFiles, "leetcode/jobs/src/Buffer/outputTest");
        } catch (Exception e) {
            System.out.println(String.format("merge file internal error : %s", e.getMessage()));
        }
        /**
         * 其余的解决思路：方法二：利用布隆过滤器进行去重，但是有一定的错误概率
         */
    }

    /**
     * description: 将大文件按照hash去模的方式进行拆分
     * 参数输入范例： 原始文件filePath:src/test/resources/test 模大小batchSize:128 输出文件夹outputDirPatch: src/test/resources/
     *
     * @param filePath
     * @param batchSize
     * @param outputDirPatch
     */
    public static Set<String> splitFileFuntion(String filePath, Integer batchSize, String outputDirPatch) {
        Set outputFiles = new HashSet(batchSize);
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(filePath);
            br = new BufferedReader(fr);
            String line = "";
            String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
            Pattern pattern = Pattern.compile(ip);
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                // 查看是否是ipv4 对应的ip
                if (matcher.matches()) {
                    String fileName = outputDirPatch + line.hashCode() % batchSize;
                    FileOutputStream fs = new FileOutputStream(new File(fileName), true);
                    //PrintStream流中基本所有的print(Object obj)重载方法和println(Object obj)重载方法都是通过将对应数据先转换成字符串,然后调用write()方法写到底层输出流中.
                    PrintStream p = new PrintStream(fs);
                    outputFiles.add(fileName);
                    p.println(line);
                    p.close();
                }
            }
//            br.close();
//            fr.close();
        } catch (IOException e) {
            System.out.println(String.format("split file internal error : %s", e.getMessage()));
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputFiles;
    }

    /**
     * description: 单个文件按照hashSet的方式进行去重
     * 参数输入范例：
     *
     * @return void
     */
    public static void distinctAndMergeFile(Set<String> splitOutputFiles, String fileOutputFile) throws FileNotFoundException {
        FileOutputStream fs = new FileOutputStream(new File(fileOutputFile), true);
        PrintStream p = new PrintStream(fs);
        Set mergeSet = new HashSet<String>();

        splitOutputFiles.stream().forEach(splitOutputFile -> {
            FileReader fr = null;
            BufferedReader br = null;
            try {
                fr = new FileReader(splitOutputFile);
                br = new BufferedReader(fr);

                String line = "";
                while ((line = br.readLine()) != null) {
                    mergeSet.add(line);
                }
                mergeSet.stream().forEach(s -> {
                    p.println(s);
                });

                // 清理已经输出的文件
                mergeSet.clear();
                // 防止溢出
                System.gc();
            } catch (Exception e) {
                System.out.println(String.format("distinct file internal error : %s", e.getMessage()));
            } finally {
                try {
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}