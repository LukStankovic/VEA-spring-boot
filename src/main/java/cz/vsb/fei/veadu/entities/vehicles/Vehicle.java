package cz.vsb.fei.veadu.entities.vehicles;

public class Vehicle {

	private long id;
	
	private int year;
	
	private String manufacturer;
	
	private String model;
	
	private String registrationPlate;

	
	public Vehicle() {
		super();
	}
	
	public Vehicle(int year, String manufacturer, String model, String registrationPlate) {
		super();
		this.year = year;
		this.manufacturer = manufacturer;
		this.model = model;
		this.registrationPlate = registrationPlate;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getRegistrationPlate() {
		return registrationPlate;
	}

	public void setRegistrationPlate(String registrationPlate) {
		this.registrationPlate = registrationPlate;
	}
}
