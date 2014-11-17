package java02.test19.server;

import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java02.test19.server.CommandMapping.CommandInfo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ProductMgtServer {
  
  Scanner scanner; 
  ApplicationContext appCtx;
  CommandMapping commandMapping;
  
  public void init() throws Exception {
    String resource = "java02/test19/server/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = 
        new SqlSessionFactoryBuilder().build(inputStream);
    
    scanner = new Scanner(System.in);
    
    // java02.test19.server 패키지 및 하위 패키지의 모든 클래스를 뒤진다.
    // @Component 애노테이션이 붙은 클래스를 찾는다.
    // 해당 클래스의 인스턴스를 생성하여 보관한다.
    appCtx = new ApplicationContext("java02.test19.server");
    appCtx.addBean("sqlSessionFactory", sqlSessionFactory);
    appCtx.injectDependency();
    
    // objPool에서 @Command 애노테이션이 붙은 메서드를 찾는다.
    // 명령어와 메서드 연결 정보를 구축한다.
    commandMapping = new CommandMapping();
    commandMapping.prepare(appCtx.getAllBeans());
  }
  
  class ServiceThread extends Thread {
    Socket socket;
    Scanner in;
    PrintStream out;
    
    public ServiceThread(Socket socket) throws Exception {
      this.socket = socket;
      in = new Scanner(socket.getInputStream());
      out = new PrintStream(socket.getOutputStream());
    }
    
    private void parseQueryString(
        String query, HashMap<String,Object> map) {
      //예) query :  name=제품명&qty=20&mkno=6
      // ==> {"name=제품명","qty=20","mkno=6"}
      String[] entryList = query.split("&");
      String[] token = null;
      
      for (String entry : entryList) {
        token = entry.split("="); // 예)name=제품명
        map.put(token[0], token[1]);
      }
    }
    
    @Override
    public void run() {
      CommandInfo commandInfo = null;
      try {
        String[] token = in.nextLine().split("\\?");
        commandInfo = commandMapping.getCommandInfo(token[0]);
        
        if (commandInfo == null) {
          out.println("해당 명령을 지원하지 않습니다.");
          out.println();
          return;
        }
        
        HashMap<String,Object> params = 
            new HashMap<String,Object>();
        
        params.put("out", out);
        
        if (token.length > 1) {
          parseQueryString(token[1], params);
        }
        
        commandInfo.method.invoke(commandInfo.instance, params);
        
      } catch (Exception e) {
        e.printStackTrace();
        out.println("명령어 처리 중 오류 발생. 다시 시도해 주세요.");
        out.println();
        
      } finally {
        try {in.close();} catch (Exception e) {}
        try {out.close();} catch (Exception e) {}
        try {socket.close();} catch (Exception e) {}
      }
    }
  }
  
  @SuppressWarnings("resource")
  public void service() throws Exception {
    ServerSocket serverSocket = new ServerSocket(8888);
    Socket socket = null;
    
    while (true) {
      socket = serverSocket.accept();
      new ServiceThread(socket).start();
    }
  }
  
  public void destroy() {
    scanner.close();
  }

  public static void main(String[] args) throws Exception {
    ProductMgtServer app = new ProductMgtServer();
    app.init();
    app.service();
    app.destroy();
  }

}







