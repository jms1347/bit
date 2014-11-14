package net3;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
  static Scanner keyboard;
  
  public static void main(String[] args) {
    ServerSocket ss = null;
    Socket socket = null;
    PrintStream out = null;
    Scanner in = null;
    
    try {
      keyboard = new Scanner(System.in);
      ss = new ServerSocket(8888);
      socket = ss.accept();
      
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
      
      ChatReaderThread readerThread = new ChatReaderThread(in);
      readerThread.start();
      
      String message = null, line = null;
      while (true) {
        line = prompt();
        out.println(line);
      }
      
    } catch (Exception e) {
      // 오류 무시
    } finally {
      try {in.close();} catch (Exception e) {} 
      try {out.close();} catch (Exception e) {}
      try {socket.close();} catch (Exception e) {}
      try {ss.close();} catch (Exception e) {}
      try {keyboard.close();} catch (Exception e) {}
    }
  }
  
  private static String prompt() {
    System.out.print(">");
    String message = keyboard.nextLine();
    return message;
  }

}













