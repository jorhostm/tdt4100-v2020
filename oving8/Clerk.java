package patterns.delegation.office;

import java.util.function.BinaryOperator;


public class Clerk implements Employee {
	private Printer printer;
	private int tasks = 0;
	public Clerk(Printer printer) {
		this.printer = printer;
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		tasks++;
		return operation.apply(value1, value2);
	}

	@Override
	public void printDocument(String document) {
		printer.printDocument(document, this);
		tasks++;

	}

	@Override
	public int getTaskCount() {
		// TODO Auto-generated method stub
		return tasks;
	}

	@Override
	public int getResourceCount() {
		// TODO Auto-generated method stub
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
