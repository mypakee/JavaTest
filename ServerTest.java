package ClientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	public static void main(String[] args) throws IOException {
		//创建服务端socket对象
		ServerSocket ss = new ServerSocket(9999);
		//监听
		Socket s =ss.accept();
		//获取输入流对象
		BufferedReader  br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//获取用户名和密码
		String username = br.readLine();
		System.out.println(username);
		String password = br.readLine();
		System.out.println(password);
		
		//判断用户名密码 是否正确
		//这里是用固定密码账号做演示
		boolean flag = false ;
		if("bocai".equals(username)&&"123456".equals(password)){
			flag= true;
		}
		 //获取输出流对象
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		if(flag) {
			out.println("登陆成功！");
		}else {
			out.print("登陆失败");
		}
		s.close();  //释放资源
		ss.close();//服务端一般不关闭 
	}
	

}
