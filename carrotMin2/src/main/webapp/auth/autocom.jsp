<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ page import="java.util.*" %>

<%@ page import="java.sql.*" %>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div data-role="fieldcontain" id="code_div">
		<label for=text id="code_label">납품업체 코드</label> <input type="search"
			name="mcode" id="mcode" placeholder="납품업체의 코드를 입력해주세요." />
	</div>
	<%
	request.setCharacterEncoding("utf-8");

	
	String keyword = request.getParameter("mcode");
	if(keyword==null || keyword.equals("")){
		return;
	}
	
	keyword=keyword.toUpperCase();
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	List list = new ArrayList();
	try{
	    Class.forName("com.mysql.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://localhost:1111/carrotdb?useUnicode=true&amp;characterEncoding=utf8","root","1111");
	    String sql = "select scname from supplier where keyword like ?";

	    ps = con.prepareStatement(sql);
	    ps.setString(1, keyword+"%");
	    rs = ps.executeQuery();
	    while(rs.next()){
	    	list.add(rs.getString("keyword"));
	    }//while

	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(rs!=null)try{rs.close();} catch(Exception e){}
		if(ps!=null)try{ps.close();} catch(Exception e){}
		if(con!=null)try{con.close();} catch(Exception e){}

	}//finally

    for(int i = 0; i<list.size();i++){
    	out.println(list.get(i));
    	System.out.println(list.get(i));
    }//for
    %>

</body>
</html>