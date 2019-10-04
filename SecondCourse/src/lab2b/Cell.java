package lab2b;

import java.util.ArrayList;

public class Cell {
	Statment stmt;
	ArrayList<Cell> stmtList;
	
	
	public Cell() {
		stmt=Statment.DEAD;
	}
	public int getLiveCells() {
		int count=0;
		for(Cell cell : stmtList) 
				if(cell.stmt.isLive() == true )
					count++;
		return count;
	}
	public void step() {
		this.stmt.getStatment(getLiveCells());
	}
}
