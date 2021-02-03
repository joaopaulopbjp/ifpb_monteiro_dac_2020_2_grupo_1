package br.edu.ifpb.dac.springdata.repository;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
 
	//Page<Book> FindByPrecieRange(BigDecimal value, Pageable pages);
}