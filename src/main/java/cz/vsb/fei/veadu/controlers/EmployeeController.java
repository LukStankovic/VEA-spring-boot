package cz.vsb.fei.veadu.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cz.vsb.fei.veadu.bl.services.EmployeeService;
import cz.vsb.fei.veadu.bl.services.GarageService;
import cz.vsb.fei.veadu.entities.Employee;
import javassist.NotFoundException;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employee/list")
	public String employeeList(Model model) {
		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		
		return "employee/employee_list";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/employee/edit/{id}")
	public String employeeEdit(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Employee not found!");
		}
		Employee employee = employeeService.findOne(id);
		if (employee == null) {
			throw new NotFoundException("Employee not found!");
		}
		
		model.addAttribute("employee", employee);
		
		return "employee/employee_edit";
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/employee/edit/{id}")
	public String grageCreateSave(@PathVariable long id, @ModelAttribute @Validated Employee employee, BindingResult employeeResult, Model model) {
		if(employeeResult.hasErrors()) {
			System.out.println(employeeResult.getAllErrors());
			employee.setId(id);
			return "garage_edit";
		}
		employee.setId(id);
		employeeService.edit(employee);
		
		return "redirect:/employee/list";
	}

	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/employee/remove/{id}")
	public String grageCreate(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Employee not found!");
		}
		employeeService.deleteById(id);
		
		return "redirect:/employee/list";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/employee/create")
	public String grageCreate(Model model) {
		model.addAttribute("employee", new Employee());
		
		return "employee/employee_create";
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/employee/create")
	public String grageCreateSave(@ModelAttribute @Validated Employee garage, BindingResult employeeResult, Model model) {
		if(employeeResult.hasErrors()) {
			System.out.println(employeeResult.getAllErrors());
			return "employee/employee_create";
		}
		employeeService.create(garage);
		
		return "redirect:/employee/list";
	}
}
