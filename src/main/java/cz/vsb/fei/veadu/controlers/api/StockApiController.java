package cz.vsb.fei.veadu.controlers.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.vsb.fei.veadu.bl.services.GarageService;
import cz.vsb.fei.veadu.bl.services.StockService;
import cz.vsb.fei.veadu.entities.Garage;
import cz.vsb.fei.veadu.entities.jdbc.Stock;
import javassist.NotFoundException;

@Controller
public class StockApiController {

	@Autowired
	StockService stockService;
	
	@GetMapping("/api/v1/stocks")
	@ResponseBody
	public List<Stock> stocksList() {
		List<Stock> stocks = stockService.findAll();
		
		return stocks;
	}
	
	@GetMapping("/api/v1/stocks/{id}")
	@ResponseBody
	public Stock stockDetail(@PathVariable long id) throws NotFoundException {
		Stock stock = stockService.findOne(id);
		
		if (stock == null) {
			throw new NotFoundException("Stock was not found!");
		}
		
		return stock;
	}
}
