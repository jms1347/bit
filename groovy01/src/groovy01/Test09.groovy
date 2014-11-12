package groovy01

// 자바스크립트의 each() 흉내
scores = ["홍길동", 100, 80, 100]
// 메서드 호출할 때 괄호를 생략할 수 있다.
scores.each{value -> println value}
println "-------------------------------------"

scores.eachWithIndex {value, index -> println value + "," +index}

// 메서드 정의
def plus(x,y){
	x + y // 맨 끝 문장의 실행 결과가 리턴된다.
}
println "-------------------------------------"
int minus(int x, int y){
	return x - y;
}

println(plus(10, 20))	// 메서드 호출 시 괄호 사용 -> 고유 문법
println plus(100,200)	// 메서드 호출 시 괄호 생략 -> 그루비 기본 문법
result = minus 100, 50	// 괄호 생략
println result
println "-------------------------------------"

//클로저 정의
multiple = {x,y -> 
	println "이것이 클로저다!"
		println "오호라! 그렇군..."
		x*y}
//자바스크립트로 위의 문장을 표현한다면,
/*multiple = function(X,y){
	console.log("이거이 클로저다!")
	console.log("오호라...그렇군...")
	return x * y;
}*/
result = multiple 30, 20
println result
println multiple(30,20)
