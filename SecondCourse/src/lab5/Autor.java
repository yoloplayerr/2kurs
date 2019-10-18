package lab5;

import java.util.ArrayList;

public class Autor {
	private String autorName;
    private ArrayList<String> bookName=new ArrayList<>();
    private ArrayList<String> pages;
 

    public String getAutorName() {
		return autorName;
	}

	public void setAutorName(String autorName) {
		this.autorName = autorName;
	}

	

	

	public ArrayList<String> getBookName() {
		return bookName;
	}

	public void setBookName(ArrayList<String> bookName) {
		this.bookName = bookName;
	}

	public ArrayList<String> getPages() {
		return pages;
	}

	public void setPages(ArrayList<String> pages) {
		this.pages = pages;
	}

	public Autor() {
    }

    public Autor(String autorName,String bookName,String pages) {
        this.autorName = autorName;
        this.bookName.add(bookName);
        this.pages.add(pages);
        }

    

    @Override
    public String toString() {
        return
                "autorName='" + autorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ",pages='" + pages + '\'';
                
    }

}
