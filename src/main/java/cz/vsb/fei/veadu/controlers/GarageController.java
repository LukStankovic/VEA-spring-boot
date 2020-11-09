package cz.vsb.fei.veadu.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cz.vsb.fei.veadu.bl.services.GarageService;
import cz.vsb.fei.veadu.entities.Garage;
import javassist.NotFoundException;

@Controller
public class GarageController {
	
	@Autowired
	GarageService garageService;

	@GetMapping("/garage/list")
	public String garageList(Model model) {
		List<Garage> garages = garageService.findAll();
		model.addAttribute("garages", garages);
		
		return "garage_list";
	}
	
	@GetMapping("/garage/edit/{id}")
	public String grageEdit(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Garage not found!");
		}
		Garage garage = garageService.findOne(id);
		if (garage == null) {
			throw new NotFoundException("Garage not found!");
		}
		
		model.addAttribute("garage", garage);
		
		return "garage_edit";
	}
	
	@PostMapping("/garage/edit/{id}")
	public String grageCreateSave(@PathVariable long id, @ModelAttribute @Validated Garage garage, BindingResult garageResult, Model model) {
		if(garageResult.hasErrors()) {
			System.out.println(garageResult.getAllErrors());
			garage.setId(id);
			return "garage_edit";
		}
		garage.setId(id);
		garageService.edit(garage);
		
		return "redirect:/garage/list";
	}

	
	@GetMapping("/garage/remove/{id}")
	public String grageCreate(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Garage not found!");
		}
		garageService.deleteById(id);
		
		return "redirect:/garage/list";
	}
	
	@GetMapping("/garage/create")
	public String grageCreate(Model model) {
		model.addAttribute("garage", new Garage());
		
		return "garage_create";
	}
	
	@PostMapping("/garage/create")
	public String grageCreateSave(@ModelAttribute @Validated Garage garage, BindingResult garageResult, Model model) {
		if(garageResult.hasErrors()) {
			System.out.println(garageResult.getAllErrors());
			return "garage_create";
		}
		garageService.create(garage);
		
		return "redirect:/garage/list";
	}
	
}
