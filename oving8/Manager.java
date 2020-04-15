package patterns.delegation.office;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.BinaryOperator;

public class Manager implements Employee {
	private Collection<Employee> employees;
	private Iterator<Employee> iterator;
	
	public Manager(Collection<Employee> employees) throws IllegalArgumentException{
		if(employees.isEmpty()) throw new IllegalArgumentException();
		this.employees = employees;
		this.iterator = employees.iterator();
	}

	@Override
	public double doCalculations(BinaryOperator<Double> operation, double value1, double value2) {
		if(!iterator.hasNext())
			iterator = employees.iterator();
		return iterator.next().doCalculations(operation, value1, value2);
	}

	@Override
	public void printDocument(String document) {
		if(!iterator.hasNext())
			iterator = employees.iterator();
		iterator.next().printDocument(document);
	}

	@Override
	public int getTaskCount() {
		return employees.parallelStream().reduce(0, (sum, n) -> sum + n.getTaskCount(), Integer::sum);
	}

	@Override
	public int getResourceCount() {
		return 1 + employees.parallelStream().reduce(0, (sum, n) -> sum + n.getResourceCount(), Integer::sum);
	}
	
	

	public static void main(String[] args) {
		Printer printer = new Printer();
		Collection<Employee> clerks = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			clerks.add(new Clerk(printer));
		}
		Manager manager = new Manager(clerks);
		System.out.println(manager.getTaskCount()/manager.getResourceCount());
		
		Collection<Employee> managers = new ArrayList<>();
		for(int a = 0; a < 20; a++) {
			Collection<Employee> managers1 = new ArrayList<>();
			for(int b = 0; b < 100; b++) {
				Collection<Employee> managers2 = new ArrayList<>();
				for(int c = 0; c < 100; c++) {
					Collection<Employee> clerk = new ArrayList<>();
					Printer printer1 = new Printer();
					for(int d = 0; d < 100; d++) {
						clerk.add(new Clerk(printer1));
					}
					managers2.add(new Manager(clerk));
				}
				managers1.add(new Manager(managers2));
			}
			managers.add(new Manager(managers1));
		}
		System.out.println("////////");
		Manager multiManager = new Manager(managers);
		
		System.out.println(multiManager.getTaskCount()/multiManager.getResourceCount());
		

	}

}
