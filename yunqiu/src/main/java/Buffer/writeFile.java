package Buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class writeFile {
    public static void main(String[] args) throws Exception {
        //自动创建相对路径下文件
        File f = new File("./leetcode/jobs/src/Buffer/fileTest.txt");
        //选择流  append:true
        FileOutputStream os = new FileOutputStream(f, true);
        String str = "  abcdefg";
        //该方法是直接将一个字节数组写入文件中; 而write(int n)是写入一个字节
        os.write(str.getBytes(StandardCharsets.UTF_8));
        //刷新缓存区
        os.flush();
        //关闭,释放资源
        os.close();


        System.out.println("从一个文件读取，写到另一个文件");
        //文件输入流
        FileInputStream fis = new FileInputStream("./leetcode/jobs/src/Buffer/fileTest.txt");
        //文件输出流
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
