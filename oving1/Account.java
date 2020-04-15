package stateandbehavior;

public class Account {
	
	double balance, interestRate;
	
	public void deposit(double i) {
		
		if(i >= 0) balance += i;
	}
	
	public void addInterest() {
		balance += (balance*interestRate/100);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void setInterestRate(double i) {
		interestRate = i;
	}
	
	public static void main(String[] args) {
		Account a = new Account();
		a.balance = 10;
		a.interestRate = 3;
		System.out.println(a.getBalance());
		System.out.println(a.getInterestRate());
		a.deposit(90);
		a.setInterestRate(5);
		a.addInterest();
		System.out.println(a.getBalance());

	}

}
