package ui;

import java.util.Scanner;

import controller.LibraryController;
import controller.LoginController;
import dataaccess.Auth;

public class LibraryMember {
	
	public void addLibraryMember() {
		System.out.println("ADD NEW LIBRARY MEMBER\n\n");
		
		Scanner op1 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the member id: ");
		String memberId = op1.nextLine();
		
		Scanner op2 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the first name: ");
		String firstName = op2.nextLine();
		
		Scanner op3 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the last name: ");
		String lastName = op3.nextLine();
		
		Scanner op4 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the state: ");
		String state = op4.nextLine();
		
		Scanner op5 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the street: ");
		String street = op5.nextLine();
		
		Scanner op6 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the city: ");
		String city = op6.nextLine();
		
		Scanner op7 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the zip: ");
		String zip = op7.nextLine();
		
		Scanner op8 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the telephone no: ");
		String telephoneNo = op8.nextLine();
		
		LibraryController lc = new LibraryController();
		lc.createLibraryMember(memberId, firstName, lastName, state, street, city, zip, telephoneNo);
		
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
