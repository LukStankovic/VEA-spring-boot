package cz.vsb.fei.veadu.controlers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.vsb.fei.veadu.bl.services.VehicleService;
import cz.vsb.fei.veadu.entities.vehicles.Vehicle;

@Controller
public class GarageApiController {

	@Autowired
	VehicleService vehlicleService;
	
	@GetMapping("/api/v1/vehicles")
	@ResponseBody
	public List<Vehicle> vehiclesList() {
		List<Vehicle> vehicles = vehlicleService.findAll();
		
		return vehicles;
	}
	
	@GetMapping("/api/v1/vehicles/{id}")
	@ResponseBody
	public Vehicle vehiclesDetail(@PathVariable long id) {
		Vehicle vehicle = vehlicleService.findOne(id);
		
		return vehicle;
	}
}
