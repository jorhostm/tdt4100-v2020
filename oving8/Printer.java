package patterns.delegation.office;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {
	private Map<Employee, List<String>> history = new HashMap<Employee, List<String>>();
	
	void printDocument(String document, Employee employee) {
		System.out.println(document);
		List<String> history = this.history.get(employee);
		
		if(history == null) {
			history = new ArrayList<String>();
			history.add(document);
			this.history.put(employee, history);
		}
		else
			history.add(document);
	}
	
	List<String> getPrintHistory(Employee employee){
		return this.history.getOrDefault(employee, new ArrayList<String>());
	}

}
