package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		try {
			socket = new Socket();

			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			log("conneted");

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true); // true
																												// 바로
																												// 출력.
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

			scanner = new Scanner(System.in);

			while (true) {
				System.out.print(">");
				String line = scanner.nextLine();

				if ("exit".equals(line)) {
					break;
				}
				pw.println(line);
				String data = br.readLine();
				if (data == null) {
					log("closed by server");
					break;
				}

				System.out.println("<" + data);
			}
		} catch (SocketException ex) {
			System.out.println("[server] suddenly closed by server");
		} catch (IOException ex) {
			log("error : " + ex);
		} finally {
			try {
				if (socket != null && !socket.isClosed()) {
					socket.close();
				}
				if (scanner != null) {
					scanner.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void log(String message) {
		System.out.println("[EchoClient] " + message);
	}
}
