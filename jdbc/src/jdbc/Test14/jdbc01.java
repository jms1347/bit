/* 드라이버 로딩
 * 	-> JDBC 드라이버 정보를 담은 메인 클래스 로딩
 * 	-> java.sql.Driver 인터페이스를 구현한 클래스를 로딩해야 한다.
 *  -> 이 클래스를 통해 Connection 객체를 얻을 수 있다.
 *  -> 점조직 같은 형태이다.
 *  
 */
package jdbc.Test14;

import java.sql.DriverManager;

public class jdbc01 {

	public static void main(String[] args) throws Exception{
		//방법1. Class.forName() 사용
		Class.forName("com.mysql.jdbc.Driver"); //드라이버 로딩
		
		//방법2. Driver 클래스의 인스턴스를 만든 후에 명시적으로 등록하기
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		//방법2의 단점
		// -> 다른 DBMS로 접속하려면 코드를 변경해야 한다.
	}

}
