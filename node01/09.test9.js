
/* 
 GET 요청과 POST 요청 구분하기
 - request.method 프로퍼티의 값을 확인하라!
 - 
 */

var http = require('http');
// 1. URL 모듈을 가져온다.
var url = require('url');

http.createServer(function handler(req, res) {
	res.writeHead(200, 'ok', {
		'Content-Type' : 'text/html; charset=UTF-8'
	});
	res
			.write('<html><head><title>nameparameter 출력</title></head>');
	res.write('<body>');
	
	if (req.method == 'GET') {

		// 2. URL 정보를 분석한다.
		var urlMap = url.parse(req.url, true);

		// 3. 쿼리 객체에서 파라미터 값을 추출한다.
		var v1 = parseInt(urlMap.query.v1);
		var op = urlMap.query.op;
		var v2 = parseInt(urlMap.query.v2);
		var result = 0;

		
		if (urlMap.query.op == 'plus' | '+') {
			result = v1 + v2;
			op = '+';
			res.write('<h1>' + v1 + ' ' + op + ' ' + v2 + ' = '
					+ result + '</h1>');
		} else if (urlMap.query.op == 'minus' | '-') {
			result = v1 - v2;
			op = '-';
			res.write('<h1>' + v1 + ' ' + op + ' ' + v2 + ' = '
					+ result + '</h1>');
		} else if (urlMap.query.op == 'multiple' | '*') {
			result = v1 * v2;
			op = '*';
			res.write('<h1>' + v1 + ' ' + op + ' ' + v2 + ' = '
					+ result + '</h1>');
		} else if (urlMap.query.op == 'divide' | '/') {
			result = v1 / v2;
			op = '/';
			res.write('<h1>' + v1 + ' ' + op + ' ' + v2 + ' = '
					+ result + '</h1>');
		} else {
			res.write('<h1>옵션을 잘못 입력 하였습니다.</h1>');
		}
		
	} else{
		res.write(req.method +'요청을 지원하지 않습니다.');
	}
	
	res.write(' </body></html>');
	res.end();
	console.log("okok");

}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

