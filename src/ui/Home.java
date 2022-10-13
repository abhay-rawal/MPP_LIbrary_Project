package ui;

import java.util.Scanner;

import dataaccess.Auth;

public class Home {
	private Auth auth;

	public Home(Auth auth) {
		super();
		this.auth = auth;
	}

	public void goToHome() {
		separator();
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
				separator();
				// Go to Checkout a book
				View.addCheckout();
			} else {
				permissionDenied();
			}
			break;
		case 2:
			if (this.auth == Auth.ADMIN || this.auth == Auth.BOTH) {
				separator();
				// Add a new library member
				View.addLibraryMember();
			} else {
				permissionDenied();
			}
			break;
		case 3:
			if (this.auth == Auth.ADMIN || this.auth == Auth.BOTH) {
				separator();
				// Add a new library member
				View.addBookCopy();
			} else {
				permissionDenied();
			}
			break;
		case 4:
			if (this.auth == Auth.ADMIN || this.auth == Auth.BOTH) {
				separator();
				// Add a new book
				View.addNewBook();
			} else {
				permissionDenied();
			}
			break;
		case 5:
			if (this.auth == Auth.LIBRARIAN || this.auth == Auth.BOTH) {
				separator();
				// Find checkout history
				View.fndHistory();
			} else {
				permissionDenied();
			}
			break;
		case 6:
			if (this.auth == Auth.LIBRARIAN || this.auth == Auth.BOTH) {
				separator();
				// Find overdue
				View.findOverdue();
			} else {
				permissionDenied();
			}
			break;
		default:
			System.out.println("You selected a wrong option");
			this.goToHome();
			break;
		}
	}
	
	public void separator() {
		System.out.println("\n--------------------------------------------------------\n");
	}
	
	public void permissionDenied() {
		System.out.println("You don't have permission to access this option");
		this.goToHome();
	}
}
