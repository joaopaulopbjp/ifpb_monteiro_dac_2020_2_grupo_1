package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	
	
	
}
