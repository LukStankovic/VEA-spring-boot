package cz.vsb.fei.veadu.entities.vehicles;

public class Car extends Vehicle {
	
	private int numberOfPassengers;
	
	private double trunkSize;
	

	public Car() {
		super();
	}
	
	public Car(int year, String manufacturer, String model, String registrationPlate, int numberOfPassengers, double trunkSize) {
		super(year, manufacturer, model, registrationPlate);
		this.numberOfPassengers = numberOfPassengers;
		this.trunkSize = trunkSize;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public double getTrunkSize() {
		return trunkSize;
	}

	public void setTrunkSize(double trunkSize) {
		this.trunkSize = trunkSize;
	}
}
