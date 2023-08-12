package yunqiu.Buffer;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_ipȥ�� {
    /**
     * ����һ������ hash ˼�룬��һ�����ļ���ϣ�ָ���С�ļ��У����ݹ�ϣ��ͻ��֪ip��ͬ��һ������ͬһ��С�ļ��У�
     * �Ӷ���֤��������Ķ����ԣ����ͨ����С�ļ����п���������ȥ�غϲ��õ����
     * �����������ò�¡����������ȥ�أ�������һ���Ĵ������
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
     * ���ļ�hashȡģ֮��ŵ���ͬ��С�ļ���
     */
    public static File[] splitFile(String sourceFile, int batchSize) {
        File file = new File(sourceFile);
        BufferedReader reader = null;
        PrintWriter[] ips = new PrintWriter[batchSize];
        //����2000��С�ļ�
        File[] splitFiles = new File[batchSize];
        //���ڵ�Ŀ¼
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
                    //��ÿ��ip����hashȡģ֮��ŵ���Ӧȡģֵ���ļ��У�hashֵ��ͬip������ͬһ���ļ�����
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
     * ��С�ļ�����ȥ�غϲ�
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
                    System.out.println("---С�ļ���" + littleFiles[i].getName() + "ȥ��---");
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
                //�ϲ����ɾ��С�ļ�
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
