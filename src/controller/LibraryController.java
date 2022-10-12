package controller;

import java.awt.print.Book;
import java.util.HashMap;

import business.Address;
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
}