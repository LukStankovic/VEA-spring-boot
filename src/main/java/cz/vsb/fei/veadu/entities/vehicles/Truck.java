package cz.vsb.fei.veadu.entities.vehicles;

public class Truck extends Vehicle {

	private double maxTow;
	
	private int axleCount;

	public Truck() {
		super();
	}	

	public Truck(int year, String manufacturer, String model, String registrationPlate, double maxTow, int axleCount) {
		super(year, manufacturer, model, registrationPlate);
		this.maxTow = maxTow;
		this.axleCount = axleCount;
	}

	public double getMaxTow() {
		return maxTow;
	}

	public void setMaxTow(double maxTow) {
		this.maxTow = maxTow;
	}

	public int getAxleCount() {
		return axleCount;
	}

	public void setAxleCount(int axleCount) {
		this.axleCount = axleCount;
	}
}
