/* Ŭ���� ����� 
 * 1. class Ű����� Ŭ������ �������� ������,
 * 		���ϸ��� Ŭ���� �̸����� ����Ѵ�.
 * 2. �ۼ��� ��ɾ�� run() �޼��� �ȿ� ������� ����.
 * 3. �޼��� ������ �ش� Ŭ������ ����ȴ�.
 * 4. main() �޼��带 �ڵ����� �����.
 * 5. main()���� run()�� ȣ���Ѵ�.
 * */
package groovy01

a = 20
println a
println plus(10, 20)
System.out.println( minus(10, 20));

def plus(x, y) {
	x + y
}

public int minus(int x, int y){
	return x - y;
}
println "����Ϸ�"