package br.edu.ifpb.dac.springdata.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


import br.edu.ifpb.dac.springdata.model.Book;

/**
 * usa a camada de persistência para gravar e recuperar os dados necessários para
 * persistir e recuperar os objetos de Book
 * @author: Gabriel Oliveira && Alisson
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	 
	List<Book> findByTitleContaining(String bookName);
	
}