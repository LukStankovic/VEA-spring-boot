package cz.vsb.fei.veadu.controlers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.vsb.fei.veadu.bl.services.EmployeeService;
import cz.vsb.fei.veadu.entities.Employee;

@Controller
public class EmployeeApiController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/api/v1/employees")
	@ResponseBody
	public List<Employee> garagesList() {
		List<Employee> employees = employeeService.findAll();
		
		return employees;
	}
	
	@GetMapping("/api/v1/employees/{id}")
	@ResponseBody
	public Employee employeeDetail(@PathVariable long id) {
		Employee employee = employeeService.findOne(id);
		
		return employee;
	}
}
