package com.BankManagementSystem;

import java.util.ArrayList;

public class UserRecord {

	private ArrayList<User> users = new ArrayList<>();
	
	public boolean registerUser(User user) {
		for(User existingUser:  users) {
			if(existingUser.getUsername().equalsIgnoreCase(user.getUsername())) {
				System.out.println("Duplicate username!");
				return false;
			}
		}
		 users.add(user);
		return true;
	}
	
	public boolean userLogin(String username, String password) {
		
		for(User existingUser: users) {
			
			if(existingUser.getUsername().equalsIgnoreCase(username)) {
				
				 if(password.equals(existingUser.getPassword())) {
					 return true;
					 
				 }else {
					 
				     return false;
				
				 }
			}
		}
		
		return false;
	}
}
