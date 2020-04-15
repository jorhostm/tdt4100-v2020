package stateandbehavior;

public class UpOrDownCounter {

	int counter, end;
	private int inc;
	
	void checkInput(int start, int end) throws IllegalArgumentException {
		if(start == end) throw new IllegalArgumentException("Start og end kan ikke være det samme");
	}
	
	public UpOrDownCounter(int start, int end) {
	
		checkInput(start,end);
		this.counter = start;
		this.end = end;
		this.inc = start > end ? -1 : 1;
	}
	
	int getCounter() {
		return counter;
	}
	
	boolean count() {
		if (counter == end) {
			return false;
		}
		else {
			counter += inc;
			if(counter == end) {
				return false;
			}
			else {
				return true;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpOrDownCounter a = new UpOrDownCounter(1,3);
		System.out.println(a.getCounter());
		System.out.println(a.count());
		System.out.println(a.getCounter());
		System.out.println(a.count());
		System.out.println(a.getCounter());
		

	}

}
