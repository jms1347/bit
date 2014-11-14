/* insert 실행
 *  ->	executeUpdate() 호출한다.
 *  리눅스에서는 한글 값이 꺠질 수 있다.
 *  해결책 => 연결정보에 문자집합을 설정해야한다.
 *  JDBC URL에 설정한다.
 *  	ex)jdbc : mysql://host:port/schema?
 */
package jdbc.Test14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc07 {

	public static void main(String[] args) throws Exception{
		
		Connection con = null;	//인터페이스를 구현한 클래스를 객체로 만들어 그것을 담는다.
		Statement stmt = null;
		
		try{
		//1. java.sql.Driver 구현체 로딩한다.
		Class.forName("com.mysql.jdbc.Driver"); //드라이버 로딩
		System.out.println("JDBC 드라이버 로딩됨");
		
		//2. DriverManager에게 Connection 객체를 부탁한다.
		con = DriverManager.getConnection(
				"jdbc:mysql://@localhost:3306/studydb" + "?useUnicode=true&characterEncoding=utf8",	
				//jdbc 접속을 위한 URL 정보, DBMS 마다 형식이 약간씩 다름.
				"study",	// 사용자 아이디
				"study"); // 사용자 암호
		System.out.println("DBMS에 연결됨.");
		
		//3. Statiment 객체 얻기
		stmt = con.createStatement();
		System.out.println("Statement 객체 준비 완료.");
		
		//4. SELECT문 실행하기 
		// => 서버에서 결과를 하나씩 가져오는 역할자를 리턴한다.
		// => 즉, java.sql.ResultSet 구현체를 리턴한다.
		stmt.executeUpdate("INSERT INTO PRODUCTS(PNAME,QTY,MKNO)"+
		" VALUES('넥서스9', 100, 6)");
		System.out.println("서버의 질의 완료.");
		
		//5. 결과 가져오기
		// => 현재 결과를 가져온 상태가 아님!

		}catch (Exception e){
			e.printStackTrace();
		}finally{

			try{stmt.close();} catch(Exception ex){}
			System.out.println("Statement 객체의 자원을 해제함.");
			try{con.close();} catch (Exception e){}
			System.out.println("DBMS와 연결 끊음");
		}
	}
}
