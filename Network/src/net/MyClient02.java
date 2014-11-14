package net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient02 {
	
	public static void main(String[] args) throws IOException {
		System.out.println("서버와 연결중....");
		// 서버와 연결할 소켓 생성
		// 서버와의 연결이 이루어지면 리턴한다.
		Socket socket = new Socket("192.168.0.173", 8888);
		System.out.println("서버와 연결 성공!");
		
		Scanner in = new Scanner(socket.getInputStream());
		PrintStream out = new PrintStream(socket.getOutputStream());
		// 서버에 보낼 메시지를 사용자에게서 입력 받는다.
		String message = prompt();
		
		// 서버에 메시지를 보낸다.
		out.println(message); // 서버가 데이터를 모두 읽을 때까지 리턴하지 않는다.
		
		// 서버가 보낸 메시지를 읽는다.
		String line = in.nextLine();	// 서버가 문자열 한 줄을 보낼 때까지 리턴하지 않음.
		
		// 서버가 보낸 메시지를 출력
		System.out.println(line);
		
		in.close();
		out.close();
		socket.close();

		}
		private static String prompt() {
			System.out.println(">");
			Scanner keyboard = new Scanner(System.in);
			String message = keyboard.nextLine();
			keyboard.close();
			
			return message;
		}

}
