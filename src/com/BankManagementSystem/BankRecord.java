package com.BankManagementSystem;

import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

    public class BankRecord {
	
	public BankRecord() {
		loadFromFile();
	}
//this method is used for loading the data from the file
	private void loadFromFile() {

	    File file = new File("bank_accounts.txt");

	    if (!file.exists()) {
	        return;
	    }

	    try (BufferedReader br = new BufferedReader(new FileReader(file))) {

	        String line;

	        while ((line = br.readLine()) != null) {

	            try {
	                String[] data = line.split("\\|", -1);

	                if (data.length != 5) {
	                    System.out.println("Invalid record skipped: " + line);
	                    continue;
	                }

	                String name = data[0];
	                long accountNumber = Long.parseLong(data[1]);
	                int age = Integer.parseInt(data[2]);
	                String gender = data[3];
	                double balance = Double.parseDouble(data[4]);

	                if (searchAccount(accountNumber) != null) {
	                    System.out.println("Duplicate record skipped!");
	                    continue;
	                }

	                BankAccount account = new BankAccount(
	                    name, accountNumber, age, gender, balance
	                );

	                accounts.add(account);

	            } catch (RuntimeException e) {
	                System.out.println("Invalid record skipped: " + line);
	            }
	        }

	        System.out.println("Bank records loaded successfully!");

	    } catch (IOException e) {
	        System.out.println("Error reading bank file: " + e.getMessage());
	    }
	}
	
//	this method is used for saving data to the file
	private void saveToFile() {

	    try (BufferedWriter bw = new BufferedWriter(
	            new FileWriter("bank_accounts.txt"))) {

	        for (BankAccount account : accounts) {

	            bw.write(
	                account.getName() + "|" +
	                account.getAccountNumber() + "|" +
	                account.getAge() + "|" +
	                account.getGender() + "|" +
	                account.getBalance()
	            );

	            bw.newLine();
	        }

	        System.out.println("Bank records saved successfully!");

	    } catch (IOException e) {
	        System.out.println("Error saving bank file: " + e.getMessage());
	    }
	}
	
	public void saveChanges() {
		saveToFile();
	}
	

	private ArrayList<BankAccount> accounts = new ArrayList<>();
	
	public boolean addAccount(BankAccount account) {
		if(searchAccount(account.getAccountNumber())!=null) {
			System.out.println("Account number already exists!");
			return false;
		}
		 accounts.add(account);
		 saveToFile();
		 System.out.println("Account added successfully!");
		 return true;
	}
	
	public void viewAccount() {
		if(accounts.isEmpty()) {
			System.out.println("No bank accounts available!");
			return;
		}
		
		for(BankAccount account : accounts) {
			System.out.println("Name: " + account.getName());
			System.out.println("Account Number: " + account.getAccountNumber());
			System.out.println("Age: " + account.getAge());
			System.out.println("Gender: " + account.getGender());
			System.out.println("Balance: " + account.getBalance());
			
			System.out.println("-------------------------");
		}
	}
	
	public boolean updateAccount(long accountNumber, String newName, int newAge, String newGender, double newBalance) {
		try {
			for(BankAccount account: accounts) {
				if(account.getAccountNumber() == accountNumber) {
					account.setName(newName);
					account.setAge(newAge);
					account.setGender(newGender);
					account.setBalance(newBalance);
					saveToFile();
	 				return true;
				}
			} 
		}catch(IllegalArgumentException e) {
			System.out.println("Update failed: "+e.getMessage());
			return false;
		}
		 
		return false;
	}
	
	public boolean deleteAccount(long accountNumber) {
		BankAccount temp = null;
		for(BankAccount account: accounts) {
			if(account.getAccountNumber() == accountNumber) {
				temp = account;
				break;
			}
		}
		if(temp!=null) {
			accounts.remove(temp);
			saveToFile();
			return true;
		}
		return false;
	}
	
	public BankAccount searchAccount(long accountNumber) {
		for(BankAccount account:accounts) {
			if(account.getAccountNumber()==accountNumber) {
				return account;
			}
		}
		return null;
	}
}
