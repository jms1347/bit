<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 쿠키 만료일 지정하기 => 브라우저를 종료하더라도 만료일 기간 동안은 유지한다.
Cookie cookie1 = new Cookie("name", "aaa");
cookie1.setMaxAge(60);
Cookie cookie2 = new Cookie("tel", "111-1111");
cookie2.setMaxAge(60);

// 만료일 지정하지 않음 => 브라우저가 실행되는 동안만 유지된다.
Cookie cookie3 = new Cookie("email", "hong@test.com");
Cookie cookie4 = new Cookie("address", 
    URLEncoder.encode("강남구"));

response.addCookie(cookie1);
response.addCookie(cookie2);
response.addCookie(cookie3);
response.addCookie(cookie4);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 보내기</h1>
</body>
</html>






