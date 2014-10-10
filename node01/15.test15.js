
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
		// 쿼리 객체에서 요청 값을 꺼낸다
		
		var v1 = parseInt(obj.query.v1,10);
		var v2 = parseInt(obj.query.v2,10);
		var op = obj.query.op;
		
		var result = compute(v1, op ,v2);
		
		console.log(v1,op,v2,'=',result);
	} else{
		console.log('post 요청')
	}
	res.end();
		
		

}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

function compute(v1, op, v2){
	switch(op){
	case 'plus' : return v1 + v2; 
	case 'minus' : return v1 - v2; 
	case 'multiple' :return v1 * v2; 
	case 'divide' : return v1 / v2; 
	default:console.log('해당 연산자를 지원하지 않습니다.');
	}
	return 0;
}

