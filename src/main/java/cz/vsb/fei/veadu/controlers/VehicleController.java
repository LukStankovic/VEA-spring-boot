package cz.vsb.fei.veadu.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cz.vsb.fei.veadu.bl.services.CarService;
import cz.vsb.fei.veadu.bl.services.TruckService;
import cz.vsb.fei.veadu.entities.vehicles.Car;
import cz.vsb.fei.veadu.entities.vehicles.Truck;

@Controller
public class VehicleController {

	@Autowired
	CarService carService;

	@Autowired
	TruckService truckService;
	
	
	
	@GetMapping("/vehicle/list")
	public String vehiclesList(Model model) {
		
		List<Car> cars = carService.findAll();
		model.addAttribute("cars", cars);
		
		List<Truck> trucks = truckService.findAll();
		model.addAttribute("trucks", trucks);
	
		
		return "vehicles/vehicle_list";
	}
	
}
