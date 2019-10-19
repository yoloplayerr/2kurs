package lab5;

import java.util.ArrayList;

public class Sportsman {
	private String name;
	private String bd;
	private String award;
	private ArrayList<String> place=new ArrayList<>();
	private ArrayList<String> year=new ArrayList<>();
	private ArrayList<String> result=new ArrayList<>();
	private String pol;

	public ArrayList<String> getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place.add(place);
	}

	public ArrayList<String> getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year.add(year);
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Имя спортсмена: " + name + " Дата рождения: " + bd + " Место: " + award + "Место " + place + " Год "
				+ year + " Пол: " + pol +"результаты"+result+"\n";
	}

	public Sportsman(String name, String bd, String pol) {
		super();
		this.name = name;
		this.bd = bd;
		this.pol = pol;
	}

	public ArrayList<String> getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result.add(result);
	}
}
