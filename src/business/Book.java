package business;

public class Book {
	private String isbn;
	private String author;
	private String title;
	private int maxCheckoutLength;
	
	public Book(String isbn, String author, String title, int maxCheckoutLength) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}
	public void setMaxCheckoutLength(int maxCheckoutLength) {
		this.maxCheckoutLength = maxCheckoutLength;
	}
}
