var http = require('http');
http.createServer(function handler(req, res) {
    res.writeHead(200, 'ok' ,{'Content-Type': 'text/plain'});
    res.end('Hello World\n');
    console.log("okok");
	
}).listen(1337, '192.168.0.4');
console.log('Server running at http://127.0.0.1:1337/');
