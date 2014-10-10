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
	var v1 = parseInt(urlMap.query.v1);
	var op = urlMap.query.op;
	var v2 = parseInt(urlMap.query.v2);
	var result = 0;


    res.writeHead(200, 'ok' ,{'Content-Type': 'text/html; charset=UTF-8'});
    res.write('<html><head><title>nameparameter 출력</title></head>');
    res.write('<body>');
	if(urlMap.query.op == 'plus'|'+'){
		result = v1 + v2;
		op = '+';
		res.write('<h1>'+v1+' '+op+' '+v2+' = '+result+'</h1>');
	}else if(urlMap.query.op =='minus'|'-'){
		result = v1 - v2;
		op = '-';
		res.write('<h1>'+v1+' '+op+' '+v2+' = '+result+'</h1>');
	}else if(urlMap.query.op =='multiple'|'*'){
		result = v1 * v2;
		op = '*';
		res.write('<h1>'+v1+' '+op+' '+v2+' = '+result+'</h1>');
	}else if(urlMap.query.op =='divide'|'/'){
		result = v1 / v2;
		op = '/';
		res.write('<h1>'+v1+' '+op+' '+v2+' = '+result+'</h1>');
	}else{
		res.write('<h1>옵션을 잘못 선택하였습니다.</h1>');
		
	}
    
    res.write(' </body></html>');
    res.end();
    console.log("okok");
	
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');

