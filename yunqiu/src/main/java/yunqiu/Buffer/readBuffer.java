package yunqiu.Buffer;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class readBuffer {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("./leetcode/jobs/src/Buffer/fileTest.txt");
        //��1��ÿ�ζ�ȡһ���ַ����飬Ч�ʸ�
        System.out.println("----��1��ÿ�ζ�ȡһ���ַ����飬Ч�ʸ�----");
        byte buff[] = new byte[1024];
        int len = 0;
        while ((len=fis.read(buff))!=-1){
            System.out.println(new String(buff,0,len));
        }


        System.out.println("----(2)ÿ�ζ�һ���ַ���Ч�ʵͣ������룩----");
        //��2��ÿ�ζ�һ���ַ���Ч�ʵͣ������룩
        FileInputStream fiss = new FileInputStream("./leetcode/jobs/src/Buffer/fileTest.txt");
        int ch;
        while ((ch=fiss.read())!=-1){
            System.out.print((char) ch);
        }
        System.out.println();


        System.out.println("----��3��������byte�����ȴ�С�����ã��Է�������ʹ�����ֽ�����ʧ��----");
        //��3��������byte�����ȴ�С�����ã��Է�������ʹ�����ֽ�����ʧ��
        FileInputStream fi = new FileInputStream("./leetcode/jobs/src/Buffer/fileTest.txt");
        byte[] buf = new byte[fi.available()];
        fi.read(buf);
        System.out.println(new String(buf));


        fis.close();


        //һ���ļ�д����һ���ļ�
        FileInputStream in = new FileInputStream("./leetcode/jobs/src/Buffer/fileTest.txt");
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("./leetcode/jobs/src/Buffer/fileTestt.txt"));

        byte[] bytes = new byte[1024];
        int lens = 0;
        while ((lens=in.read(bytes))!=-1){
            out.write(bytes,0,lens);
        }

        in.close();
        out.close();


    }
}
