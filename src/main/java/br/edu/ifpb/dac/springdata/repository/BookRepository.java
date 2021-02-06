package br.edu.ifpb.dac.springdata.repository;
 




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Book;

/**
 * 
 * @author: Gabriel Oliveira && Alisson
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	 

	
}