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

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
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
//		textField.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		});

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
		
		
	}

	private void finish() {
		// quit protocol 구현
		
		
		// exit java(Application)
		System.exit(0);

	}

	private void sendMessage() {
		String message = textField.getText();
		System.out.println(message);

		textField.setText("");
		textField.requestFocus();
		
		// ChatClientThread 에서 서버로부터 받는 메세지가 있다 라고 하고
		updateTextArea(message);
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private class ChatClientThread extends Thread {
		private BufferedReader bufferedReader;

		public ChatClientThread(BufferedReader bufferedReader) {
			this.bufferedReader = bufferedReader;
		}
		@Override
		public void run() {
			//String message = br,readLine();
			try {
				updateTextArea("....");
				String info = bufferedReader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
