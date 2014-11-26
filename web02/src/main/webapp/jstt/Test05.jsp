<%@page import="java63.servlets.test05.domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <h1>Core 태그 사용</h1>
<h2>c:redirect</h2>
<c:set var = "age" value="19"/>
<c:if test="${pageScope.age >=19 }">
	<c:redirect url = "http://www.youtube.com/watch?v=9txzvu6eQuw"/>
</c:if> --%>

<h2>fmt:parseDate</h2>
<p>특정 패턴을 지닌 문자열을 해석하여 java.util.Date 객체로 만든다.</p>
<fmt:parseDate var="date1" 
	value="11-25-2014" pattern="MM-dd-yyyy"/>
${date1 }<br>

<h2>fmt:formatDate</h2>
<p>java.util.Date 객체를 가지고 문자열로 만든다.</p>
<% pageContext.setAttribute("today", new java.util.Date()); %>
<fmt:formatDate value = "${pageScope.today }" pattern="yyyy/mm/dd"/>

</body>
</html>


























