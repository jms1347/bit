<%@page import="java63.servlets.test05.domain.Product"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
JSP 액션 태그 => jsp:useBean 태그 사용
=> ServletRequest(request), HttpSession(session), 
   ServletContext(application), PageContext(page)로부터
  객체 꺼내기 또는 객체 생성

속성
id => 레퍼런스 변수
scope => 객체를 꺼낼 보관소 지정. page, request, session, application
class => 보관소에서 꺼낼 객체의 타입. 또는 객체 생성을 위한 타입.
type => 레퍼런스 변수의 타입
<jsp:useBean type="java.util.List" id="products" 
    class="java.util.ArrayList" scope="request"/>
=> 자바코드로 전환

java.util.List products = 
  (java.util.List)request.getAttributre("products");
if (products == null) {   
  products = new java.util.ArrayList();
}
 --%>
<h1>jsp:useBean 액션 태그</h1>
<p>태그를 이용하여 보관소에 저장된 객체를 꺼내거나, 
새로 객체를 생성하는 문법</p>

<h2>1. 빈 객체 생성</h2>
<jsp:useBean 
  type="java63.servlets.test05.domain.Product" 
  id="product"
  class="java63.servlets.test05.domain.Product" 
  scope="page"/>
<%-- 자바코드
Product product = (Product)pageContext.getAttribute("product");
if (product == null) {
  product = new Product();
} 
 --%>

제품명: <%=product.getName()%><br>
수량: <%=product.getQuantity()%><br>
제조사번호: <%=product.getMakerNo()%><br>  
<hr>

<h2>2. 빈 객체 생성(type 속성 생략)</h2>
<p>type 속성을 생략하면 class 속성을 사용한다.</p>
<jsp:useBean 
  id="product2"
  class="java63.servlets.test05.domain.Product" 
  scope="page"/>

제품명: <%=product2.getName()%><br>
수량: <%=product2.getQuantity()%><br>
제조사번호: <%=product2.getMakerNo()%><br>    

<h2>3. 빈 객체 생성(class 속성 생략)</h2>
<p>class 속성을 생략하면 보관소에서 객체를 찾을 수 없을 때, 
객체를 새로 생성하지 못한다. 오류 발생!</p>
<%
Product temp = new Product();
temp.setName("나 호갱이다.");
temp.setQuantity(200);
temp.setMakerNo(2);
pageContext.setAttribute("product3", temp);
%>
<jsp:useBean 
  type="java63.servlets.test05.domain.Product" 
  id="product3"
  scope="page"/>
<%--
Product product3 = (Product)pageContext.getAttribute("product3");
if (product3 == null) { // 객체 못찾으면 오류!
  throw new InstantiationException(....);
}
 --%>  

제품명: <%=product3.getName()%><br>
수량: <%=product3.getQuantity()%><br>
제조사번호: <%=product3.getMakerNo()%><br>    

</body>
</html>
















