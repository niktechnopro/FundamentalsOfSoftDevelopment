package samplepackage;

public class BankAccount {
	double balance;
	String name;
	
	public BankAccount() {
		this.balance = 0.0;
		this.name = "Someone";
	}
	
	
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
	}
}
