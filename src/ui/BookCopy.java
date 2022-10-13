package ui;

import java.util.Scanner;

import controller.LibraryController;
import controller.LoginController;
import dataaccess.Auth;

public class BookCopy {

	public void addBookCopy() {
		System.out.println("ADD NEW COPY OF BOOK\n\n");
		
		Scanner op1 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the ISBN: ");
		String isbn = op1.nextLine();
		
		LibraryController lc = new LibraryController();
		lc.addBookCopy(isbn);
		
		// To continue
		Scanner op = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Library member created successfully. Press enter to continue.");
		String con = op.nextLine();
		
		// Home page
		Auth auth = LoginController.currentAuth;
		Home home = new Home(auth);
		home.goToHome();
	}
	
}
