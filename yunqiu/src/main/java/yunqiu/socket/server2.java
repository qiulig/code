package yunqiu.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server2 {


    public static void main(String[] args) {
        server2 manager = new server2();
        manager.doListen();
    }

    public void doListen() {
        ServerSocket server;
        try {
            server = new ServerSocket(9991);
            while (true) {
                Socket client = server.accept();
                new Thread(new SSocket(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //����������
    class SSocket implements Runnable {

        Socket client;

        public SSocket(Socket client) {
            this.client = client;
        }

        public void run() {
            DataInputStream input;
            DataOutputStream output;
            try {
                input = new DataInputStream(client.getInputStream());
                output = new DataOutputStream(client.getOutputStream());
                String listMsg = input.readUTF();
                output.writeUTF("Receive:  " + listMsg + "    \r\n Thx...");
                System.out.println("Receive:   " + listMsg);
                listMsg = input.readUTF();
                output.writeUTF("Receive Second:  " + listMsg + "    \r\n Thx...");
                System.out.println("Receive Second:   " + listMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
