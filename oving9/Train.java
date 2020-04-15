package inheritance;

import java.util.ArrayList;
import java.util.Collection;

public class Train {

	private Collection<TrainCar> cars = new ArrayList<>();
	
	public void addTrainCar(TrainCar car) {
		cars.add(car);
	}
	
	public boolean contains(TrainCar car) {
		return cars.contains(car);
	}
	
	public int getTotalWeight() {
		return cars.parallelStream().reduce(0, (sum, n) -> sum + n.getTotalWeight(), Integer::sum);
	}
	
	public int getPassengerCount() {
		return cars.parallelStream().filter(e -> e instanceof PassengerCar).reduce(0, (sum, n) -> sum + ((PassengerCar) n).getPassengerCount(), Integer::sum);
	}
	
	public int getCargoWeight() {
		return cars.parallelStream().filter(e -> e instanceof CargoCar).reduce(0, (sum, n) -> sum + ((CargoCar) n).getCargoWeight(), Integer::sum);
	}
	
	@Override
	public String toString() {
		String s = "";
		for (TrainCar car : this.cars) {
			if(car instanceof PassengerCar)
				s += "PassengerCar " + car.getTotalWeight() + " " + ((PassengerCar) car).getPassengerCount();
			else if(car instanceof CargoCar)
				s += "CargoCar " + car.getTotalWeight() + " " + ((CargoCar) car).getCargoWeight();
			else
				s += "TrainCar " + car.getTotalWeight();
			s += "\n";
		}
		return s;
	}
}
