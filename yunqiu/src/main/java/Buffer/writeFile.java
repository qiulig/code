package Buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class writeFile {
    public static void main(String[] args) throws Exception {
        //�Զ��������·�����ļ�
        File f = new File("./leetcode/jobs/src/Buffer/fileTest.txt");
        //ѡ����  append:true
        FileOutputStream os = new FileOutputStream(f, true);
        String str = "  abcdefg";
        //�÷�����ֱ�ӽ�һ���ֽ�����д���ļ���; ��write(int n)��д��һ���ֽ�
        os.write(str.getBytes(StandardCharsets.UTF_8));
        //ˢ�»�����
        os.flush();
        //�ر�,�ͷ���Դ
        os.close();


        System.out.println("��һ���ļ���ȡ��д����һ���ļ�");
        //�ļ�������
        FileInputStream fis = new FileInputStream("./leetcode/jobs/src/Buffer/fileTest.txt");
        //�ļ������
        FileOutputStream fos = new FileOutputStream("./leetcode/jobs/src/Buffer/fileTest2.txt",true);
        byte[ ] buf = new byte[1024];
        int len = -1;
        while ((len=fis.read(buf))!=-1){
            fos.write(buf,0,len);
        }

        fis.close();
        fos.close();
    }
}
