package cz.vsb.fei.veadu.controlers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


public class HomepageController {

	@GetMapping("/")
	public String index(Model model) {
		
		return "index";
	}
	
}
