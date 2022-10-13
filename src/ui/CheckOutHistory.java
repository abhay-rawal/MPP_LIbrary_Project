package ui;

import java.util.Scanner;

import controller.LibraryController;
import controller.LoginController;
import dataaccess.Auth;

public class CheckOutHistory {
	public void fndHistory() {
		System.out.println("FIND CHECKOUT HISTORY\n\n");
		
		Scanner op1 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the member ID: ");
		String memberId = op1.nextLine();
		
		LibraryController lc = new LibraryController();
		lc.findCheckoutEntry(memberId);
		
		// To continue
		Scanner op = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Press enter to continue.");
		String con = op.nextLine();
		
		// Home page
		Auth auth = LoginController.currentAuth;
		Home home = new Home(auth);
		home.goToHome();
	}
}
