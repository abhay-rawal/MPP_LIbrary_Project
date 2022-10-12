package business;

public class Author extends Person {

	private String shortBio;

	public Author(String fName, String Lname, String pNo, Address address, String shortBio) {
		super(fName, Lname, address, pNo);
		this.shortBio = shortBio;
	}

	public String getShortBio() {
		return shortBio;
	}

	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}
}
