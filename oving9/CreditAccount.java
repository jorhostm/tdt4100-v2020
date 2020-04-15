package inheritance;

public class CreditAccount extends AbstractAccount {

	private double creditLine;
	
	public CreditAccount(double d) {
		super();
		this.setCreditLine(d);
	}

	public void setCreditLine(double d) {
		// TODO Auto-generated method stub
		if (d < 0)
			throw new IllegalArgumentException();
		if (super.balance + d < 0)
			throw new IllegalStateException();
		this.creditLine = d;
	}
	

	@Override
	protected void internalWithdraw(double w) {
		if(super.balance + this.creditLine - w < 0)
			throw new IllegalStateException();
		super.balance -= w;
	}

	public double getCreditLine() {
		// TODO Auto-generated method stub
		return this.creditLine;
	}

}
