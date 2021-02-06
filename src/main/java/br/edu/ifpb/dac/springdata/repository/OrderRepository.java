package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.dac.springdata.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	public Order findOrderByName(String name);
}
