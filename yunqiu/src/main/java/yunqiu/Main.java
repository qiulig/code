package yunqiu;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

        /**
         * ���ļ�hashȡģ֮��ŵ���ͬ��С�ļ���
         * @param targetFile Ҫȥ�ص��ļ�·��
         * @param splitSize ��Ŀ���ļ��и�ɶ��ٷ�hashȡģ��С�ļ�����
         * @return
         */
        public static File[] splitFile(String targetFile,int splitSize){
            File file = new File(targetFile);
            BufferedReader reader = null;
            PrintWriter[] pws = new PrintWriter[splitSize];
            File[] littleFiles = new File[splitSize];
            String parentPath = file.getParent();
            File tempFolder = new File(parentPath + File.separator + "test");
            if(!tempFolder.exists()){
                tempFolder.mkdir();
            }
            for(int i=0;i<splitSize;i++){
                littleFiles[i] = new File(tempFolder.getAbsolutePath() + File.separator + i + ".txt");
                if(littleFiles[i].exists()){
                    littleFiles[i].delete();
                }
                try {
                    pws[i] = new PrintWriter(littleFiles[i]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            try {
                reader = new BufferedReader(new FileReader(file));
                String tempString = null;
                while ((tempString = reader.readLine()) != null) {
                    tempString = tempString.trim();
                    if(tempString != ""){
                        //�ؼ��ǽ�ÿ������hashȡģ֮��ŵ���Ӧȡģֵ���ļ��У�ȷ��hashֵ��ͬ���ַ�������ͬһ���ļ�����
                        int index = Math.abs(tempString.hashCode() % splitSize);
                        pws[index].println(tempString);
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
                for(int i=0;i<splitSize;i++){
                    if(pws[i] != null){
                        pws[i].close();
                    }
                }
            }
            return littleFiles;
        }

        /**
         * ��С�ļ�����ȥ�غϲ�
         * @param littleFiles �и�֮���С�ļ�����
         * @param distinctFilePath ȥ��֮����ļ�·��
         * @param splitSize С�ļ���С
         */
        public static void distinct(File[] littleFiles,String distinctFilePath,int splitSize){
            File distinctedFile = new File(distinctFilePath);
            FileReader[] frs = new FileReader[splitSize];
            BufferedReader[] brs = new BufferedReader[splitSize];
            PrintWriter pw = null;
            try {
                if(distinctedFile.exists()){
                    distinctedFile.delete();
                }
                distinctedFile.createNewFile();
                pw = new PrintWriter(distinctedFile);
                Set<String> unicSet = new HashSet<String>();
                for(int i=0;i<splitSize;i++){
                    if(littleFiles[i].exists()){
                        System.out.println("��ʼ��С�ļ���" + littleFiles[i].getName() + "ȥ��");
                        frs[i] = new FileReader(littleFiles[i]);
                        brs[i] = new BufferedReader(frs[i]);
                        String line = null;
                        while((line = brs[i].readLine())!=null){
                            if(line != ""){
                                unicSet.add(line);
                            }
                        }
                        for(String s:unicSet){
                            pw.println(s);
                        }
                        unicSet.clear();
                        System.gc();
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e1){
                e1.printStackTrace();
            } finally {
                for(int i=0;i<splitSize;i++){
                    try {
                        if(null != brs[i]){
                            brs[i].close();
                        }
                        if(null != frs[i]){
                            frs[i].close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //�ϲ����֮��ɾ����ʱС�ļ�
                    if(littleFiles[i].exists()){
                        littleFiles[i].delete();
                    }
                }
                if(null != pw){
                    pw.close();
                }
            }
        }
        public static List<String> getIps(String ipString){
            String regEx="((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
            List<String> ips = new ArrayList<String>();
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(ipString);
            while (m.find()) {
                String result = m.group();
                ips.add(result);
            }
            return ips;
        }
        public static void main(String[] args) throws IOException {
            int splitSize = 20;
            File[] files = splitFile("G://test/bigfile.txt",splitSize);
            distinct(files,"G://test/bigfile-distinct.txt",splitSize);
        }

    /**
     * description: �����ļ�����hashȥģ�ķ�ʽ���в��
     * �������뷶���� ԭʼ�ļ�filePath:src/test/resources/test ģ��СbatchSize:128 ����ļ���outputDirPatch: src/test/resources/
     * @return void
     * @param filePath
     * @param batchSize
     * @param outputDirPatch
     */
    public void splitFileFuntion(String filePath, Integer batchSize, String outputDirPatch){
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
            Pattern pattern = Pattern.compile(ip);
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                // �鿴�Ƿ���ipv4 ��Ӧ��ip
                if(matcher.matches()) {
                    String fileName = String.valueOf(line.hashCode() % batchSize);
                    FileOutputStream fs = new FileOutputStream(new File(outputDirPatch + fileName));
                    PrintStream p = new PrintStream(fs);
                    p.println(line);
                    p.close();
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(String.format("split file internal error : %s", e.getMessage()));
        }
    }
}
