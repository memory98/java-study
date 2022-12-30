package chat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	public static final int PORT = 9999;
	public static void main(String[] args) {
		ServerSocket serverSocket= null;
		try {
			// 1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			
			// 2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress,PORT));
			log("연결 기다림 "+hostAddress+":"+PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void log(String string) {
		System.out.println("[chat server] : "+string);
	}
}
