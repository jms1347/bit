package groovy01

// �ݺ���
i = 0
while (i < 10){
	print i + ","
	i++
}
println "\n-------------------------------"
// for ��
for(int i = 0; i < 5; i++)
	print i + ","
	println "\n-------------------------------"
for (k in 0..6) print k + ","
println "\n-------------------------------"
for(i in [100, 90, 80, "ȫ�浿", true]) {
	println i
	print ","
}
println "\n-------------------------------"
for(c in "��ȣ��.. �׷�����") print c + ","
println "\n-------------------------------"

map = ["name" : "ȫ�浿", "kor":100, "eng":90, "math":100];
for(e in map) println e.key + "," + e.value

println "\n-------------------------------"
for (v in map.values()) print v + ","
