package business;

import java.util.UUID;

public class BookCopy {
	private UUID copyNo;
	private Book book;
	private boolean isAvailable;
	
	public BookCopy(UUID copyNo, Book book) {
		super();
		this.copyNo = copyNo;
		this.book = book;
	}
	
	public UUID getCopyNo() {
		return copyNo;
	}

	public void setCopyNo(UUID copyNo) {
		this.copyNo = copyNo;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
