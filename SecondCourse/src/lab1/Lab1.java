package lab1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

import lab1.Function;

public class Lab1 {
	private static NumberFormat formatter = new DecimalFormat("#0.0000");
	public static void main(String[] args) {
		
		ArrayList<Function> funcList = new ArrayList<>();
		
		/*
		 * Задания 1-3
		 */
		Function lambdaSin = (x) -> 2 * Math.sin(x) + 1;
		Function lambdaQuad1 = (x) -> Math.pow(x / Math.PI - 1, 2);
		Function lambdaQuad2 = (x) -> (-Math.pow(x / Math.PI, 2) - 2 * x + 5 * Math.PI);
		Function lambdaCos = (x) -> ((0.5) * (Math.pow((Math.cos(x)), 2)) + 1);
		
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
		
		/*
		 *Максимум минимум 
		 */
		getMinMaxValue(lambdaSin);				
		getMinMaxValue(lambdaQuad1);
		getMinMaxValue(lambdaQuad2);
		getMinMaxValue(lambdaCos);
		
		
		Function someFunc=(x)->x*Math.sin(x)-0.5;
		System.out.println(getFuncRes(Math.PI, 0, someFunc));
		
		
		

		int count=0;	
		for (int i = 0; i < funcList.size(); i++) {
			count=0;
				for(int j=0;j<(getFunc(funcList.get(i))).size();j++) {
					if((getFunc(funcList.get(i))).get(j)<0) {
						count++;
					}
				}
//				System.out.println(getFunc(funcList.get(i)));
//				System.out.println("Количество отрицательных значений:"+count);
				
				
		}
		

	}
	public static void getMinMaxValue(Function lambda) {
		int n=10;
		Random random = new Random();	
			int[] array=new int[n];
		double tempMin=100000000000000.0;
		double tempMax=-tempMin;	
				for(int i=0;i<array.length;i++) {
					array[i]=random.nextInt(11+10) -10;			
				}
				for(int i=0;i<array.length;i++) {
					if(lambda.funcValue(array[i])>tempMax){
						tempMax=lambda.funcValue(array[i]);
					}else if(lambda.funcValue(array[i])<tempMin) {
						tempMin=lambda.funcValue(array[i]);
					}
				}
				System.out.print("Максимальное значение функции :"+formatter.format(tempMax));
				System.out.println(", Минимальное значение функции :"+formatter.format(tempMin));
	}
	public static double getFuncRes(double rightBord,double leftBord,Function lambda) {
		double epsilon=0.0001;
		double c=0;
			while((rightBord-leftBord)>epsilon) {
				c=(rightBord+leftBord)/2;
					if(lambda.funcValue(c)==0) {
						return c;
					}else if(lambda.funcValue(c)*lambda.funcValue(leftBord)<0) {
						rightBord=c;						
					}else {
						leftBord=c;
					}						
			}
			return c;
	}

	public static ArrayList<Double> getFunc(Function lambda) {
		ArrayList<Double> y = new ArrayList<>();
		for (double i = -2 * Math.PI; i <= 2 * Math.PI; i += Math.PI / 6) {
			y.add(lambda.funcValue(i));
		}
		return y;
	}
}
