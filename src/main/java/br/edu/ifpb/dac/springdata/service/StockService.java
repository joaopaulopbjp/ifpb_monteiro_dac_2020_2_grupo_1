package br.edu.ifpb.dac.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.ifpb.dac.springdata.model.Stock;
import br.edu.ifpb.dac.springdata.repository.StockRepository;

/**
 * responsável por se comunicar com as camadas mais internas
 * @author: Gabriel Oliveira && Alisson
 */
@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	
	
	public Stock save(Stock stock) {
		return stockRepository.save(stock);
	}
	
	
	public Stock FindStockById(Long id) {
		
		return stockRepository.findById(id).orElseThrow(null);
	}
	
public List<Stock> findALL(){
		
		return stockRepository.findAll();
		
	}
}
