package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 9999;
	private static final String SERVER_IP = "0.0.0.0";
	public static void main(String[] args) {
		ServerSocket serverSocket= null;
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(SERVER_IP,PORT),10);
			log("연결 기다림 "+hostAddress+":"+PORT);
			List<Writer> listWriters = new ArrayList<Writer>();
		
			while(true) {
				Socket socket = serverSocket.accept();
//				new ChatServerThread(socket).start();
				new ChatServerThread(socket, listWriters).start();

			}
		} catch (IOException e) {
			log("error : "+e);
		} 
	}
	
	public static void log(String string) {
		System.out.println("[chat server] : "+string);
	}
}