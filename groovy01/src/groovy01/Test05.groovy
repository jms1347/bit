package groovy01

// ���� ����
//  1. dynamic type binding
def a = 20 // ���� �Ҵ��� �� Ÿ���� �����Ѵ�.
a = "��ȣ��"
b = "������" // def ��������

println a
println b
println "------------------------------------"

//  2. static type binding
//		-> ������ ������ �� Ÿ���� �����Ѵ�. ���� �Ұ�!
int a2;
char b2;

//a2 = "okok"; //����
//a2 = "20";   //����
a2 = 20;
b2 = 'A'
println a2
println b2
println "------------------------------------"

//���ڿ� �ڵ� ����ȯ
String a3;
a3 = "��ȣ��";
println a3
a3 = 200 // ���ڸ� ���ڿ��� �ڵ� ����ȯ�Ѵ�.binding
pirntln a3

// �ڹ� ��ü ���
java.util.Date today = new java.util.Date()
println today

//java.util ��Ű���� �ڵ����� ����Ʈ �߱� ������
//���� ��Ű������ �������� �ʾƵ� �ȴ�.
Date today2= new Date();
println today2;