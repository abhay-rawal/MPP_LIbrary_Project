package ui;

import java.util.Scanner;

import controller.LoginController;
import dataaccess.Auth;
import dataaccess.User;

public class Login {
	private String id;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean askForLogin() {
		System.out.println("LIBRARY MANAGEMENT SYSTEM\n");
		
		Scanner myObj1 = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter your ID:");
	    String userID = myObj1.nextLine();  // Read user input
	    
	    Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter your password:");
	    String userPassword = myObj2.nextLine();  // Read user input
	    
	    this.id = userID;
	    this.password = userPassword;
	    
	    LoginController login = new LoginController(id, password);
	    if(login.checkUser()) {
	    	Auth auth = LoginController.currentAuth;
	    	System.out.println("Hello, you are succesfully logged in as " + auth);
	    }else {
	    	System.out.println("Your user id & password doesn't matched");
	    }
	    return login.checkUser();
	}
}
