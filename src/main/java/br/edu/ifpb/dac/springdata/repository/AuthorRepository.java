package br.edu.ifpb.dac.springdata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Author;
/**
 * 
 * @author: Gabriel Oliveira && Alisson
 */

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{
	
	//busca autor
	//public List<Author> findByNomeContainingIgnoreCase (String name);
   
	//teste verica os autores sem livros
	//@Query("select id from TB_Author a where a.books is empty and a.id=:id")
   // Long autorSemLivros(@Param("id") Long id);
}
