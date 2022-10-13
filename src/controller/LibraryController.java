package controller;

import java.awt.print.Book;
import java.util.HashMap;
import java.util.List;

import business.Address;
import business.Author;
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
		bookCopyHash.put(ISBN, book);
		d.updateBooks(bookCopyHash);
	}
	
	public void addBook(String isbn, String title, int maxCheckoutLength, List<String> author, int numOfCopies) {
		
	}
	
	public void findCheckoutEntry(String memberId) {
		
	}
	
	public void overDueList(String isbn) {
		
	}
}