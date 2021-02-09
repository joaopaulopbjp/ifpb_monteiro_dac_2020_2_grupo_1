package br.edu.ifpb.dac.springdata.repository;
 




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Book;

/**
 * 
 * @author: Gabriel Oliveira && Alisson
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	 
	//public Book findBookByTitulo(String titulo);
	
}