package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Order;

/**
 * usa a camada de persistência para gravar e recuperar os dados necessários para
 * persistir e recuperar os objetos de Order
 * @author: Gabriel Oliveira && Alisson
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	//public Order findOrderByName(String name);
}
