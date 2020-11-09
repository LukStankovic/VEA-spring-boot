package cz.vsb.fei.veadu.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

	@GetMapping("/car/list")
	public String carsList(Model model) {
		
		return "cars";
	}
	
}
