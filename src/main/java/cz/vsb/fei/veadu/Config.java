package cz.vsb.fei.veadu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class Config implements WebMvcConfigurer {
/*
	@Autowired
	private PersonConverter2 personConverter2;
	*/
	@Override
	public void addFormatters(FormatterRegistry registry) {
		//registry.addConverter(personConverter2);
		//registry.addConverter(new PersonConverter());
	}

}
