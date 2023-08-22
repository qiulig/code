package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client1 {
    public static void main(String[] args) {
        try {
            //�򱾻���4700�˿ڷ����ͻ�����
            Socket socket = new Socket("127.0.0.1", 4700);
            //��ϵͳ��׼�����豸����BufferedReader����
            BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
            //��Socket����õ��������������PrintWriter����
            PrintWriter os = new PrintWriter(socket.getOutputStream());
            //��Socket����õ�����������������Ӧ��BufferedReader����
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String readline;
            readline = sin.readLine(); //��ϵͳ��׼�������һ�ַ���
            //���ӱ�׼���������ַ���Ϊ "bye"��ֹͣѭ��
            while (!readline.equals("bye")) {
                //����ϵͳ��׼���������ַ��������Server
                os.println(readline);
                //ˢ���������ʹServer�����յ����ַ���
                os.flush();
                //��ϵͳ��׼����ϴ�ӡ������ַ���
                System.out.println("Client:" + readline);
                //��Server����һ�ַ���������ӡ����׼�����
                System.out.println("Server:" + is.readLine());
                readline = sin.readLine(); //��ϵͳ��׼�������һ�ַ���
            }
            sin.close();
            os.close(); //�ر�Socket�����
            is.close(); //�ر�Socket������
            socket.close(); //�ر�Socket
        } catch (Exception e) {
            e.printStackTrace();//������ӡ������Ϣ
        } finally {

        }

    }

}
