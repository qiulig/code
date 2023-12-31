package Buffer;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws Exception {
        InputStream fisa = new FileInputStream("./yunqiu/src/main/java/Buffer/fileTest.txt");
        InputStream fisb = new FileInputStream("./yunqiu/src/main/java/Buffer/fileTest.txt");

        SequenceInputStream sis = new SequenceInputStream(fisa,fisb);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("./yunqiu/src/main/java/Buffer/copy.txt"));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=sis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }

        bos.close();
        sis.close();
    }
}
