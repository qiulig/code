package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client2 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9991);
            //��������˵�һ�η����ַ���
            OutputStream netOut = socket.getOutputStream();
            DataOutputStream doc = new DataOutputStream(netOut);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            //��������˵ڶ��η����ַ���
            doc.writeUTF("list");
            String res = in.readUTF();
            System.out.println(res);
            doc.writeUTF("bye");
            res = in.readUTF();
            System.out.println(res);
            doc.close();
            in.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
