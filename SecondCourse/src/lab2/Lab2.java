package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Lab2 {

	public static void main(String[] args) throws FileNotFoundException {
		
//		pyatoeZadanie("text2.txt");
		zadanie2();
	}

	// Первое задание
	public static void getStack(int num) {
		Stack<Integer> someStack = new Stack<>();

		int count = 0;
		int temp = num;
		while (temp != 0) {
			count++;
			someStack.push((int) (temp % 10));
			temp = (int) Math.floor(temp / 10);
		}
		while (!someStack.isEmpty()) {
			System.out.print(someStack.pop());
		}

		while (count != 0) {
			count--;
			someStack.push((int) (Math.floor(num / Math.pow(10, count)) % 10));
		}

		System.out.println();
		while (!someStack.isEmpty()) {
			System.out.print(someStack.pop());
		}

	}

	public static void getQU(int num) {
		ArrayDeque<Integer> someDeq = new ArrayDeque<>();

		int count = 0;
		int temp = num;
		while (temp != 0) {
			count++;
			someDeq.push((int) (temp % 10));
			temp = (int) Math.floor(temp / 10);
		}
		while (!someDeq.isEmpty()) {
			System.out.print(someDeq.pop());
		}

		while (count != 0) {
			count--;
			someDeq.push((int) (Math.floor(num / Math.pow(10, count)) % 10));
		}

		System.out.println();
		while (!someDeq.isEmpty()) {
			System.out.print(someDeq.pop());
		}
	}

	// Второе задание
	public static void zadanie2() throws FileNotFoundException {
		String path = "lab2.txt";
		Stack<Human> humans = new Stack<>();
		Stack<Human> tmp_h = new Stack<>();
		Human tmp;
		Scanner scn = new Scanner(new File(path));

		while (scn.hasNext()) {
			tmp = new Human();
			tmp.setName(scn.next());
			tmp.setLastName(scn.next());
			tmp.setDate(scn.next());
			tmp.setSex(scn.next().equals("мужской"));
			humans.push(tmp);
		}
		while (!humans.isEmpty()) {
			tmp = humans.pop();
			if (tmp.getAge() < 40) {
				System.out.println(tmp.toString());
			} else
				tmp_h.push(tmp);
		}
		System.out.println("Старше сорока");
		while (!tmp_h.isEmpty()) {
			System.out.println(tmp_h.pop().toString());
		}
	}

	// Третье задание
	public static boolean stroka(String line) {
		Stack<Character> stack = new Stack<Character>();

		char c;
		for (int i = 0; i < line.length(); i++) {
			c = line.charAt(i);
			if (c == '(' || c == '{' || c == '[')
				stack.push(c);
			else if (c == ')')
				if (stack.empty())
					return false;
				else if (stack.peek() == '(')
					stack.pop();
				else
					return false;
			else if (c == '}')
				if (stack.empty())
					return false;
				else if (stack.peek() == '{')
					stack.pop();
				else
					return false;
			else if (c == ']')
				if (stack.empty())
					return false;
				else if (stack.peek() == '[')
					stack.pop();
				else
					return false;
		}
		return stack.empty();
	}

	// четвертое задание
	public static void chetvertoeZadanie() {
		String f = "m(M(3,m(6,9)),M(5,4))";
		Stack<Character> someStack = new Stack<>();
		for (int i = 0; i < f.length(); i++) {
			if (f.charAt(i) == ')') {
				int k = someStack.pop();
				int l = someStack.pop();
				someStack.pop();
				if (someStack.pop() == 'M')
					if (l > k)
						someStack.push((char) l);
					else
						someStack.push((char) k);
				else if (l < k)
					someStack.push((char) l);
				else
					someStack.push((char) k);
			} else if (f.charAt(i) != ',')
				someStack.push(f.charAt(i));
		}
		System.out.println(someStack.pop());
	}

	// Пятое задание
	public static void pyatoeZadanie(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			ArrayList<String> array = new ArrayList<>();
			while ((line = br.readLine()) != null) {
				array.add(line);
			}
			array.sort((o1, o2) -> {
				if (o1.length() != o2.length())
					return o1.length() - o2.length();
				else
					return o1.compareTo(o2);
			});
			System.out.println(array);
			Collections.sort(array);
			System.out.println(array);
			array.sort((o1, o2) -> {
				int k = 0, l = 0;
				for (int i = 0; i < o1.length(); i++)
					if (Character.isUpperCase(o1.charAt(i)))
						k++;
				for (int i = 0; i < o2.length(); i++)
					if (Character.isUpperCase(o2.charAt(i)))
						l++;
				if (k != l)
					return k - l;
				else
					return o1.compareTo(o2);
			});
			System.out.println(array);

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void zadanie6()
    {
        Point[] dots = new Point[10];
        dots[0] = new Point(1,1);
        dots[1] = new Point(2,1);
        dots[2] = new Point(2,4);
        dots[3] = new Point(5,4);
        dots[4] = new Point(5,2);
        Line line = new Line(dots[0]);
        for (int i = 1; i < 5; i++) {
            line.addpoint(dots[i]);
        }

        System.out.println(line.length());
        System.out.println(line.getCountOfpoints());
    }

}
