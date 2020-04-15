package inheritance;

public abstract class AbstractAccount {
	
	protected double balance = 0;
	
	public void deposit(double d) throws IllegalArgumentException {
		if (d < 0)
			throw new IllegalArgumentException();
		this.balance += d;
	}

	public void withdraw(double w) {
		if (w < 0)
			throw new IllegalArgumentException();
		this.internalWithdraw(w);
	}
	
	protected abstract void internalWithdraw(double w);

	public double getBalance() {
		return this.balance;
	}
	
}
