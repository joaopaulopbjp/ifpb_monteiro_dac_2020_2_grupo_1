package br.edu.ifpb.dac.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.service.BookService;

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

	
	
	
}
