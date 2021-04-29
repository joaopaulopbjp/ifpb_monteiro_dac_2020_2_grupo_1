package br.edu.ifpb.dac.springdata.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.edu.ifpb.dac.springdata.model.Stock;
import br.edu.ifpb.dac.springdata.repository.StockRepository;
import br.edu.ifpb.dac.springdata.service.StockService;

/**
 * camada intermediária responsavel por gerenciar Stock
 * @author: Gabriel Oliveira && Alisson
 */
@Controller
@RequestMapping("/Stock")
public class StockController {

	@Autowired
	private StockService stockService;
	@Autowired
	private StockRepository stockRepository;
	
	
	
	public Stock save(Stock stock) {
		return stockService.save(stock);
		
	}
	@GetMapping("/list")
	public ModelAndView listCategoria() {
		List<Stock> stock = stockService.findALL();
		System.out.println(stock.size());
		
		ModelAndView mv = new ModelAndView("stock/list");
		mv.addObject("stock",stock);
		
		return mv;
	}
	
	@PutMapping("/update/{id}")
	public ModelAndView updateStock(Stock stock) {
		stockRepository.save(stock);
		
		ModelAndView mv = new ModelAndView("stock/form");
		mv.addObject(new Stock());
		return mv;
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStock(@PathVariable("id") long id) {
		
		try {
			stockRepository.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/stock/list";
	}
	
	
}
