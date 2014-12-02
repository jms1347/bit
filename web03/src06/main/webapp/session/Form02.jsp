<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setAttribute("name", request.getParameter("name"));
session.setAttribute("tel", request.getParameter("tel"));
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Form03.jsp" method="post">
우편번호: <input type="text" name="postno"><br>
주소: <input type="text" name="address"><br>
<button>다음</button>
</form>
</body>
</html>

























