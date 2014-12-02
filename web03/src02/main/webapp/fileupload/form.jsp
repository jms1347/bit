<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
바이너리 데이터를 서버에 보내려면,
form의 enctype을 multipart/form-data 로 설정해야 한다.

멀티파트 형식의 요청 프로토콜  
예)
Remote Address:192.168.0.101:8080
Request URL:http://192.168.0.101:8080/web03/fileupload/upload.jsp
Request Method:POST
Status Code:200 OK
Request Headersview source
Accept:text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Accept-Encoding:gzip, deflate
Accept-Language:ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4
Cache-Control:max-age=0
Connection:keep-alive
Content-Length:86891
Content-Type:multipart/form-data; boundary=----WebKitFormBoundaryZfVRlApsbqPYDqA2
Cookie:JSESSIONID=670FA73D0E8DF6A9B593E25398D7F1C9

------WebKitFormBoundaryZfVRlApsbqPYDqA2
Content-Disposition: form-data; name="name"

윤보미
------WebKitFormBoundaryZfVRlApsbqPYDqA2
Content-Disposition: form-data; name="age"

22
------WebKitFormBoundaryZfVRlApsbqPYDqA2
Content-Disposition: form-data; name="photo"; filename="bomi.png"
Content-Type: image/png

여기에 바이너리 데이터가 있다!!!
------WebKitFormBoundaryZfVRlApsbqPYDqA2--
 --%>
<form action="upload.jsp" method = "post" 
	enctype="multipart/form-data">
이름: <input type = "text" name="name"><br>
나이: <input type = "text" name="age"><br>
사진: <input type = "file" name="photo"><br>
<button>등록</button>
</form>

</body>
</html>