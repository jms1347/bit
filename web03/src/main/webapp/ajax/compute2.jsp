<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
int a = Integer.parseInt(request.getParameter("a"));
int b = Integer.parseInt(request.getParameter("b"));
int result = 0;
switch (request.getParameter("op")) {
case "+": result = a + b; break;
case "-": result = a - b; break;
}
%>
<%=result%>








