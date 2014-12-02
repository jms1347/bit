<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setAttribute("postno", request.getParameter("postno"));
session.setAttribute("address", request.getParameter("address"));
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Form04.jsp" method="post">
회사: <input type="text" name="company"><br>
직위: <input type="text" name="position"><br>
<button>다음</button>
</form>
</body>
</html>

























