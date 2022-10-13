package ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import controller.LibraryController;
import controller.LoginController;
import dataaccess.Auth;

public final class View {
	private View() {};

	public static void addNewBook() {
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
	
	public static void addBookCopy() {
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
	
	public static void addCheckout() {
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
	
	public static void fndHistory() {
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
	
	public static void addLibraryMember() {
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
	
	public static void findOverdue() {
		System.out.println("FIND CHECKOUT HISTORY\n\n");
		
		Scanner op1 = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Please enter the ISBN: ");
		String isbn = op1.nextLine();
		
		LibraryController lc = new LibraryController();
		lc.overDueList(isbn);
		
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
