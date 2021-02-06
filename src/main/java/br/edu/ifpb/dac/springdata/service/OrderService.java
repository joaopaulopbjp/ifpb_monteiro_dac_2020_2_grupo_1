package br.edu.ifpb.dac.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.Order;
import br.edu.ifpb.dac.springdata.repository.OrderRepository;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public Order save(Order order) {
		
		return orderRepository.save(order);
	}
	
}
