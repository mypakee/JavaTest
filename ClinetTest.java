package ClientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * ��TCPģ���½
 */
public class ClinetTest {
		public static void main(String[] args) throws UnknownHostException, IOException {
			//�����ͻ���socket����
			Socket s = new Socket("XTTK-20161224ZV", 9999);
			//��ȡ�û��������룬���ﲻ��scanner�ˡ�
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("�������û�����");
			String usename = br.readLine();
			System.out.println("���������룺");
			String password = br.readLine();
			//��ȡ���������
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			//д������
			out.println(usename);
			out.println(password);
			//��ȡ������Ϣ��
			//��ȡ����������
			BufferedReader serverBr= new BufferedReader(new InputStreamReader(s.getInputStream()));
			//��ȡ���������ص�����
			String result = serverBr.readLine();
			System.out.println(result);
			//�ͷ���Դ
			s.close();
		}

		
}
