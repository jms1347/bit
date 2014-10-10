
/* 
 GET 요청과 POST 요청 구분하기
 - request.method 프로퍼티의 값을 확인하라!
 - 
 */

var http = require('http');
var url = require('url');
var qs = require('querystring');

http.createServer(function handler(req, res) {


	if (req.method == 'GET') {
		console.log('get 요청');
		
	} else{
		console.log('psot 요청')
	}
		
		

}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');


