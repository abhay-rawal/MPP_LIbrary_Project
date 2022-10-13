package ui;

import java.util.Scanner;

import dataaccess.Auth;
import ui.LibraryMember;
import ui.BookCopy;

public class Home {
	private Auth auth;
	private LibraryMember lm;
	private BookCopy bc;
	private Book b;
	private CheckOutHistory ch;
	private Overdue od;
	private CheckOut co;

	public Home(Auth auth) {
		super();
		this.auth = auth;
	}

	public void goToHome() {
		System.out.println("\n ************************************************** \n");
		System.out.println("WELCOME TO THE HOME\n\n");

		Scanner op = new Scanner(System.in); // Create a Scanner object

		// Building the options
		StringBuilder optionsStr = new StringBuilder();
		optionsStr.append("Type the option you need:\n");
		String[] options;

		switch (this.auth) {
		case LIBRARIAN:
			String[] librarian = { "1: Checkout a book", "5: Checkout record", "6: Overdue" };
			options = librarian;
			break;
		case ADMIN:
			String[] admin = { "2: Add a new library member", "3: Add a copy of an existing book", "4: Add book" };
			options = admin;
			break;
		default:
			String[] both = { "1: Checkout a book", "2: Add a new library member", "3: Add a copy of an existing book",
					"4: Add book", "5: Checkout record", "6: Overdue" };
			options = both;
			break;
		}

		for (int i = 0; i < options.length; i++) {
			optionsStr.append(options[i]);
			optionsStr.append("\n");
		}
		optionsStr.append("0: Logout");

		// Move by the option
		System.out.println(optionsStr);
		int option = op.nextInt();
		switch (option) {
		case 0:
			Main.main(null);
			break;
		case 1:
			if (this.auth == Auth.LIBRARIAN || this.auth == Auth.BOTH) {
				System.out.println("\n ************************************************** \n");
				// Go to Checkout a book
				co = new CheckOut();
				co.addCheckout();
			} else {
				System.out.println("You don't have permission to access this option");
				this.goToHome();
			}
			break;
		case 2:
			if (this.auth == Auth.ADMIN || this.auth == Auth.BOTH) {
				System.out.println("\n ************************************************** \n");
				// Add a new library member
				lm = new LibraryMember();
				lm.addLibraryMember();
			} else {
				System.out.println("You don't have permission to access this option");
				this.goToHome();
			}
			break;
		case 3:
			if (this.auth == Auth.ADMIN || this.auth == Auth.BOTH) {
				System.out.println("\n ************************************************** \n");
				// Add a new library member
				bc = new BookCopy();
				bc.addBookCopy();
			} else {
				System.out.println("You don't have permission to access this option");
				this.goToHome();
			}
			break;
		case 4:
			if (this.auth == Auth.ADMIN || this.auth == Auth.BOTH) {
				System.out.println("\n ************************************************** \n");
				// Add a new book
				b = new Book();
				b.addNewBook();
			} else {
				System.out.println("You don't have permission to access this option");
				this.goToHome();
			}
			break;
		case 5:
			if (this.auth == Auth.LIBRARIAN || this.auth == Auth.BOTH) {
				System.out.println("\n ************************************************** \n");
				// Find checkout history
				ch = new CheckOutHistory();
				ch.fndHistory();
			} else {
				System.out.println("You don't have permission to access this option");
				this.goToHome();
			}
			break;
		case 6:
			if (this.auth == Auth.LIBRARIAN || this.auth == Auth.BOTH) {
				System.out.println("\n ************************************************** \n");
				// Find overdue
				od = new Overdue();
				od.fndOverdue();
			} else {
				System.out.println("You don't have permission to access this option");
				this.goToHome();
			}
			break;
		default:
			System.out.println("You selected a wrong option");
			this.goToHome();
			break;
		}
	}
}
