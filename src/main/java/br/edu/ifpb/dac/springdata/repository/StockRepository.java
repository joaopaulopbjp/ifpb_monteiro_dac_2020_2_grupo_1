package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Stock;

/**
 * usa a camada de persistência para gravar e recuperar os dados necessários para
 * persistir e recuperar os objetos de Stock
 * @author: Gabriel Oliveira && Alisson
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	//Stock FindByName(String name);
	
	
}
