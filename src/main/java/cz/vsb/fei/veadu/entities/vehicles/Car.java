package cz.vsb.fei.veadu.entities.vehicles;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Car extends Vehicle {
	
	private static final long serialVersionUID = 1L;
	
	@Min(value=1)
	@Max(value=9)
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
