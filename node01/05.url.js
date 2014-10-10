
/* 
URL 알아내기
	- request.url => URL 정보 추출
	  ex) GET /status?name=ryan HTTP/1.1\r\n
	  리턴 값 => /status?name=ryan
	- 
*/
var http = require('http');	//http 객체 가져오기
var url = require('url');	//url 객체 가져오기

http.createServer(function handler(req, res) {
    console.log(req,url);
    
    // url로부터 경로 정보와 데이터 정보를 분리하여 추출
    var urlInfoMap = url.parse(req.url);
    console.log('URL 전체내용 : ',urlInfoMap.href);
    console.log('경로정보 : ',urlInfoMap.pathname);
    console.log('데이터 : ',urlInfoMap.search);
    console.log('query string: ', urlInfoMap.query);
    
    
    res.writeHead(200, 'ok' ,{'Content-Type': 'text/html; charset=UTF-8'});
    res.write('<html><head><title>05.url 알아내기</title></head>');
    res.write('<body>');
    res.write('<h1> 오호라... 이것이 노드JS</h1>)');
    res.write('<p>자바스크립트만 제대로 배워도 서버측 애플리케이션을 개발할 수 있다.</p>');
    res.write(' </body></html>');
    res.write('Hello World\n');
    res.end();
    console.log("okok");
	
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

