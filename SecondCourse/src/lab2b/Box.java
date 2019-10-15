package lab2b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Box {

	private final int LENGTH = 5;
	public static ArrayList<Cell[][]> cellList;
	Cell[][] arrayCells;

	public Box() {
		init();
	}

	private void init() {
		cellList=new ArrayList<>();
		arrayCells = new Cell[5][5];
		Random rnd = new Random(System.currentTimeMillis());
		// Получаем случайное число в диапазоне от min до max (включительно)
		int num = 0 + rnd.nextInt(25);
		int i1 = 0;

		int j1 = 0;
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				arrayCells[i][j] = new Cell();

			}

		}
		while (num > 0) {
			i1 = 0 + rnd.nextInt(5);
			j1 = 0 + rnd.nextInt(5);
			arrayCells[i1][j1].setStmt(Statment.LIVE);
			num--;

		}
		System.out.println("Первоначальное положение");
		print(arrayCells);
		isCountinue();
		
	}

	

	public void print() {
	for(Cell[][] c: cellList) {
		System.out.println();
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				if (c[i][j].stmt.isLive() == true) {
					System.out.print(" * ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
		
	}

	}
	public void print(Cell[][] tm) {
		
			System.out.println();
			for (int i = 0; i < LENGTH; i++) {
				for (int j = 0; j < LENGTH; j++) {
					if (tm[i][j].stmt.isLive() == true) {
						System.out.print(" * ");
					} else {
						System.out.print(" - ");
					}
				}
				System.out.println();
			}
			
		

		}

	public void rodi() {
		Cell[][] tmpAr=new Cell[LENGTH][LENGTH];
		 	for(int i=0;i<LENGTH;i++) {
		 		for(int j=0;j<LENGTH;j++) {
		 			tmpAr[i]= Arrays.copyOf(arrayCells[i],arrayCells[i].length);
		 		}
		 	}
	        
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				int tmpX = LENGTH + i;
				int tmpY = LENGTH + j;
				int count = 0;
				if (arrayCells[(tmpX - 1) % LENGTH][(tmpY - 1) % LENGTH].stmt == Statment.LIVE)
					count++;
				if (arrayCells[(tmpX - 1) % LENGTH][(tmpY) % LENGTH].stmt == Statment.LIVE)
					count++;
				if (arrayCells[(tmpX - 1) % LENGTH][(tmpY + 1) % LENGTH].stmt == Statment.LIVE)
					count++;
				if (arrayCells[(tmpX) % LENGTH][(tmpY - 1) % LENGTH].stmt == Statment.LIVE)
					count++;
				if (arrayCells[(tmpX) % LENGTH][(tmpY + 1) % LENGTH].stmt == Statment.LIVE)
					count++;
				if (arrayCells[(tmpX + 1) % LENGTH][(tmpY - 1) % LENGTH].stmt == Statment.LIVE)
					count++;
				if (arrayCells[(tmpX + 1) % LENGTH][(tmpY) % LENGTH].stmt == Statment.LIVE)
					count++;
				if (arrayCells[(tmpX + 1) % LENGTH][(tmpY + 1) % LENGTH].stmt == Statment.LIVE)
					count++;
				tmpAr[i][j].changeStmt(count);

			}
		}
		arrayCells=tmpAr;
		
		isCountinue();
	}

	private void isCountinue() {
		
		cellList.add(arrayCells);
		int tmp1 = cellList.size() - 1;
		
		boolean flag = false;
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++) {
				if (arrayCells[i][j].stmt == Statment.LIVE) {
					flag = true;
				}
			}
		}
		
		if (!flag) {
			System.out.print("Клекти умерли");
			print();
			
		}else if((tmp1>0) && Arrays.deepEquals((Object[][]) cellList.get(tmp1-1),(Object[][]) arrayCells)) {
			System.out.println("Система вошла в стабильную конфигурацию");
			print();
		}else {		
			 rodi();
	        }
		
	}

}
