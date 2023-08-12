package yunqiu.Buffer;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class readBuffer {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("./leetcode/jobs/src/Buffer/fileTest.txt");
        //（1）每次读取一个字符数组，效率高
        System.out.println("----（1）每次读取一个字符数组，效率高----");
        byte buff[] = new byte[1024];
        int len = 0;
        while ((len=fis.read(buff))!=-1){
            System.out.println(new String(buff,0,len));
        }


        System.out.println("----(2)每次读一个字符，效率低（会乱码）----");
        //（2）每次读一个字符，效率低（会乱码）
        FileInputStream fiss = new FileInputStream("./leetcode/jobs/src/Buffer/fileTest.txt");
        int ch;
        while ((ch=fiss.read())!=-1){
            System.out.print((char) ch);
        }
        System.out.println();


        System.out.println("----（3）创建的byte与流等大小，慎用，以防流过大，使创建字节数组失败----");
        //（3）创建的byte与流等大小，慎用，以防流过大，使创建字节数组失败
        FileInputStream fi = new FileInputStream("./leetcode/jobs/src/Buffer/fileTest.txt");
        byte[] buf = new byte[fi.available()];
        fi.read(buf);
        System.out.println(new String(buf));


        fis.close();


        //一个文件写到另一个文件
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
