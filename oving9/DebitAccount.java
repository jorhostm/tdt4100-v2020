package inheritance;

public class DebitAccount extends AbstractAccount {

	public DebitAccount() {
		super();
	}

	@Override
	protected void internalWithdraw(double w) throws IllegalStateException {
		if(super.balance - w < 0)
			throw new IllegalStateException();
		super.balance -= w;

	}

}
