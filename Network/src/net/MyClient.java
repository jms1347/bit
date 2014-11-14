package net;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		System.out.println("서버와 연결중....");
		Socket socket = new Socket("192.168.0.28", 8888);
		System.out.println("서버와 연결 성공!");
		
		Scanner in = new Scanner(socket.getInputStream());
		PrintStream out = new PrintStream(socket.getOutputStream());
		
		String message = null;
		String line = null;	
		while(true){
			message = prompt();
			out.println(message); 	
			
			line = in.nextLine();	
			System.out.println(line);
			if(line.equalsIgnoreCase("goodbye")){
				System.out.println("서버와 연결을 끊었습니다.");
				break;
			}
		}
		
		in.close();
		out.close();
		socket.close();
		keyboard.close();

		}
		private static String prompt() {
			System.out.println(">");
			String message = keyboard.nextLine();
			
			return message;
		}

}
