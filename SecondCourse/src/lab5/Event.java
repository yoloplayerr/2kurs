package lab5;

public class Event {
	private String place;
	private String year;
	private String result;
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Место "+place+" Год "+year+" \n";
	}
}
