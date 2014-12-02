<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 꺼내기</h1>
<%
//클라이언트에서 서버에 쿠키를 보낼 때 
// 응답 헤더에 포함해서 보낸다.
/*
Cookie: name=aaa; tel=111-1111; email="hong@test.com"; address=%EA%B0%95%EB%82%A8%EA%B5%AC; JSESSIONID=8402CCE9F56AD4366CB5BA4E47910382
*/
Cookie[] cookies = request.getCookies();
if (cookies != null) {
  for (Cookie cookie : cookies) { %>
<p><%=cookie.getName()%> : <%=URLDecoder.decode(cookie.getValue())%></p>      
<%}
}
%>
</body>
</html>











