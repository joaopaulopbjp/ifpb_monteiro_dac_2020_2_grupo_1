package br.edu.ifpb.dac.springdata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.model.Stock;
import br.edu.ifpb.dac.springdata.service.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService stockService;
	
	public Stock save(Stock stock) {
		return stockService.save(stock);
	}
	
	
}
