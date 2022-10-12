package controller;

import java.util.HashMap;

import business.Book;
import business.BookCopy;
import business.CheckoutRecord;
import business.LibraryMember;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class LibraryController {
	
	DataAccess dataAccess;
	
	public LibraryController()
	{
		dataAccess=new DataAccessFacade();
	}
	public void checkout (String ibsn,String memberID)
	{
		HashMap<String,Book> books=new HashMap<String,Book>();
		books=dataAccess.readBooksMap();
		boolean bookFound=books.containsKey(ibsn);
		
		HashMap<String,LibraryMember> members=new HashMap<String,LibraryMember>();
		members=dataAccess.readMemberMap();
		boolean memberFound=books.containsKey(ibsn);
		HashMap<String,BookCopy> bookCopies=new HashMap<String,BookCopy>();
		//bookCopies=dataAccess.readBookCopyMap(ibsn);
		bookCopies.values();
		BookCopy bookCopy;
		for(BookCopy b:bookCopies.values())
		{
			if(b.isAvailable())
			{
				bookCopy=b;
				break;
			}
				
		}
		CheckoutRecord checkoutRecord=new CheckoutRecord(memberID);
		checkoutRecord.addCheckoutEntry(bookCopy);
		if(bookFound && memberFound)
		{
			//dataAccess.saveCheckoutRecord(checkoutRecord);
		
		}
		
	}
}
