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
			String info = null;
			while (true) {
				info = bufferedReader.readLine();

				System.out.println(info);
				if (info == null) {
					log(info);
					break;
				}
			}
		} catch (IOException e) {
			log("error3 : " + e);
		}
	}

	public static void log(String string) {
		System.out.println("[chat client] : " + string);
	}
}