package business;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Book {
	private String isbn;
	private List<Author> author;
	private String title;
	private int maxCheckoutLength;
	private List<BookCopy> bookCopies;
	
	public Book(String isbn,String title ,int maxCheckoutLength,List<Author> author) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.maxCheckoutLength = maxCheckoutLength;
		bookCopies = new ArrayList<>();
		addCopy();
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
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

	public void addCopy() {
		bookCopies.add(new BookCopy(UUID.randomUUID(), this));
		
	}
}
