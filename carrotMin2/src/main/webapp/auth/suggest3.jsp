<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MySQL DB연결</title>
</head>
<BODY>
<h3> DB 연결 테스트</h3>

<%
request.setCharacterEncoding("UTF-8");

//1. 사용자가 입력한 값을 가져오기 
String keyword = request.getParameter("q");
if(keyword == null || keyword.equals("")){
	return;
}

keyword = keyword.toUpperCase();


	String url = "jdbc:mysql://localhost:1111/carrotdb";
	String user = "root";
	String pwd = "1111";
	Connection conn=DriverManager.getConnection(url,user,pwd);
	
	String sql = "select * from search where keyword LIKE ? ";
	PreparedStatement ps= null;
	ps = conn.prepareStatement(sql);
	ps.setString(1, keyword+"%");
	
	ResultSet rs = null;
	rs = ps.executeQuery();
	List list = new ArrayList();
	
	if(conn!=null){
		out.println("carrotdb DB로 연결 성공");
		
		/* conn.close(); */
		
		
		
		out.println("carrotdb DB 연결을 끊었습니다.");
		
		
	} else {
		out.println("carrotdb DB로 연결 실패!");
	}
	for(int i=0; i<list.size(); i++){
		out.println(list.get(i));
		System.out.println(list.get(i));
	}
%>
</BODY>
</html>


