/* 컨넥션 객체 얻기
 * 	-> java.mysql.Driver 구현체를 통해서 얻을 수 있다.
 *  -> DriverManager에게 부탁하면, 
 *  	DriverManager 
 */
package jdbc.Test14;

import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc02 {

	public static void main(String[] args) throws Exception{
		Connection con = null;	//인터페이스를 구현한 클래스를 객체로 만들어 그것을 담는다.
		
		try{
		//1. java.sql.Driver 구현체 로딩한다.
		Class.forName("com.mysql.jdbc.Driver"); //드라이버 로딩
		System.out.println("JDBC 드라이버 로딩됨");
		
		//2. DriverManager에게 Connection 객체를 부탁한다.
		con = DriverManager.getConnection(
				"jdbc:mysql://@localhost:3306/studydb",	
				//jdbc 접속을 위한 URL 정보, DBMS 마다 형식이 약간씩 다름.
				"study",	// 사용자 아이디
				"study"); // 사용자 암호
		System.out.println("DBMS에 연결됨.");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{con.close();} catch (Exception e){}
			System.out.println("DBMS와 연결 끊음");
		}
	}

}
