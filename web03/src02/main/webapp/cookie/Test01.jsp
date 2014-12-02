<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 기본 생성
//=> 만료일을 지정하지 않으면 브라우저가 실행되는 동안만 유지된다.
//=> 쿠키를 받을 수 있는 URL을 지정하지 않으면 현재 경로의 서블릿만 받을 수 있다.
Cookie cookie1 = new Cookie("name", "aaa");
Cookie cookie2 = new Cookie("tel", "111-1111");
Cookie cookie3 = new Cookie("email", "hong@test.com");
// 다중 바이트 문자를 보내는 경우 
// => URL 인코딩 해서 보낸다.
Cookie cookie4 = new Cookie("address", 
    URLEncoder.encode("강남구"));

// 쿠키 보내는 방법
// 응답헤더에 포함한다.
/*
Set-Cookie: name=aaa
Set-Cookie: tel=111-1111
Set-Cookie: email="hong@test.com"; Version=1
Set-Cookie: address=%EA%B0%95%EB%82%A8%EA%B5%AC

*/
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






