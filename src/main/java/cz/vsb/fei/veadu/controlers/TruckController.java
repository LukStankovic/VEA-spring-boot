package cz.vsb.fei.veadu.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cz.vsb.fei.veadu.bl.services.TruckService;
import cz.vsb.fei.veadu.entities.vehicles.Truck;
import javassist.NotFoundException;

@Controller
public class TruckController {
	
	@Autowired
	TruckService truckService;

	@GetMapping("/truck/edit/{id}")
	public String truckEdit(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Truck not found!");
		}
		Truck truck = truckService.findOne(id);
		if (truck == null) {
			throw new NotFoundException("Truck not found!");
		}
		
		model.addAttribute("truck", truck);
		
		return "vehicles/truck_edit";
	}
	
	@PostMapping("/truck/edit/{id}")
	public String truckCreateSave(@PathVariable long id, @ModelAttribute @Validated Truck truck, BindingResult truckResult, Model model) {
		if(truckResult.hasErrors()) {
			System.out.println(truckResult.getAllErrors());
			truck.setId(id);
			return "vehicles/truck_edit";
		}
		truck.setId(id);
		truckService.edit(truck);
		
		return "redirect:/vehicle/list";
	}

	
	@GetMapping("/truck/remove/{id}")
	public String truckCreate(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Truck not found!");
		}
		truckService.deleteById(id);
		
		return "redirect:/vehicle/list";
	}
	
	@GetMapping("/truck/create")
	public String truckCreate(Model model) {
		model.addAttribute("truck", new Truck());
		
		return "vehicles/truck_create";
	}
	
	@PostMapping("/truck/create")
	public String truckCreateSave(@ModelAttribute @Validated Truck truck, BindingResult truckResult, Model model) {
		if(truckResult.hasErrors()) {
			System.out.println(truckResult.getAllErrors());
			return "vehicles/truck_create";
		}
		truckService.create(truck);
		
		return "redirect:/vehicle/list";
	}
}
