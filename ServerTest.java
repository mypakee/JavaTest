package ClientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) throws IOException {
		//���������socket����
		ServerSocket ss = new ServerSocket(9999);
		//����
		Socket s =ss.accept();
		//��ȡ����������
		BufferedReader  br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//��ȡ�û���������
		String username = br.readLine();
		System.out.println(username);
		String password = br.readLine();
		System.out.println(password);
		
		//�ж��û������� �Ƿ���ȷ
		//�������ù̶������˺�����ʾ
		boolean flag = false ;
		if("bocai".equals(username)&&"123456".equals(password)){
			flag= true;
		}
		 //��ȡ���������
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		if(flag) {
			out.println("��½�ɹ���");
		}else {
			out.print("��½ʧ��");
		}
		s.close();  //�ͷ���Դ
		ss.close();//�����һ�㲻�ر� 
	}
	

}
