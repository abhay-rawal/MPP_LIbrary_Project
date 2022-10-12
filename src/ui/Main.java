package ui;

public class Main {
	public static void main(String[] args) {
		Login login = new Login();
		if(login.askForLogin()) {
			System.out.println("Do other activities");
		}
	}
}
