<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
// 모든 클라이언트에 대해 AJAX 요청을 허락하기.
// 다음 응답 헤더를 붙이면, 서버가 보낸 결과를 클라이언트에서 꺼낼 수 있다.
response.setHeader("Access-Control-Allow-Origin", "*");

int a = Integer.parseInt(request.getParameter("a"));
int b = Integer.parseInt(request.getParameter("b"));
int result = 0;
switch (request.getParameter("op")) {
case "+": result = a + b; break;
case "-": result = a - b; break;
}
%>
<%=result%>








