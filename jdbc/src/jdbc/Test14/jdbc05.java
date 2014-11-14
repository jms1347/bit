/* ResultSet 객체를 통해 서버에서 결과를 가져오기
 * 
 * next() => 서버에서 결과를 가져온다. 성공이면 true, 실패면 false.
 * getInt(컬럼명) 또는 getInt(컬럼인덱스) => 가져온 데이터의 컬럼값을 리턴한다.
 * getXXX() => 컬럼의 데이터 형에 따라 XXX 이름이 바뀐다.
 */
package jdbc.Test14;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc05 {

  public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      //1. java.sql.Driver 구현체 로딩한다.
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("JDBC 드라이버 로딩됨");
      
      //2. DriverManager에게 Connection 객체를 부탁한다.
      con = DriverManager.getConnection(
          /* jdbc 접속을 위한 URL 정보. DBMS 마다 형식이 약간씩 다르다.*/
          "jdbc:mysql://localhost:1111/studydb", 
          "study", /* 사용자 아이디 */
          "study"); /* 사용자 암호 */
      System.out.println("DBMS에 연결됨");
      
      //3. Statement 객체 얻기
      stmt = con.createStatement();
      System.out.println("Statement 객체 준비 완료.");
      
      //4. SELECT 문 실행하기
      // => 서버에서 결과를 하나씩 가져오는 역할자를 리턴한다.
      // => 즉, java.sql.ResultSet 구현체를 리턴한다.
      rs = stmt.executeQuery("SELECT * FROM PRODUCTS");
      System.out.println("서버에 질의 완료. ResultSet 준비 완료.");
      
      //5. 결과 가져오기
      // => 현재 결과를 가져온 상태가 아님!
      while (rs.next()) {
        // 결과를 가져왔다면 데이터는 ResultSet 객체에 들어 있다.
        System.out.print(rs.getInt("PNO") + ",");
        System.out.print(rs.getString("PNAME") + ",");
        System.out.print(rs.getInt("QTY") + ",");
        System.out.println(rs.getInt("MKNO"));
      }
      
    } catch (Exception ex) {
      ex.printStackTrace();
      
    } finally {
      try {rs.close();} catch (Exception ex) {}
      System.out.println("ResultSet 객체의 자원을 해제함.");
      
      try {stmt.close();} catch (Exception ex) {}
      System.out.println("Statement 객체의 자원을 해제함.");
      
      try {con.close();} catch (Exception ex) {}
      System.out.println("DBMS와 연결 끊음");
    }
  }

}


