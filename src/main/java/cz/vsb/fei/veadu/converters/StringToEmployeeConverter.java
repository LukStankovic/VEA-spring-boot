package cz.vsb.fei.veadu.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cz.vsb.fei.veadu.bl.services.EmployeeService;
import cz.vsb.fei.veadu.entities.Employee;


@Component
public class StringToEmployeeConverter implements Converter<String, Employee>{

	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public Employee convert(String source) {
		if(source == null || source.isBlank()) {
			return null;
		}
		try {
			return employeeService.findOne(Long.parseLong(source));
		} catch (NumberFormatException e) {
			return null;
		}
	}

}