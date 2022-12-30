package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import echo.EchoServer;

public class ChatClient {
	private static final String SERVER_IP = "0.0.0.0";

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			// 2. socket 생성
			socket = new Socket();
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("conneted");
			// 4. reader/writer 생성
			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			printWriter.println("join:"+nickname);
			
			// 6. ChatClientReceiveThread 시작
			
			
			// 7. 키보드 입력 처리
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input)==true) {
					// 8. quit 프로토콜 처리
					break;
				} else {
					// 9. 메시지 처리
					new ChatClientThread(socket,nickname,input);
				}
			}
		} catch(IOException e) {
			log("error : "+e);
		} finally {
			if(scanner != null) {
				scanner.close();
			}
			if(socket!= null && !socket.isClosed()) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void log(String string) {
		System.out.println("[chat client] : "+string);
	}
	
}
