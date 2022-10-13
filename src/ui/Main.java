package ui;

import controller.LoginController;
import dataaccess.Auth;

public class Main {
	public static void main(String[] args) {
		// Check User
		Login login = new Login();
		if(login.askForLogin()) {
			
			// Home page
			Auth auth = LoginController.currentAuth;
			Home home = new Home(auth);
			home.goToHome();

		}
	}
}
