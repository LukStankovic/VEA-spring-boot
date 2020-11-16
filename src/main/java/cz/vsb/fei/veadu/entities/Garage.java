package cz.vsb.fei.veadu.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import cz.vsb.fei.veadu.entities.vehicles.Vehicle;

@Entity
public class Garage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String city;
	
	@OneToMany(mappedBy = "garage")
	private List<Vehicle> parkedVehicles = new ArrayList<>();
	
	public Garage() {		
		super();
	}

	public Garage(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	

	@Override
	public String toString() {
		return "Garage [name=" + name + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Vehicle> getParkedVehicles() {
		return parkedVehicles;
	}

	public void setParkedVehicles(List<Vehicle> parkedVehicles) {
		this.parkedVehicles = parkedVehicles;
	}

	public void parkVehicle(Vehicle vehicle) {
		if (!parkedVehicles.contains(vehicle)) {
			this.parkedVehicles.add(vehicle);
			vehicle.setGarage(this);
		}
	}

	public void unparkVehicle(Vehicle vehicle) {
		if (parkedVehicles.contains(vehicle)) {
			this.parkedVehicles.remove(vehicle);
			vehicle.setGarage(null);
		}
	}
}

