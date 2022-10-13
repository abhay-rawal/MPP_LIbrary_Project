package ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import controller.LibraryController;
import controller.LoginController;
import dataaccess.Auth;

public class Book {
	
	public void addNewBook() {
		System.out.println("ADD NEW BOOK\n\n");
		
		Scanner op1 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the ISBN: ");
		String isbn = op1.nextLine();
		
		Scanner op2 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the title: ");
		String title = op2.nextLine();
		
		Scanner op3 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the maximum checkout length: ");
		int maxCheckoutLength = op3.nextInt();
		
		Scanner op4 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the authors name with comma(,) separator: ");
		String author = op4.nextLine();
		
		Scanner op5 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the number of copies: ");
		int numOfCopies = op5.nextInt();
		
		List<String> authors = Arrays.asList(author.split("\\s*,\\s*"));
		
		LibraryController lc = new LibraryController();
		lc.addBook(isbn, title, maxCheckoutLength, authors, numOfCopies);
		
		// To continue
		Scanner op = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Book created successfully. Press enter to continue.");
		String con = op.nextLine();
		
		// Home page
		Auth auth = LoginController.currentAuth;
		Home home = new Home(auth);
		home.goToHome();
	}
	
}
