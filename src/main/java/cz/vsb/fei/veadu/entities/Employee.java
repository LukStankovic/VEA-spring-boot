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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cz.vsb.fei.veadu.entities.vehicles.Vehicle;

@Entity
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String surname;
	
	@OneToMany(mappedBy="owner")
	private List<Vehicle> vehicles = new ArrayList<>();;

	public Employee() {
		super();
	}

	public Employee(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public void addVehicle(Vehicle vehicle) {
		if (!vehicles.contains(vehicle)) {
			this.vehicles.add(vehicle);
			vehicle.setOwner(this);
		}
	}
	
	public void removeVehicle(Vehicle vehicle) {
		if (vehicles.contains(vehicle)) {
			this.vehicles.remove(vehicle);
			vehicle.setOwner(null);
		}
	}
}
