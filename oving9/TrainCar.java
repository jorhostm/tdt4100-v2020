package inheritance;

public class TrainCar {

	protected int deadWeight;
	
	
	public TrainCar(int w) {
		this.deadWeight = w;
	}
	
	public void setDeadWeight(int w) {
		this.deadWeight = w;
	}
	
	public int getDeadWeight() {
		return deadWeight;
	}
	
	public int getTotalWeight() {
		return this.deadWeight;
	}


}
