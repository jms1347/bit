/* 클라이언트와 여러 번 데이터 주고 받기
 */
package net;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer03 {
	static Scanner keyboard = new Scanner(System.in);

		public static void main(String[] args) throws Exception{
			// 클라이언트와 통신을 담당할 객체 생성
			System.out.println("서버 소켓 생성");
			
			// 두 번째 backlog 값은 대기열 길이를 지정한다.
			ServerSocket ss = new ServerSocket(8888, 2);
			
			// 연결을 대기하고 있는 클라이언트들 중에서 하나 선택하기
			// => 선택한 클라이언트와의 통신을 담당할 Socket 객체를 리턴
			System.out.println("클라이언트의 연결을 기다리는 중...");
			Socket socket = ss.accept();
			System.out.println("대기중에 있는 클라이언트와 연결됨");
			
			//---------------------자바 네트워크 프로그램-----------------------------
			
			Scanner in = new Scanner(socket.getInputStream());
			PrintStream out = new PrintStream(socket.getOutputStream());
			
			// 클라이언트가 보낸 문자열 읽기
			// 클라이언트에서 한 줄의 문자열을 보내기 전까지 리턴하지 않는다.
			// "실행이 완료될 때가지 리턴하지 않는다" == blocking	
			String line = null;
			String message = null;
			while(true){
				line = in.nextLine();
				System.out.println(line);

				if(line.equalsIgnoreCase("quit")){
					out.println("goodbye");
					break;
				}
				
				message = prompt();
				out.println(message);
			}
			
			in.close();
			out.close();
			socket.close();
			ss.close();
			keyboard.close();

		}

		private static String prompt() {
			System.out.println(">");
			String message = keyboard.nextLine();
			return message;
		}

}
