package com.BankManagementSystem;

public class BankOperations {
	
	private BankRecord records;
	
	public BankOperations(BankRecord records) {
		this.records = records;
	}
	
//method created for depositing the amount into the user account 
	public boolean depositMoney(long accountNumber, double amount) {
//		step 1 deposit amount validation
		if(amount<=0 || !Double.isFinite(amount)) {
			System.out.println("Invalid deposite amount!");
			return false;
		}
		
//		step 2 searching the account
		BankAccount account = records.searchAccount(accountNumber);
		 
//		step 3 check whether the account exist or not
		if(account==null) {
			System.out.println("Account not found!");
			return false;
		}
		
//		step 4 deposit amount and calculate new balance
		double newBalance = account.getBalance() + amount;
		
//		step 5 check for overflow
		if(!Double.isFinite(newBalance)) {
			System.out.println("Deposite amount is too large!");
			return false;
		}
		
//		step 6 update balance
		try {
			account.setBalance(newBalance);
			records.saveChanges();
		}catch(IllegalArgumentException e) {
			System.out.println("Deposit failed: "+e.getMessage());
			return false;
		}
		
		System.out.println("Amount deposited successfully!");
		System.out.println("Updated balance: "+account.getBalance());
		
		return true;
	}
	
//this method is created for withdrawing the amount from the user's account
     public boolean withdrawMoney(long accountNumber, double amount) {
    	 
//     step 1 withdraw amount validation check
     if(amount<=0 || !Double.isFinite(amount)) {
          System.out.println("Invalid withdraw amount!");
          return false;
     }
//     step 2 searching the account
     BankAccount account = records.searchAccount(accountNumber); 
     
//     step 3 checking the account existence
     if(account==null) {
    	 System.out.println("Account not found!");
    	 return false;
     }
     
//     step 4 checking balance validation for withdrawal
     if(amount>account.getBalance()) {
    	 System.out.println("Insufficient balance!");
    	 return false;
     }
    		
//     step 5 new balance calculation after withdrawal
     double newBalance = account.getBalance() - amount;
     account.setBalance(newBalance);
     records.saveChanges();
    	  
     System.out.println("Amount withdrawn successfully!");
     System.out.println("Remaining balance: "+account.getBalance());
    	 return true;
     }
	
//this method is created for checking the balance
     public Double checkBalance(long accountNumber) {
//     step 1 account searching
    	 BankAccount account = records.searchAccount(accountNumber);
    	 
//     step 2 account existence check
    	 if(account == null) {
    		 System.out.println("Account not found!");
    		 return null;
           }
    	 
//    step 3 account details displaying
    	 System.out.println("Account Holder: " + account.getName());
    	 System.out.println("Current Balance: " + account.getBalance());

    	 return account.getBalance();
     }
     
}
