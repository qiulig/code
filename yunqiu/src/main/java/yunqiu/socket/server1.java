package yunqiu.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server1 {
    public static void main(String args[]) {
        try {
            ServerSocket server = null;
            Socket socket = null;
            try {
                //����һ��ServerSocket�ڶ˿�4700�����ͻ�����
                server = new ServerSocket(4700);
                //ʹ��accept()�����ȴ��ͻ������пͻ�
                socket = server.accept();//�����������һ��Socket���󣬲�����ִ��
            } catch (Exception e) {
                e.printStackTrace();//������ӡ������Ϣ
            }

            String line;
            //��Socket����õ�����������������Ӧ��BufferedReader����
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //��Socket����õ��������������PrintWriter����
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            //��ϵͳ��׼�����豸����BufferedReader����
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            //�ڱ�׼����ϴ�ӡ�ӿͻ��˶�����ַ���
            System.out.println("Client:" + is.readLine());
            //�ӱ�׼�������һ�ַ���
            line = sin.readLine();
            //������ַ���Ϊ "bye"����ֹͣѭ��
            while (!line.equals("bye")) {
                //��ͻ���������ַ���
                os.println(line);
                //ˢ���������ʹClient�����յ����ַ���
                os.flush();
                //��ϵͳ��׼����ϴ�ӡ������ַ���
                System.out.println("Server:" + line);
                //��Client����һ�ַ���������ӡ����׼�����
                System.out.println("Client:" + is.readLine());
                //��ϵͳ��׼�������һ�ַ���
                line = sin.readLine();
            }

            os.close(); //�ر�Socket�����
            is.close(); //�ر�Socket������
            socket.close(); //�ر�Socket
            server.close(); //�ر�ServerSocket
        } catch (Exception e) {
            e.printStackTrace();//������ӡ������Ϣ
        }
    }
}
