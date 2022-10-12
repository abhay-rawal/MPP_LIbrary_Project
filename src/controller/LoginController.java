package controller;

import java.util.Arrays;
import java.util.HashMap;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class LoginController {
	private String id;
	private String password;
	public static Auth currentAuth = null;
	
	public LoginController(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public boolean checkUser() {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			return false;
		}
		if(!map.get(id).getPassword().equals(password)) {
			return false;
		}
		currentAuth = map.get(id).getAuthorization();
		
		return true;
	}
}
