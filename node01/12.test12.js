
/* 
 GET 요청과 POST 요청 구분하기
 - request.method 프로퍼티의 값을 확인하라!
 - 
 */

var http = require('http');
var url = require('url');
var qs = require('querystring');
//URL 다음에 오는 데이터

http.createServer(function handler(req, res) {


	if (req.method == 'GET') {
		console.log('get 요청');
		// URL 정보를 분석! => 특히 query string은 분해해서 객체로 만들기!
		
		
		var obj = url.parse(req.url,true);
		console.log('URL :',obj.href);
		console.log('경로 :',obj.pathname);
		console.log('경로외:', obj.search);
		console.log('쿼리 스트링을 객체로 변환: ', obj.query);
		
	} else{
		console.log('psot 요청')
	}
		
		

}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');


