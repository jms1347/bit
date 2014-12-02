<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:<%=session.getAttribute("name") %><br>
전화:<%=session.getAttribute("tel") %><br>
우편번호:<%=session.getAttribute("postno") %><br>
주소:<%=session.getAttribute("address") %><br>
회사:<%=request.getParameter("company") %><br>
직위:<%=request.getParameter("position") %><br>
</form>
</body>
</html>

























