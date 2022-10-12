package business;

public class BookCopy {
	private int copyNo;
	private Book book;
	
	public BookCopy(int copyNo, Book book) {
		super();
		this.copyNo = copyNo;
		this.book = book;
	}
	
	public int getCopyNo() {
		return copyNo;
	}

	public void setCopyNo(int copyNo) {
		this.copyNo = copyNo;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
