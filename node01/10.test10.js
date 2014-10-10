
/* 
 GET 요청과 POST 요청 구분하기
 - request.method 프로퍼티의 값을 확인하라!
 - 
 */

var http = require('http');
// 1. URL 모듈을 가져온다.
var url = require('url');
var qs = require('querystring');

http.createServer(function handler(req, res) {
	var v1;
	var op;
	var v2;
	var result =0;

	if (req.method == 'GET') {

		// 2. URL 정보를 분석한다.
		var urlMap = url.parse(req.url, true);

		// 3. 쿼리 객체에서 파라미터 값을 추출한다.
		v1 = parseInt(urlMap.query.v1);
		op = urlMap.query.op;
		v2 = parseInt(urlMap.query.v2);
		
		displayResult(req,res,v1,v2,op);
	
	} else{
		
		var messageBody = '';
		// data 이벤트는 클라이언트에서 데이터를 읽을 때마다
		// 일정 시간 또는 일정 크기 단위로 발생한다.
		// data 이벤트가 발생할 때마다 등록된 함수를 호출한다.
		// 따라서 개발자는 클라이언트가 보낸 데이터를 받고 싶으면
		// data 이벤트에 리스너를 등록하고, 리스너가 호출될 때
		// 넘어오는 파라미터 값을 보관하면 된다.
		req.on('data',function(chunk){
				messageBody += chunk;
		});
		
		req.on('end',function(){
			//console.log(messageBody);
			var paramMap = qs.parse(messageBody);
			/*console.log('v1 = ', paramMap.v1);
			console.log('op = ', paramMap.op);
			console.log('v2 = ', paramMap.v2);*/
			
			v1 = parseInt(paramMap.v1);
			v2 = parseInt(paramMap.v2);
			op = paramMap.op;
			result = paramMap.result;
			
			displayResult(req,res,v1,v2,op,result);
			});
		
	}
	
	

}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

function displayResult(req, res){
	res.writeHead(200, 'ok', {
		'Content-Type' : 'text/html; charset=UTF-8'
	});
	res.write('<html><head><title>nameparameter 출력</title></head>');
	res.write('<body>');
	
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
	
	res.write(' </body></html>');
	res.end();
}
