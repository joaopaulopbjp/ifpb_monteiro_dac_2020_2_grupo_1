package br.edu.ifpb.dac.springdata.repository;



import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Author;
/**
 * usa a camada de persistência para gravar e recuperar os dados necessários para
 * persistir e recuperar os objetos de Author
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
