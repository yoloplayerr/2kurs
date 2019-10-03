package lab2;

import java.time.Year;

public class Human {
	private String name;
	private String lastName;
	private String date;
	private boolean sex;
	 public int getAge()
	    {
	        int year = Integer.parseInt(date.split("\\.")[2]);
	        return Year.now().getValue()- year;
	    }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean getSex() {
		return sex;
	}
	 public void setSex(boolean sex) {
	        this.sex = sex;
	    }
}	
