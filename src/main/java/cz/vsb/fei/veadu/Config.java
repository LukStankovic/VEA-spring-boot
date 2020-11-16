package cz.vsb.fei.veadu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cz.vsb.fei.veadu.converters.EmployeeToStringConverter;
import cz.vsb.fei.veadu.converters.GarageToStringConverter;
import cz.vsb.fei.veadu.converters.StringToEmployeeConverter;
import cz.vsb.fei.veadu.converters.StringToGarageConverter;


@Configuration
public class Config implements WebMvcConfigurer {

	@Autowired
	private StringToGarageConverter stringToGarageConverter;
	
	@Autowired
	private StringToEmployeeConverter stringToEmployeeConverter;
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(stringToGarageConverter);
		registry.addConverter(new GarageToStringConverter());
		
		registry.addConverter(stringToEmployeeConverter);
		registry.addConverter(new EmployeeToStringConverter());
	}

}
