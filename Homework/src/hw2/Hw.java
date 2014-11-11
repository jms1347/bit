package hw2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Hw {

	static Scanner sc = new Scanner(System.in);
	static Statement stmt = null;
	static Connection con = null;
	static ResultSet rs = null;

	public static void main(String[] args) throws SQLException {    
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
	      while(true){
			System.out.print("명령> ");
			String[] command = sc.nextLine().split(" ");

			switch (command[0]) {
			case "add":
				add();
				break;

			case "list":
				list();
				break;

			case "update":
				update(command[1]);
				break;

			case "delete":
				delete(command[1]);
				break;
			}
	      }

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			try {
				stmt.close();
			} catch (Exception ex) {
			}
			System.out.println("Statement 객체의 자원을 해제함.");

			try {
				con.close();
			} catch (Exception ex) {
			}
			System.out.println("DBMS와 연결 끊음");
		}
		
	}

	public static void delete(String command) throws SQLException {

		int index = Integer.parseInt(command);
		rs = stmt.executeQuery("SELECT PNAME FROM PRODUCTS WHERE PNO =" + index);

		// System.out.println(rs.getInt());

		while (rs.next()) {
			System.out.println(rs.getString("PNAME") + "를 삭제하시겠습니까? (y/n)");
		}

		if (sc.nextLine().equalsIgnoreCase("y")) {

			stmt.executeUpdate("DELETE FROM PRODUCTS "
			+ "WHERE PNO =(" + index + ")");
			System.out.println("삭제했습니다.");
		} else {
			System.out.println("삭제 취소했습니다.");
		}
	}

	public static void update(String command) throws SQLException {
		int index = Integer.parseInt(command);
		String pname = null;
		int qty = 0;
		int mkno = 0;
		rs = stmt.executeQuery("SELECT PNAME,QTY,MKNO FROM PRODUCTS WHERE PNO ="
						+ index);

		while (rs.next()) {
			System.out.print("제품명(" + rs.getString("PNAME") + ")? ");
			pname = sc.nextLine();
			System.out.print("수량(" + rs.getInt("QTY") + ")? ");
			qty = Integer.parseInt(sc.nextLine());
			System.out.print("제조사(" + rs.getInt("MKNO") + ")? ");
			mkno = Integer.parseInt(sc.nextLine());

			if (mkno > 0 & mkno < 7) {
				stmt.executeUpdate("UPDATE PRODUCTS SET" +
				" PNAME='" + pname + "', QTY= " + qty + ", MKNO= " + mkno +
				" WHERE PNO=" + index);
				System.out.println("변경하였습니다.");
				continue;

			} else {
				System.out.println("1번 - 애플");
				System.out.println("2번 - 삼성");
				System.out.println("3번 - LG");
				System.out.println("4번 - IBM");
				System.out.println("5번 - 인텔");
				System.out.println("6번 - 구글");
				System.out.println("1부터 6까지 숫자를 입력해 주세요");
				continue;
			}
		}
		rs.close();
	}

	public static void list() throws SQLException {

		String pno = "번호";
		String product = "제품명";
		String qty = "수량";
		String maker = "제조사";
		System.out.printf("%-3s %10s %-7s %-10s\n", pno, product, qty, maker);

		rs = stmt.executeQuery("SELECT * FROM PRODUCTS");
		while (rs.next()) {
			System.out.printf("%-3s %10s %-7d %-10d\n", rs.getInt("PNO"),
					rs.getString("PNAME"),
					rs.getInt("QTY"), rs.getInt("MKNO"));
		}
	}

	public static void add() throws SQLException {

		String product;
		int amount;
		int mkno;
		System.out.print("제품명: ");
		product = sc.nextLine();
		System.out.print("수량: ");
		amount = Integer.parseInt(sc.nextLine());
		System.out.print("제조사: ");
		mkno = Integer.parseInt(sc.nextLine());

		System.out.print("저장하시겠습니까?(y/n)");

		if (sc.nextLine().equalsIgnoreCase("y")) {
			System.out.println(product + amount + mkno);
			stmt.executeUpdate("INSERT INTO PRODUCTS(PNAME,QTY,MKNO)" +
			" VALUES('" + product + "', " + amount + ", " + mkno + ")");
			System.out.println("저장하였습니다.");
		} else {
			System.out.println("저장 취소하였습니다.");
		}
	}
}