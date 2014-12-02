<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.setAttribute("name", "홍길동");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>세션 생성</h1>
<p>웹 브라우저가 처음으로 서블릿이나 JSP를 요청하게 되면<br>
(요청 헤더의 쿠키 정보에 세션 아이디가 없거나, <br>
세션 아이디가 있더라도 그 아이디의 세션이 무효하다면)<br>
서블릿 컨테이너는 그 웹 브라우저를 위한 새 세션 객체를 준비한다.</p>
<p>그리고 그 세션 객체의 ID를 쿠키로 보낸다.</p>
<p>웹 브라우저는 서버에 요청할 때마다 서버에서 받은 세션 아이디를 
요청 헤더에 첨부하여 보낸다</p> 
</body>
</html>















