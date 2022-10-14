package controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import business.Address;
import business.Author;
import business.Book;
import business.BookCopy;
import business.CheckoutRecord;
import business.CheckoutRecordEntry;
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
		business.Book book = (business.Book) bookCopyHash.get(ISBN);
		if (book != null) {
			book.addCopy();
		} else
			return;
		bookCopyHash.put(ISBN, book);
		d.updateBooks(bookCopyHash);

		bookCopyHash = d.readBooksMap();
	}

	public void addBook(String isbn, String title, int maxCheckoutLength, List<Author> author, int numOfCopies) {
		business.Book newBook = new Book(isbn, title, maxCheckoutLength, author);
		for (int i = 0; i < numOfCopies; i++) {
			newBook.addCopy();
		}
		HashMap<String, Book> sBook = d.readBooksMap();
		sBook.put(isbn, newBook);
		d.updateBooks(sBook);
	}

	public CheckoutRecord findCheckoutEntry(String memberId) {
		HashMap<String, LibraryMember> mm = new HashMap<String, LibraryMember>();
		mm = d.readMemberMap();

		if (mm != null)
			return mm.get(memberId).getCheckoutRecord();
		else
			return null;
	}

	@SuppressWarnings("static-access")
	public void overDueList(String isbn) {
		HashMap<String, business.Book> bookCopyHash = d.readBooksMap();
		business.Book book = (business.Book) bookCopyHash.get(isbn);
		if (book != null) {
			String outPutBooks = "";
			System.out.println(outPutBooks.format("The books ISBN : %s. %n The books title : %s. %n ", book.getIsbn(),
					book.getTitle()));
			System.out.println("The Information on the book copies:");
			for (BookCopy item : book.getBookCopy()) {
				System.out.println("Book Copy Number :" + item.getCopyNo());
				if (!item.isAvailable()) {
					LibraryMember member = getLibraryMember(item.getLendedBy());
					System.out.println("Lended to : " + member.getMemberId() + "->" + member.getFirstName());
					CheckoutRecordEntry checkoutRecordEntry = getCheckoutEntry(book.getIsbn(), item.getCopyNo(), member);
					if(checkoutRecordEntry!=null)
					{
						LocalDate dueDate = checkoutRecordEntry.getDueDate();
						long daysBetween = LocalDate.now().until(LocalDate.of(2022, 10, 8), ChronoUnit.DAYS);
						if(daysBetween < 0)
						{
						System.out.println("Book Was Due on :" + dueDate.toString() + " and have been reutrned before " + (-1*daysBetween) + " days /n /n");
						}
						else
						System.out.println("Book is Due on :" + dueDate.toString() + " and should be reutrned on " + daysBetween + " days /n /n");
					}
				}
				else
				{
					System.out.println("No OverDue \n \n");
				}

			}
		} else {
			System.out.println("No books available with isbn No: " + isbn);
		}

	}

	private CheckoutRecordEntry getCheckoutEntry(String ISBN, int CopyNum,LibraryMember member) {
		
		List<CheckoutRecordEntry> cRE = member.getCheckoutRecord().getCheckoutRecordEntries(); 
		for (CheckoutRecordEntry item : cRE) {
			String itemISBN = item.getBookCopy().getBook().getIsbn();
			if((item.getBookCopy().getCopyNo() == CopyNum) && (ISBN.equals(itemISBN)))
			{
				return item;
			}
		}
		return null;
		
	}

	private LibraryMember getLibraryMember(String LendedBy) {

		HashMap<String, LibraryMember> memberHash = d.readMemberMap();
		LibraryMember member = (LibraryMember) memberHash.get(LendedBy);
		return member;
	}

	public CheckoutRecord checkout(String ibsn, String memberID) {

		boolean isCheckoutComplete = false;
		HashMap<String, Book> books = new HashMap<String, Book>();
		books = d.readBooksMap();
		boolean bookFound = books.containsKey(ibsn);

		HashMap<String, LibraryMember> members = new HashMap<String, LibraryMember>();
		members = d.readMemberMap();
		boolean memberFound = members.containsKey(memberID);

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
			LibraryMember lm = members.get(memberID);
			CheckoutRecord checkoutRecord;
			CheckoutRecord oldRecord = members.get(memberID).getCheckoutRecord();
			if (oldRecord != null)
				checkoutRecord = oldRecord;
			else
				checkoutRecord = new CheckoutRecord();
			checkoutRecord.addCheckoutEntry(bookCopy);
			lm.setCheckoutRecord(checkoutRecord);
			members.put(memberID, lm);
			d.updateMembers(members);

			books.get(ibsn).getBookCopy().get(bookCopyIndex).setAvailable(false);
			books.get(ibsn).getBookCopy().get(bookCopyIndex).setLendedBy(memberID);
			d.updateBooks(books);

			isCheckoutComplete = true;
		} else {
			if (!memberFound)
				System.out.println("Member not found.");

			if (!bookFound)
				System.out.println("Book not found.");
			if (bookCopy == null)
				System.out.println("Book Copy not avialable.");

			isCheckoutComplete = false;
		}
		if (isCheckoutComplete)
			return findCheckoutEntry(memberID);
		else
			return null;
	}

}