package hw1;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Test03 {

	static ArrayList<Score> list = new ArrayList<Score>();

	static class Score implements Serializable {
		String name;
		int kor;
		int eng;
		int math;

		public Score() {
		}

		public Score(String name) {
			this.name = name;
		}

		public Score(String name, int kor, int math, int eng) {
			this.name = name;
			this.kor = kor;
			this.math = math;
			this.eng = eng;
		}

		public int size() {
			return 0;
		}
	}

	public static void main(String[] args) throws Exception {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("���> ");
			String command2 = sc.nextLine();
			String[] command = command2.split(" ");

			switch (command[0]) {
			case "help":
				help();
				break;
			case "list":
				list();
				break;
			case "view":
				view(Integer.parseInt(command[1]));
				break;
			case "add":
				add(command[1], Integer.parseInt(command[2]),
						Integer.parseInt(command[3]),
						Integer.parseInt(command[4]));
				break;
			case "delete":
				delete(Integer.parseInt(command[1]));
				break;
			case "update":
				updated(Integer.parseInt(command[1]));
				break;
			case "exit":

				FileOutputStream out = new FileOutputStream("score.dat");
				ObjectOutputStream out2 = new ObjectOutputStream(out);

				out2.writeObject(list);

				System.exit(0);
			}
		}
	}

	public static void help() {
		System.out.println("list");
		System.out.println("view �ε���");
		System.out.println("add �̸� ���� ���� ����");
		System.out.println("delete �ε���");
		System.out.println("update �ε���");
		System.out.println("exit");
	}

	public static void list() {
		Score score = new Score();

		for (int i = 0; i < list.size(); i++) {
			score = list.get(i);
			System.out.print(i + "\t");
			System.out.print(score.name + "\t");
			System.out.print(score.kor + "\t");
			System.out.print(score.math + "\t");
			System.out.print(score.eng + "\t\n");
		}
	}

	public static Object view(int index) {
		Score score = new Score();
		if (index > list.size()) {
			System.out.println("�������� �ʴ� �ε����Դϴ�.");
			return 0;
		}
		int sum = list.get(index).kor + list.get(index).math
				+ list.get(index).eng;
		int avg = sum / 3;
		System.out.print("�ε��� : " + index + "\n");
		System.out.print("�̸� : " + list.get(index).name + "\n");
		System.out.print("���� : " + list.get(index).kor + "\n");
		System.out.print("���� : " + list.get(index).math + "\n");
		System.out.print("���� : " + list.get(index).eng + "\n");
		System.out.print("�հ� : " + sum + "\n");
		System.out.print("��� : " + avg + "\n");
		return list;
	}

	public static Object add(String name, int kor, int math, int eng) {

		Score score = new Score(name, kor, math, eng);
		list.add(new Score(name, kor, math, eng));
		System.out.println("����Ǿ���ϴ�.");

		return list;

	}

	public static void delete(int index) {
		Score score = new Score();
		if (index >= list.size()) {
			System.out.println("�������� �ʴ� �ε����Դϴ�.");
			return;
		}
		System.out.print(list.get(index).name + "�� ������ �����Ͻðڽ��ϱ�?(y/n)");
		Scanner sc2 = new Scanner(System.in);
		if (sc2.nextLine().equals("y")) {
			list.remove(index);
			System.out.println("�����Ͽ����ϴ�.");
		} else {
			System.out.println("������ ����Ͽ����ϴ�.");
		}

	}

	public static void updated(int index) {
		if (index >= list.size()) {
			System.out.println("�������� �ʴ� �ε����Դϴ�.");
			return;
		}
		Score score = new Score();
		score = list.get(index);
		Scanner sc = new Scanner(System.in);
		String name;
		String kor;
		String eng;
		String math;
		System.out.print("�̸�(" + list.get(index).name + ")?");
		name = sc.nextLine();
		System.out.print("����(" + list.get(index).kor + ")?");
		kor = sc.nextLine();
		System.out.print("����(" + list.get(index).math + ")?");
		math = sc.nextLine();
		System.out.print("����(" + list.get(index).eng + ")?");
		eng = sc.nextLine();

		System.out.print("���� �����Ͻðڽ��ϱ�?(y/n)");
		Scanner sc2 = new Scanner(System.in);
		if (sc2.nextLine().equals("y")) {
			if (!name.equals("")) {
				score.name = name;
			}
			if (!kor.equals("")) {
				score.kor = Integer.parseInt(kor);
			}
			if (!math.equals("")) {
				score.math = Integer.parseInt(math);
			}
			if (!eng.equals("")) {
				score.eng = Integer.parseInt(eng);
			}
			System.out.println("�����Ͽ����ϴ�.");
		} else {
			System.out.println("������ ����Ͽ����ϴ�.");
		}
	}
}