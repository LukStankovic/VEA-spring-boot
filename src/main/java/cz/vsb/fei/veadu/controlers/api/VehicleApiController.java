package cz.vsb.fei.veadu.controlers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.vsb.fei.veadu.bl.services.GarageService;
import cz.vsb.fei.veadu.entities.Garage;

@Controller
public class VehicleApiController {

	@Autowired
	GarageService garageService;
	
	@GetMapping("/api/v1/garages")
	@ResponseBody
	public List<Garage> garagesList() {
		List<Garage> garages = garageService.findAll();
		
		return garages;
	}
	
	@GetMapping("/api/v1/garages/{id}")
	@ResponseBody
	public Garage garageDetail(@PathVariable long id) {
		Garage garage = garageService.findOne(id);
		
		return garage;
	}
}
