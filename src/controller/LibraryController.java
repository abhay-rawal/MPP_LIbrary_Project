package controller;
import java.util.HashMap;
import java.util.List;

import business.Address;
import business.Author;
import business.Book;
import business.BookCopy;
import business.CheckoutRecord;
import business.LibraryMember;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class LibraryController {
	DataAccess d;

	public LibraryController() {
		d = new DataAccessFacade();
	}

	public void createLibraryMember(String memberId, String firstName, String lastName, String state, String street,
			String city, String zip, String telephoneNo) {
		Address ad = new Address(street, city, state, zip);
		d.saveNewMember(new LibraryMember(memberId, firstName, lastName, telephoneNo, ad));
	}

	public void addBookCopy(String ISBN) {
		HashMap<String, business.Book> bookCopyHash = d.readBooksMap();
		business.Book book = (business.Book)bookCopyHash.get(ISBN);
		if(book!=null)
		{
			book.addCopy();
		}
		else 
			return;
		bookCopyHash.put(ISBN, book);
		d.updateBooks(bookCopyHash);
		
		bookCopyHash = d.readBooksMap();
	}
	
	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> author, int numOfCopies) {
		business.Book newBook = new Book(isbn, title, maxCheckoutLength, author);
		for(int i = 0; i < numOfCopies; i++) {
			newBook.addCopy();
		}
		HashMap<String,Book> sBook = d.readBooksMap();
		sBook.put(isbn, newBook);
		d.updateBooks(sBook);
	}
	
	public CheckoutRecord findCheckoutEntry(String memberId) {
		HashMap<String, CheckoutRecord> cc = new HashMap<String, CheckoutRecord>();
		cc=d.readCheckoutMap();
		if(cc!=null)
			return cc.get(memberId);
		else 
			return null;
	}
	
	public void overDueList(String isbn) {
		
	}
	
	public CheckoutRecord checkout(String ibsn, String memberID) {
		
		boolean isCheckoutComplete=false;
		HashMap<String, Book> books = new HashMap<String, Book>();
		books = d.readBooksMap();
		boolean bookFound = books.containsKey(ibsn);

		HashMap<String, LibraryMember> members = new HashMap<String, LibraryMember>();
		members = d.readMemberMap();
		boolean memberFound = books.containsKey(ibsn);

		Book book = books.get(ibsn);
		List<BookCopy> bookCopies;
		bookCopies = book.getBookCopy();
		BookCopy bookCopy = null;
		int bookCopyIndex = -1;
		for (BookCopy b : bookCopies) {
			bookCopyIndex++;
			if (b.isAvailable()) {
				bookCopy = b;

				break;
			}

		}
		if (bookCopy != null && bookFound && memberFound) {
			CheckoutRecord checkoutRecord = new CheckoutRecord(memberID);
			checkoutRecord.addCheckoutEntry(bookCopy);
			d.saveCheckoutRecord(checkoutRecord);

			books.get(ibsn).getBookCopy().get(bookCopyIndex).setAvailable(false);
			books.get(ibsn).getBookCopy().get(bookCopyIndex).setLendedBy(memberID);
			d.updateBooks(books);
			
			isCheckoutComplete=true;
		} else {
			if (!memberFound)
				System.out.println("Member not found.");

			if (!bookFound)
				System.out.println("Book not found.");
			if (bookCopy == null)
				System.out.println("Book Copy not avialable.");
			
			isCheckoutComplete=false;
		}
		if(isCheckoutComplete)
			return findCheckoutEntry(memberID);
		else 
			return null;
	}
	
}