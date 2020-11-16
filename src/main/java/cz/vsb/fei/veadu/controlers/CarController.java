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

import cz.vsb.fei.veadu.bl.services.CarService;
import cz.vsb.fei.veadu.bl.services.EmployeeService;
import cz.vsb.fei.veadu.bl.services.GarageService;
import cz.vsb.fei.veadu.entities.vehicles.Car;
import javassist.NotFoundException;

@Controller
public class CarController {
	
	@Autowired
	CarService carService;
	
	@Autowired
	EmployeeService employeeService;

	@Autowired
	GarageService garageService;

	
	@GetMapping("/car/edit/{id}")
	public String carEdit(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Car not found!");
		}
		Car car = carService.findOne(id);
		if (car == null) {
			throw new NotFoundException("Car not found!");
		}
		
		model.addAttribute("car", car);
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("garages", garageService.findAll());
		
		return "vehicles/car_edit";
	}
	
	@PostMapping("/car/edit/{id}")
	public String carCreateSave(@PathVariable long id, @ModelAttribute @Validated Car car, BindingResult carResult, Model model) {
		if(carResult.hasErrors()) {
			System.out.println(carResult.getAllErrors());
			car.setId(id);
			return "vehicles/car_edit";
		}
		car.setId(id);
		carService.edit(car);
		
		return "redirect:/vehicle/list";
	}

	
	@GetMapping("/car/remove/{id}")
	public String carCreate(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Car not found!");
		}
		carService.deleteById(id);
		
		return "redirect:/vehicle/list";
	}
	
	@GetMapping("/car/create")
	public String carCreate(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("garages", garageService.findAll());
		
		return "vehicles/car_create";
	}
	
	@PostMapping("/car/create")
	public String carCreateSave(@ModelAttribute @Validated Car car, BindingResult carResult, Model model) {
		if(carResult.hasErrors()) {
			System.out.println(carResult.getAllErrors());
			return "vehicles/car_create";
		}
		carService.create(car);
		
		return "redirect:/vehicle/list";
	}
}
