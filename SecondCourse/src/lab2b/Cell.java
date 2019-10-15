package lab2b;

import java.util.ArrayList;

public class Cell {
	Statment stmt;
	

	public Cell() {
		stmt = Statment.DEAD;
	}
	public void changeStmt(int count) {
		stmt=this.stmt.getStatment(count);
	}


	public void setStmt(Statment live) {
		stmt=live;		
	}
}
