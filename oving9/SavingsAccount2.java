package inheritance;

public class SavingsAccount2 extends AbstractAccount {

	private int withdrawals;
	private double fee;
	
	public SavingsAccount2(int w, double f) {
		super();
		this.withdrawals = w;
		this.fee = f;
	}

	@Override
	protected void internalWithdraw(double w) {
		double f = 0.0;
		if(withdrawals > 0)
			withdrawals--;
		else
			f = fee;
		if(balance - f - w < 0)
			throw new IllegalStateException();
		balance -= (f + w);

	}

}
