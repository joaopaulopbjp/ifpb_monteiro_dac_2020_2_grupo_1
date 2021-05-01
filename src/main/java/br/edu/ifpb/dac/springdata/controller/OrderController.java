package br.edu.ifpb.dac.springdata.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpb.dac.springdata.model.Order;
import br.edu.ifpb.dac.springdata.service.OrderService;

/**
 * camada intermediária responsavel por gerenciar Order
 * @author: Gabriel Oliveira && Alisson
 */

@Controller
@RequestMapping("/order")
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	public Order saveBook(Order Order) {
		
	
		return orderService.save(Order);
	}
	 
	
	
}
