 package com.BankManagementSystem;

public class BankAccount {
//	@private variables for encapsulation
	private String name;
	private long accountNumber;
	private int age;
	private String gender;
	private double balance;
//	@constructor of the bank account
	BankAccount(String name, long accountNumber, int age, String gender, double balance){
		if(name==null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		
		if(accountNumber<=0) {
			throw new IllegalArgumentException("Account number must be positive"); 
		} 
		 
		if(age<=0 || age>100) {
			 throw new IllegalArgumentException("Age must be between 18 or 100");
		}
		if(gender == null|| gender.isEmpty()) {
			throw new IllegalArgumentException("Gender cannot be empty");
		}
		if(balance <=0 || !Double.isFinite(balance)) {
			throw new IllegalArgumentException("Invalid balance");
		}
		this.name = name;
		this.accountNumber = accountNumber;
		this.age = age;			
		this.gender = gender;
		this.balance = balance;
	}
//   @Getters  
	public String getName() {
		return name;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public double getBalance() {
		return balance;
	}
//    @Setter with validation
	public void setName(String name) {
		if(name==null || name.isEmpty()) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		this.name = name.trim();
	}
	public void setAge(int age) {
		if(age<=0 || age>100) {
			 throw new IllegalArgumentException("Age must be between 18 or 100");
		}
		this.age = age;
	}
	public void setGender(String gender) {
		if(gender == null|| gender.isEmpty()) {
			throw new IllegalArgumentException("Gender cannot be empty");
		}
		this.gender = gender.trim();
	}
	public void setBalance(double balance) {
		if(balance <= 0 || !Double.isFinite(balance)) {
			throw new IllegalArgumentException("Invalid amount");
		}
		this.balance = balance;
	}
	
	
	
}
