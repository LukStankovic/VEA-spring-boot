package cz.vsb.fei.veadu.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cz.vsb.fei.veadu.entities.Employee;

@Component
public class EmployeeToStringConverter implements Converter<Employee, String>{
	
	@Override
	public String convert(Employee source) {
		if(source == null) {
			return "null";
		}
		return Long.toString(source.getId());
	}

}
