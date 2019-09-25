package lab1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lab1.Function1;

public class Lab1 {
	private static NumberFormat formatter = new DecimalFormat("#0.0000");

	public static void main(String[] args) {

		ArrayList<Function1> funcList = new ArrayList<>();

		/*
		 * Задания 1-3
		 */
		Function1 lambdaSin = (x) -> 2 * Math.sin(x) + 1;
		Function1 lambdaQuad1 = (x) -> Math.pow(x / Math.PI - 1, 2);
		Function1 lambdaQuad2 = (x) -> (-Math.pow(x / Math.PI, 2) - 2 * x + 5 * Math.PI);
		Function1 lambdaCos = (x) -> ((0.5) * (Math.pow((Math.cos(x)), 2)) + 1);

		funcList.add(lambdaSin);
		funcList.add(lambdaQuad1);
		funcList.add(lambdaQuad2);
		funcList.add(lambdaCos);

		/*
		 * Вывод значений функции
		 */
		System.out.println(getFunc(lambdaSin));
		System.out.println(getFunc(lambdaQuad1));
		System.out.println(getFunc(lambdaQuad2));
		System.out.println(getFunc(lambdaCos));
		System.out.println(" ");
		/*
		 * Пункт а
		 */
		int count = 0;
		for (int i = 0; i < funcList.size(); i++) {
			count = 0;
			for (int j = 0; j < (getFunc(funcList.get(i))).size(); j++) {
				if ((getFunc(funcList.get(i))).get(j) < 0) {
					count++;
				}
			}
			System.out.println(getFunc(funcList.get(i)));
			System.out.println("Количество отрицательных значений:" + count);

		}
		System.out.println(" ");

		/*
		 * Пункт б
		 * Максимум минимум
		 */
		getMinMaxValue(lambdaSin);
		getMinMaxValue(lambdaQuad1);
		getMinMaxValue(lambdaQuad2);
		getMinMaxValue(lambdaCos);
		System.out.println(" ");
		/*
		 * Задание #4
		 */
		Function1 func1 = (x) -> (x * Math.sin(x) - 0.5);
		Function1 func2 = (x) -> (Math.log(x * x - 3 * x + 2));
		Function1 func3 = (x) -> (Math.log(x * x - 3 * x + 2));
		Function1 func4 = (x) -> (0.5 * Math.tan(2 * (x * Math.PI / 4) / 3) - 1);

		System.out.println("корень уравнения: " + getFuncRes(Math.PI, 0, func1));
		System.out.println("корень уравнения: " + getFuncRes(5.0, 2.1, func2));
		System.out.println("корень уравнения: " + getFuncRes(0.9, 0.0, func3));
		System.out.println("корень уравнения: " + getFuncRes(2 * Math.PI, Math.PI, func4));
		System.out.println(" ");

		/*
		 * Задание #5
		 */
		System.out.println("Интеграл равен: " + getIntegral(-Math.PI, Math.PI, 30, lambdaSin));
		System.out.println("Интеграл равен: " + getIntegral(-Math.PI, Math.PI, 30, lambdaQuad2));
		System.out.println("Интеграл равен: " + getIntegral(-Math.PI, Math.PI, 30, lambdaCos));
		System.out.println(" ");

		/*
		 * Задание 6
		 */
		String[] words = { "ротор", "Weptun", "Wwww", "sdf", "LULULUL" };
		Vector<String> vtr = new Vector<>();
		for (int i = 0; i < words.length; i++) {
			vtr.add(words[i]);
		}
		getStrings(vtr);
	}

	public static void getMinMaxValue(Function1 lambda) {
		int n = 10;
		Random random = new Random();
		int[] array = new int[n];
		double tempMin = 100000000000000.0;
		double tempMax = -tempMin;
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(11 + 10) - 10;
		}
		for (int i = 0; i < array.length; i++) {
			if (lambda.funcValue(array[i]) > tempMax) {
				tempMax = lambda.funcValue(array[i]);
			} else if (lambda.funcValue(array[i]) < tempMin) {
				tempMin = lambda.funcValue(array[i]);
			}
		}
		System.out.print("Максимальное значение функции :" + formatter.format(tempMax));
		System.out.println(", Минимальное значение функции :" + formatter.format(tempMin));
	}

	public static double getFuncRes(double rightBord, double leftBord, Function1 lambda) {
	
		double epsilon = 0.0001;
		double c = 0;
		while ((rightBord - leftBord) > epsilon) {
			c = (rightBord + leftBord) / 2;
			if (lambda.funcValue(c) == 0) {
				return c;
				
			} else if (lambda.funcValue(c) * lambda.funcValue(leftBord) < 0) {
				rightBord = c;
			} else {
				leftBord = c;
			}
		}
		return c;
	}

	public static ArrayList<Double> getFunc(Function1 lambda) {
		ArrayList<Double> y = new ArrayList<>();
		for (double i = -2 * Math.PI; i <= 2 * Math.PI; i += Math.PI / 6) {
			y.add(lambda.funcValue(i));
		}
		return y;
	}

	public static double getIntegral(double leftBoard, double rightBoard, double dx, Function1 func) {
		double res = 0;
		double step = (rightBoard - leftBoard) / dx;

		for (double i = leftBoard; i < rightBoard; i += step) {
			res += func.funcValue(i) * step;
		}
		return res;
	}

	public static void getStrings(Vector<String> x) {

		int palidromCount = 0;
		Function<String, Integer> function = string -> (string.length() == 5 ? 1 : 0);
		int charCount = 0;

		Predicate<String> predicate = string -> {
			int n = string.length();
			for (int i = 0; i < (n / 2); ++i) {
				if (string.charAt(i) != string.charAt(n - i - 1)) {
					return false;
				}
			}
			return true;
		};

		Consumer<String> consumer = s -> {
			if (s.charAt(0) == 'W')
				System.out.println("слова на букву 'W' : " + s);
		};

		for (String string : x) {
			charCount += function.apply(string);
			if (predicate.test(string))
				palidromCount++;
			consumer.accept(string);
		}
		System.out.println("Пятибуквенных слов = " + charCount);
		System.out.println("Палиндромов всего = " + palidromCount);
	}

}
