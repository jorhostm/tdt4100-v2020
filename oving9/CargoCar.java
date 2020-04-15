package inheritance;

public class CargoCar extends TrainCar{

	private int load;
	
	public CargoCar(int w, int l) {
		super(w);
		this.load = l;
	}
	
	public int getCargoWeight() {
		return load;
	}

	public void setCargoWeight(int w){
		this.load = w;
	}
	
	@Override
	public int getTotalWeight() {
		return super.deadWeight + this.load;
	}

}
