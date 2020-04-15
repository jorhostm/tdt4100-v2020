package encapsulation;

public class Account {
	
	private double balance, interestRate;
	
	private void checkIfNegative(double i) throws IllegalArgumentException {
		if(i<0) throw new IllegalArgumentException("Input kan ikke være negativ");
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double input) {
		checkIfNegative(input);
		interestRate = input;
	}
	
	public void deposit(double input) {
		checkIfNegative(input);
		balance += input;
	}
	
	public void withdraw(double input) {
		checkIfNegative(input);
		checkIfNegative(balance-input);
		balance -= input;
	}
	
	public void addInterest() {
		balance += (balance*interestRate/100);
	}
	
	public Account(double balance, double interestRate) {
		checkIfNegative(balance);
		checkIfNegative(interestRate);
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account a = new Account(100.0,5.0);
	}

}
