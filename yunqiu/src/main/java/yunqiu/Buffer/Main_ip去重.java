package yunqiu.Buffer;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_ip去重 {
    /**
     * 方法一：借助 hash 思想，把一个大文件哈希分割到多个小文件中，根据哈希冲突可知ip相同的一定会在同一个小文件中，
     * 从而保证了子问题的独立性，最后通过对小文件进行快速排序来去重合并得到结果
     * 方法二：利用布隆过滤器进行去重，但是有一定的错误概率
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int batchSize = 2000;
        File[] files = splitFile("./leetcode/jobs/src/Buffer/ip.txt", batchSize);
        distinct(files, "./leetcode/jobs/src/Buffer/ans.txt", batchSize);
    }

    /**
     * 将文件hash取模之后放到不同的小文件中
     */
    public static File[] splitFile(String sourceFile, int batchSize) {
        File file = new File(sourceFile);
        BufferedReader reader = null;
        PrintWriter[] ips = new PrintWriter[batchSize];
        //构建2000个小文件
        File[] splitFiles = new File[batchSize];
        //父节点目录
        String parentPath = file.getParent();
        File folder = new File(parentPath + File.separator + "ip");
        if (!folder.exists()) {
            folder.mkdir();
        }
        for (int i = 0; i < batchSize; i++) {
            splitFiles[i] = new File(folder.getAbsolutePath() + File.separator + i + ".txt");
            if (splitFiles[i].exists()) {
                splitFiles[i].delete();
            }
            try {
                ips[i] = new PrintWriter(splitFiles[i]);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
            Pattern pattern = Pattern.compile(ip);
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    //将每行ip数据hash取模之后放到对应取模值的文件中，hash值相同ip都会在同一个文件里面
                    int index = Math.abs(line.hashCode() % batchSize);
                    ips[index].println(line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            for (int i = 0; i < batchSize; i++) {
                if (ips[i] != null) {
                    ips[i].close();
                }
            }
        }
        return splitFiles;
    }

    /**
     * 对小文件进行去重合并
     */
    public static void distinct(File[] littleFiles, String ansFilePath, int batchSize) {
        File distinctedFile = new File(ansFilePath);
        BufferedReader[] br = new BufferedReader[batchSize];
        FileReader[] fr = new FileReader[batchSize];
        PrintWriter printWriter = null;
        try {
            if (distinctedFile.exists()) {
                distinctedFile.delete();
            }
            distinctedFile.createNewFile();
            printWriter = new PrintWriter(distinctedFile);
            Set<String> unicSet = new HashSet<String>();
            for (int i = 0; i < batchSize; i++) {
                if (littleFiles[i].exists()) {
                    System.out.println("---小文件：" + littleFiles[i].getName() + "去重---");
                    fr[i] = new FileReader(littleFiles[i]);
                    br[i] = new BufferedReader(fr[i]);
                    String line = null;
                    while ((line = br[i].readLine()) != null) {
                        if (line != "") {
                            unicSet.add(line);
                        }
                    }
                    for (String s : unicSet) {
                        printWriter.println(s);
                    }
                    unicSet.clear();
                    System.gc();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            for (int i = 0; i < batchSize; i++) {
                try {
                    if (null != fr[i]) {
                        fr[i].close();
                    }
                    if (null != br[i]) {
                        br[i].close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                //合并完成删除小文件
                if (littleFiles[i].exists()) {
                    littleFiles[i].delete();
                }
            }
            if (null != printWriter) {
                printWriter.close();
            }
        }
    }
}
