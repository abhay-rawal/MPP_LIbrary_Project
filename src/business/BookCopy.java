package business;

import java.io.Serializable;
import java.util.UUID;

public class BookCopy  implements Serializable{
	private UUID copyNo;
	private Book book;
	
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
}
