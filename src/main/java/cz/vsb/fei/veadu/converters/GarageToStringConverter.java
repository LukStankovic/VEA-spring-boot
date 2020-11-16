package cz.vsb.fei.veadu.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import cz.vsb.fei.veadu.entities.Garage;

@Component
public class GarageToStringConverter implements Converter<Garage, String>{
	
	@Override
	public String convert(Garage source) {
		if(source == null) {
			return "null";
		}
		return Long.toString(source.getId());
	}

}
