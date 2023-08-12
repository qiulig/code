package Buffer;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * �ײ��豸��Զֻ�����ֽ����ݣ���ʱ��Ҫд�ַ������ײ��豸����Ҫ���ַ���ת���ֽ��ٽ���д�롣
 * �ַ������ֽ����İ�װ���ַ�������ֱ�ӽ����ַ��������ڲ�����ת���ֽڣ���д��ײ��豸��
 */
public class Main_���ļ�ipȥ�� {
    public static void main(String args[]) throws IOException {
        /**
         * ����һ������ hash ˼�룬��һ�����ļ���ϣ�ָ���С�ļ��У����ݹ�ϣ��ͻ��֪ip��ͬ��һ������ͬһ��С�ļ��У�
         *        �Ӷ���֤��������Ķ����ԣ����ͨ����С�ļ����п���������ȥ�غϲ��õ����
         */
        // �ļ����
        Set<String> splitFiles = splitFileFuntion("leetcode/jobs/src/Buffer/ip.txt", 128, "leetcode/jobs/src/Buffer/");
        // �����ļ�hashSetȥ���ٺϲ���һ�����ļ�
        try {
            distinctAndMergeFile(splitFiles, "leetcode/jobs/src/Buffer/outputTest");
        } catch (Exception e) {
            System.out.println(String.format("merge file internal error : %s", e.getMessage()));
        }
        /**
         * ����Ľ��˼·�������������ò�¡����������ȥ�أ�������һ���Ĵ������
         */
    }

    /**
     * description: �����ļ�����hashȥģ�ķ�ʽ���в��
     * �������뷶���� ԭʼ�ļ�filePath:src/test/resources/test ģ��СbatchSize:128 ����ļ���outputDirPatch: src/test/resources/
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
                // �鿴�Ƿ���ipv4 ��Ӧ��ip
                if (matcher.matches()) {
                    String fileName = outputDirPatch + line.hashCode() % batchSize;
                    FileOutputStream fs = new FileOutputStream(new File(fileName), true);
                    //PrintStream���л������е�print(Object obj)���ط�����println(Object obj)���ط�������ͨ������Ӧ������ת�����ַ���,Ȼ�����write()����д���ײ��������.
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
     * description: �����ļ�����hashSet�ķ�ʽ����ȥ��
     * �������뷶����
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

                // �����Ѿ�������ļ�
                mergeSet.clear();
                // ��ֹ���
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