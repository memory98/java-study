package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class ChatClientThread extends Thread {
	private BufferedReader bufferedReader;

	public ChatClientThread(BufferedReader bufferedReader) {
		this.bufferedReader = bufferedReader;
	}

	@Override
	public void run() {
		try {
			String info = bufferedReader.readLine();
			System.out.println(info);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}