package cz.vsb.fei.veadu.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cz.vsb.fei.veadu.bl.services.CarService;
import cz.vsb.fei.veadu.bl.services.EmployeeService;
import cz.vsb.fei.veadu.bl.services.GarageService;
import cz.vsb.fei.veadu.bl.services.TruckService;
import cz.vsb.fei.veadu.entities.Employee;
import cz.vsb.fei.veadu.entities.Garage;
import cz.vsb.fei.veadu.entities.vehicles.Car;
import cz.vsb.fei.veadu.entities.vehicles.Truck;

@Controller
public class HomepageController {

	@Autowired
	CarService carService;
	
	@Autowired
	TruckService truckService;
	
	@Autowired
	EmployeeService employeeService;

	@Autowired
	GarageService garageService;
	
	
	@GetMapping("/")
	public String index(Model model) {
		
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/403")
	public String error() {
		return "403";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/build/demo")
	public String buildDemo(Model model) {
		
		garageService.create(new Garage("Hlavní", "Ostrava"));
		garageService.create(new Garage("Malá", "Brno"));
		garageService.create(new Garage("Pražská", "Praha"));
		
		employeeService.create(new Employee("Lukáš", "Stankovič"));
		employeeService.create(new Employee("Petr", "Novák"));
		employeeService.create(new Employee("Jan", "Peroutka"));	
		employeeService.create(new Employee("Franta", "Šiška"));
		
		
		Car octavia = new Car(2020, "Škoda", "Octavia", "1T1 1234",5, 500);
		octavia.setGarage(garageService.findOne(1));
		octavia.setOwner(employeeService.findOne(1));
		carService.create(octavia);
		
		Car superb = new Car(2019, "Škoda", "Superb", "1T1 4321", 5, 550);
		superb.setGarage(garageService.findOne(1));
		superb.setOwner(employeeService.findOne(2));
		carService.create(superb);
		
		Car fabia = new Car(2017, "Škoda", "Fabia", "9T9 1234", 5, 300);
		fabia.setGarage(garageService.findOne(2));
		fabia.setOwner(employeeService.findOne(2));
		carService.create(fabia);
		
		Car kodiaq = new Car(2020, "Škoda", "Kodiaq", "8AX 1234", 5, 490);
		kodiaq.setGarage(garageService.findOne(3));
		kodiaq.setOwner(employeeService.findOne(3));
		carService.create(kodiaq);
		
		
		Car mazda = new Car(2020, "Mazda", "MX5", "1AA 1234", 2, 100);
		mazda.setGarage(garageService.findOne(3));
		mazda.setOwner(employeeService.findOne(4));
		carService.create(mazda);
		
		Truck scania = new Truck(2018, "Scania", "ABC", "1B2 1234", 1000.5, 6);
		scania.setGarage(garageService.findOne(1));
		scania.setOwner(employeeService.findOne(1));
		truckService.create(scania);
		
		return "redirect:/";
	}
}
