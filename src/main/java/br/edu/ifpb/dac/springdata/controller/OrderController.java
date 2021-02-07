package br.edu.ifpb.dac.springdata.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import br.edu.ifpb.dac.springdata.model.Order;
import br.edu.ifpb.dac.springdata.service.OrderService;

@Controller
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	public Order saveBook(Order Order,Long idBook) {
		
	
		return orderService.save(Order);
	}
	
}
