package chat;

import java.net.Socket;

public class ChatClientThread extends Thread {
	private String nickname;
	private Socket socket;
	private String input;

	public ChatClientThread(Socket socket, String nickname, String input) {
		this.socket = socket;
		this.nickname = nickname;
		this.input = input;
	}

	@Override
	public void run() {
		System.out.println(nickname+":"+input);
	}

	
}
