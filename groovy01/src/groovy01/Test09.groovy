package groovy01

// �ڹٽ�ũ��Ʈ�� each() �䳻
scores = ["ȫ�浿", 100, 80, 100]
// �޼��� ȣ���� �� ��ȣ�� ������ �� �ִ�.
scores.each{value -> println value}
println "-------------------------------------"

scores.eachWithIndex {value, index -> println value + "," +index}

// �޼��� ����
def plus(x,y){
	x + y // �� �� ������ ���� ����� ���ϵȴ�.
}
println "-------------------------------------"
int minus(int x, int y){
	return x - y;
}

println(plus(10, 20))	// �޼��� ȣ�� �� ��ȣ ��� -> ���� ����
println plus(100,200)	// �޼��� ȣ�� �� ��ȣ ���� -> �׷�� �⺻ ����
result = minus 100, 50	// ��ȣ ����
println result
println "-------------------------------------"

//Ŭ���� ����
multiple = {x,y -> 
	println "�̰��� Ŭ������!"
		println "��ȣ��! �׷���..."
		x*y}
//�ڹٽ�ũ��Ʈ�� ���� ������ ǥ���Ѵٸ�,
/*multiple = function(X,y){
	console.log("�̰��� Ŭ������!")
	console.log("��ȣ��...�׷���...")
	return x * y;
}*/
result = multiple 30, 20
println result
println multiple(30,20)
