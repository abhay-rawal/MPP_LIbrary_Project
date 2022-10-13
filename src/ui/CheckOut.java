package ui;

import java.util.Scanner;

import controller.LibraryController;
import controller.LoginController;
import dataaccess.Auth;

public class CheckOut {
	public void addCheckout() {
		System.out.println("ADD NEW BOOK\n\n");
		
		Scanner op1 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the member ID: ");
		String memberID = op1.nextLine();
		
		Scanner op2 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the ISBN: ");
		String isbn = op2.nextLine();
		
		LibraryController lc = new LibraryController();
		
		// To continue
		Scanner op = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Checkout successful. Press enter to continue.");
		String con = op.nextLine();
		
		// Home page
		Auth auth = LoginController.currentAuth;
		Home home = new Home(auth);
		home.goToHome();
	}
}
