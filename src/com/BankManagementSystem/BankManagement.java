package com.BankManagementSystem;

import java.util.Scanner;

public class BankManagement {
         
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BankRecord records = new BankRecord();
		
		BankOperations operations = new BankOperations(records);
		
		UserRecord userRecord = new UserRecord();
		
		int i=0;
		 
		do {
			System.out.println("Main Menu:\r\n"
					           + "1. User Registration\r\n"
					           + "2. User Login\r\n"
					           + "3. Add Records\r\n"
					           + "4. Update Records\r\n"
					           + "5. View Reports\r\n"
					           + "6. Admin Operations\r\n"
					           + "7. Exit");
			System.out.println("CHoose options from the main menu: ");
			i=sc.nextInt();
			switch(i) {
			
			case 1:{
				System.out.println("Enter User ID: ");
				int id = sc.nextInt();
				
				System.out.println("Enter Username: ");
				String name = sc.next();
				
				System.out.println("Enter Password: ");
				String password = sc.next();
				
				User user = new User(id, name, password);
				
				boolean registered =userRecord.registerUser(user);
				if(registered) {
					System.out.println("Registration successful!");
				}else {
					System.out.println("Registration failed!");
				}
				
				break;
			}
			
			case 2:{
				System.out.println("Enter Username: ");
				String username = sc.next();
				
				System.out.println("Enter password: ");
				String password = sc.next();
				
				boolean loggedIn = userRecord.userLogin(username, password);
				
				if(loggedIn) {
					System.out.println("Login successful!");
				}else {
					System.out.println("Invalid username or password!");
				}
				break;
			}
			
			case 3:{
				 try {
					 System.out.println("Add Records");
						
						System.out.println("Enter User Name");
						String name = sc.next();
						
						System.out.println("Enter Account Number: ");
						long accountNumber = sc.nextLong();
						
						System.out.println("Enter Age: ");
						int age = sc.nextInt();
						
						System.out.println("Enter Gender: ");
						String gender = sc.next();
						
						System.out.println("Initial Balance: ");
						double balance = sc.nextDouble();
						
						BankAccount account = new BankAccount(name, accountNumber, age, gender, balance);
						
						records.addAccount(account);
						
						System.out.println("Account created successfully");
						
				 }catch(IllegalArgumentException e) {
					 System.out.println("Account creation failed: "+e.getMessage());
				 }
				break;
			}
			case 4:{
				System.out.println("Enter Account Number to Update: ");
				long accountNumber = sc.nextLong();
				
				System.out.println("Enter New Name: ");
				String newName = sc.next();
				
				System.out.println("Enter New Age: ");
				int newAge = sc.nextInt();
				
				System.out.println("Enter New Gender: ");
				String newGender = sc.next();
				
				System.out.println("Enter New Balance: ");
				double newBalance = sc.nextDouble();
				
				boolean updated = records.updateAccount( accountNumber, newName, newAge, newGender, newBalance);
				if(updated) {
				System.out.println("Account updated successfully!");
				}else {
			    System.out.println("Account not found!");
				}
				break;
			}
			case 5:{
				records.viewAccount();
				break;
			}
			case 6:{
				int option = 0;
					 
					do {
						System.out.println("Admin Operations\r\n"
					                           + "1. Deposit Money\r\n"
					                           + "2. Withdraw Money\r\n"
					                           + "3. Check Balance\r\n"
					                           + "4. Search Account\r\n"
					                           + "5. Delete Account\r\n"
					                           + "6. Back to Main Menu");
						System.out.println("Choose admin operation from the given menu: ");
					option = sc.nextInt();
					switch(option){
					
					case 1:{
						System.out.println("Enter User Account Number: ");
						long accountNumber = sc.nextLong();
						
						System.out.println("Enter Deposit Amount: ");
						double amount = sc.nextDouble();
						
						operations.depositMoney(accountNumber, amount);
						break;
					}
					
					case 2:{
						System.out.println("Enter user Account Number: ");
						long accountNumber = sc.nextLong();
						
						System.out.println("Enter Withdrawal Amount: ");
						double amount = sc.nextDouble();
						
						operations.withdrawMoney(accountNumber, amount);
						break;
					}
					
					case 3:{
						System.out.println("Enter User Account Number: ");
						long accountNumber = sc.nextLong();
						
						operations.checkBalance(accountNumber);
						break;
					}
					
					case 4:{
						System.out.println("Enter User Account Number: ");
						long accountNumber = sc.nextLong();
						
					    BankAccount account = records.searchAccount(accountNumber);
					    
					    if(account!=null) {
					    	System.out.println("Account Found!");
					    	System.out.println("Name: "+account.getName());
					    	System.out.println("Account Number: "+account.getAccountNumber());
					    	System.out.println("Age: "+account.getAge());
					    	System.out.println("Gender: "+account.getGender());
					    	System.out.println("Balance: "+account.getBalance());
					    }else {
					    	System.out.println("Account not found!");
					    }
						break;
					}
					
					case 5:{
						System.out.println("Enter User Account Number: ");
						long accountNumber = sc.nextLong();
						
						boolean deleted = records.deleteAccount(accountNumber);
						
						if(deleted) {
							System.out.println("Account deleted successfully!");
						}else {
							System.out.println("Account not found");
						}
						break;
					}
					
					case 6:{
						System.out.println("Returning to Main Menu..");
						break;
					}
					default: System.out.println("Invalid option!");
					}
					
				}while(option!=6);
				
				 
				break;
			}
			case 7:{
				System.out.println("Thank You");
				break;
			}
			default: System.out.println("Invalid option!");
			}
			
		}while(i!=7);
		
		sc.close();
		
	}
	
}
