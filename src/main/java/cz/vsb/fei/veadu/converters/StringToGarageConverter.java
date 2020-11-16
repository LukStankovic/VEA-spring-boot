package cz.vsb.fei.veadu.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cz.vsb.fei.veadu.bl.services.GarageService;
import cz.vsb.fei.veadu.entities.Garage;


@Component
public class StringToGarageConverter implements Converter<String, Garage>{

	@Autowired
	private GarageService garageService;
	
	@Override
	public Garage convert(String source) {
		if(source == null || source.isBlank()) {
			return null;
		}
		try {
			return garageService.findOne(Long.parseLong(source));
		} catch (NumberFormatException e) {
			return null;
		}
	}

}