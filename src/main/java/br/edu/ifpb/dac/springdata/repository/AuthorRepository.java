package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifpb.dac.springdata.model.Author;
/**
 * 
 * @author: Gabriel Oliveira && Alisson
 */
public interface AuthorRepository extends CrudRepository<Author, Long>{

	
}
