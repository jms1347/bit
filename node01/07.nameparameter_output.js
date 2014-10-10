var http = require('http');
// 1. URL 모듈을 가져온다.
var url = require('url');

/* 
 요청 파라미터의 값 꺼내기
 	- 클라이언트가 보낸 데이터(요청 파라미터)
*/
http.createServer(function handler(req, res) {
	// 클라이언트가 보낸 name 파라미터 값을 변수에 저장하라!

	// 2. URL 정보를 분석한다.
	var urlMap = url.parse(req.url, true);
	
	//  3. 쿼리 객체에서 파라미터 값을 추출한다.
	var name = urlMap.query.name;

    res.writeHead(200, 'ok' ,{'Content-Type': 'text/html; charset=UTF-8'});
    res.write('<html><head><title>nameparameter 출력</title></head>');
    res.write('<body>');
    res.write('<h1> 안녕하세요. ' + name +'님</h1>)');
    res.write(' </body></html>');
    res.write('Hello World\n');
    res.end();
    console.log("okok");
	
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

