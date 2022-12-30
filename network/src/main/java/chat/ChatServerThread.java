package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	List<Writer> listWriters;
	PrintWriter printWriter;
	BufferedReader bufferedReader;

	public ChatServerThread(Socket socket) {
		this.socket = socket;
	}

	public ChatServerThread(Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {
		try {
			// 1. Remote Host Infomation

			// 2. 스트림 얻기
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "URF-8"));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "URF-8"));

			// 3. 요청 처리
			while (true) {
				String request = bufferedReader.readLine();
				if (request == null) {
					log("클라이언트로부터 연결 끊김");
					break;
				}

				// 4. 프로토콜 분석

				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit();
				} else {
					ChatServer.log("에러 : 알 수 없는 요청(" + tokens[0] + ")");
				}

				if (request == null) {
					ChatServer.log("클라이너트로 부터 연결 끊김");
					doQuit(printWriter);
					break;
				}

			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doJoin(String nickName, Writer writer) {

			this.nickname = nickName;

			listWriters = new ArrayList<Writer>();

			String data = nickname + "님이 참여하였습니다.";
			broadcast(data);

			new ChatServerThread(socket, listWriters).start();

			addWriter(writer);

			printWriter.println("join:ok");

	}

	private void addWriter(Writer writer) {
		// synchronized 키워드는 여러 스레드가 하나의 공유 객체에 접근할 때, 동기화를 보장 해준다.
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
			}
		}
	}

	private void doMessage(String string) {

	}

	private void doQuit() {

	}

	private void doQuit(Writer writer) {
		removeWriter(writer);

		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {

	}

	public static void log(String string) {
		System.out.println("[chat server] : " + string);
	}
}
