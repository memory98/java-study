package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String line = scanner.nextLine();
				if (!line.equals("quit")) {
					InetAddress[] inetAddress = InetAddress.getAllByName(line);
					for (InetAddress inetAddresses : inetAddress) {
						System.out.println(inetAddresses);
					}
				} else {
					break;
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
