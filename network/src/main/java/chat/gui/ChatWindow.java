package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatWindow {
	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private BufferedReader bufferedReader;
	private PrintWriter printWriter;
	private String nickname;

	public ChatWindow(String nickname) {
		frame = new Frame(nickname);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.nickname = nickname;
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		// IOStream 받아오기
		// ChatClientThread 생성하고 실행
		bufferedReader = ChatClientApp.getBufferedReader();
		printWriter = ChatClientApp.getPrintWriter();

		new ChatClientThread().start();
		updateTextArea(nickname + "님이 참가하셨습니다.");
	}

	private void finish() {
		// quit protocol 구현
		// exit java(Application)
		printWriter.println("quit");
		System.exit(0);
		try {
			if (ChatClientApp.getSocket() != null && !ChatClientApp.getSocket().isClosed()) {
				ChatClientApp.getSocket().close();
			}

		} catch (IOException e) {
			ChatClientApp.log("error : " + e);
		}
	}

	private void sendMessage() {
		String message = textField.getText();
		System.out.println(message);

		textField.setText("");
		textField.requestFocus();

		if (message.equals("quit")) {
			finish();
		} else if (!message.equals("")) {
			printWriter.println("message:" + message);
		}
		// ChatClientThread 에서 서버로부터 받는 메세지가 있다 라고 하고
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private class ChatClientThread extends Thread {
		@Override
		public void run() {
			try {
				String info;
				while (true) {
					info = bufferedReader.readLine();
					System.out.println(info);
					updateTextArea(info);
					if (info == null) {
						ChatClientApp.log(info);
						break;
					}
				}
			} catch (IOException e) {
				ChatClientApp.log("error : " + e);
			}
		}
	}
}
