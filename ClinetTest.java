package ClientDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 用TCP模拟登陆
 */
public class ClinetTest {
		public static void main(String[] args) throws UnknownHostException, IOException {
			//创建客户端socket对象
			Socket s = new Socket("XTTK-20161224ZV", 9999);
			//获取用户名和密码，这里不用scanner了。
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("请输入用户名：");
			String usename = br.readLine();
			System.out.println("请输入密码：");
			String password = br.readLine();
			//获取输出流对象
			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			//写出数据
			out.println(usename);
			out.println(password);
			//获取返回信息！
			//获取输入流对象
			BufferedReader serverBr= new BufferedReader(new InputStreamReader(s.getInputStream()));
			//获取服务器返回的数据
			String result = serverBr.readLine();
			System.out.println(result);
			//释放资源
			s.close();
		}

		
}
