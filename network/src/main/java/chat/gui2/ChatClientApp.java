package chat.gui2;

// chat package에 있는 ChatClientThread 상속하여 사용.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import chat.ChatClientThread;
import chat.ChatServer;

public class ChatClientApp {
	private static final String SERVER_IP = "0.0.0.0";
	private static Socket socket;
	private static PrintWriter printWriter;
	private static BufferedReader bufferedReader;
	
	public static Socket getSocket() {
		return socket;
	}

	public static PrintWriter getPrintWriter() {
		return printWriter;
	}

	public static BufferedReader getBufferedReader() {
		return bufferedReader;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nickname=null;
		String line=null;
		String name = null;
		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			// 2. socket 생성
			socket = new Socket();
			// 3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("conneted");
			// 4. reader/writer 생성
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			while (true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>");
				nickname = scanner.nextLine();

				if (!nickname.isEmpty()) {
					printWriter.println("join:" + nickname);
					break;
				}
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
				// 1. create socket
				// 2. connect to server
				// 3. get iostream
				// 4. join protocol 진행
			}

			System.out.println(nickname + "님이 입장하셨습니다.");
			line = bufferedReader.readLine();
			System.out.println(line);

			if ("join:ok".equals(line)) {
				new ChatWindow(nickname).show();
			}
		} catch (IOException e) {
			log("error1 : " + e);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
	}

	public static void log(String string) {
		System.out.println("[chat client] : " + string);
	}
}
