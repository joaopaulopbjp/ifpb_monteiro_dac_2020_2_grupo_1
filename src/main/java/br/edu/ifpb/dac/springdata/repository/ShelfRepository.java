package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Shelf;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Long> {

	
	
}
