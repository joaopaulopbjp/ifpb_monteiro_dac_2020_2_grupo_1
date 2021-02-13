package br.edu.ifpb.dac.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.data.domain.Sort;
import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;




@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	public void saveAuthor(long id, Book book) throws Exception {
		
		bookService.saveAuthor(id, book);
		
	}

	public Book save(Book book) {
		
		return bookService.save(book);
	}

	public Book findById(long parseLong) {
		
		return null;
	}

	public void deleteById(Long bookIdDelete) throws Exception {
		
		bookService.deleteById(bookIdDelete);
		
	}
	//consulta feita de forma asc
	public Page<Book> listaTodosBooks(){
		
		 return bookService.ListFiveBookByPrice(PageRequest.of(0, 5, Sort.by(Sort.Direction.ASC, "price")));
		
	}
	
	
	


	
	
	
}
