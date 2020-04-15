package inheritance;

public class PassengerCar extends TrainCar{

	private int passengers;
	
	public PassengerCar(int w, int p) {
		super(w);
		this.passengers = p;
	}
	
	public int getPassengerCount() {
		return this.passengers;
	}

	public void setPassengerCount(int p) {
		this.passengers = p;
	}
	
	@Override
	public int getTotalWeight() {
		return super.deadWeight + 80*this.passengers;
	}

}
