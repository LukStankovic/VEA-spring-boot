package cz.vsb.fei.veadu.entities.vehicles;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cz.vsb.fei.veadu.entities.Employee;
import cz.vsb.fei.veadu.entities.Garage;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Vehicle  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Min(value=1980)
	private int year;
	
	@NotEmpty
	private String manufacturer;
	
	private String model;
	
	@NotEmpty
	private String registrationPlate;
	
	@JsonIgnoreProperties({"vehicles"})
	@ManyToOne
	private Employee owner;
	
	@JsonIgnoreProperties({"parkedVehicles"})
	@ManyToOne
	private Garage garage;
	
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

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		owner.addVehicle(this);
		this.owner = owner;
	}

	public Garage getGarage() {
		return garage;
	}

	public void setGarage(Garage garage) {
		garage.parkVehicle(this);
		this.garage = garage;
	}
}
