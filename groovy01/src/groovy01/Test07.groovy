package groovy01

// ���ǹ�
age = 70

if(age > 18) {
	println "����"
}else{
	println "û�ҳ�"
}

// ���� ������ : (����) ? A : B
println age > 18 ? "����" : "û�ҳ�"
println "--------------------------------"
// switch => ����, ���ڿ�, ��, ��ü
x = 3.14f
result = ""

switch (x) {
	case "aaa" : println "aaa�̴�." 
		break
	case "123" : println "123�� �ƴ����� break �� ��� ����"; break;
	case [1, 20, "ȫ�浿", true, 3.14f]:
		println "��... �ڹٿ����� �Ұ���!"
		break
}