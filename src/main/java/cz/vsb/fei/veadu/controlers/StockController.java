package cz.vsb.fei.veadu.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cz.vsb.fei.veadu.bl.services.StockService;
import cz.vsb.fei.veadu.entities.jdbc.Stock;
import javassist.NotFoundException;



@Controller
public class StockController {

	@Autowired
	StockService stockService;
		
	@GetMapping("/stock/list")
	public String stockList(Model model) {
		List<Stock> stocks = stockService.findAll();
		model.addAttribute("stocks", stocks);
		
		return "stock/list";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/stock/edit/{id}")
	public String stockEdit(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Stock not found!");
		}
		Stock stock = stockService.findOne(id);
		if (stock == null) {
			throw new NotFoundException("Stock not found!");
		}
		
		model.addAttribute("stock", stock);
		
		return "stock/edit";
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/stock/edit/{id}")
	public String stockCreateSave(@PathVariable long id, @ModelAttribute @Validated Stock stock, BindingResult stockResult, Model model) {
		if(stockResult.hasErrors()) {
			System.out.println(stockResult.getAllErrors());
			stock.setId(id);
			return "garage_edit";
		}
		stock.setId(id);
		stockService.edit(stock);
		
		return "redirect:/stock/list";
	}

	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/stock/remove/{id}")
	public String stockCreate(@PathVariable long id, Model model) throws NotFoundException {
		if (id <= 0) {
			throw new NotFoundException("Stock not found!");
		}
		stockService.deleteById(id);
		
		return "redirect:/stock/list";
	}
	
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/stock/create")
	public String stockCreate(Model model) {
		model.addAttribute("stock", new Stock());
		
		return "stock/create";
	}
	
	@Secured({"ROLE_ADMIN"})
	@PostMapping("/stock/create")
	public String stockCreateSave(@ModelAttribute @Validated Stock stock, BindingResult employeeResult, Model model) {
		if(employeeResult.hasErrors()) {
			System.out.println(employeeResult.getAllErrors());
			return "stock/create";
		}
		stockService.create(stock);
		
		return "redirect:/stock/list";
	}
}