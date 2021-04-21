package br.edu.ifpb.dac.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * camada intermediária responsavel por gerenciar Book
 * @author: Gabriel Oliveira && Alisson
 */




@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	public void saveAuthor(long id, Book book) throws Exception {
		
		bookService.saveAuthor(id, book);
		
	}

	@GetMapping("/newBook")
	public ModelAndView newBookform() {
		
		ModelAndView mv = new ModelAndView("book/form");
		mv.addObject(new Book());
	
		return mv;
	}
	
	@PostMapping("/newBook")
	public ModelAndView newBook(@ModelAttribute Book book, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("book/form");
		if (bindingResult.hasErrors()) {
            return mv;
        }
		
		bookService.save(book);
		
		return mv;
	}
	
	public Book findById(long parseLong) {
		
		return null;
	}

	public void deleteById(Long bookIdDelete) throws Exception {
		
		bookService.deleteById(bookIdDelete);
		
	}
	//consulta feita de forma asc
	public Page<Book> listaTodosBooks(){
		
		 return bookService.ListFiveBookByPrice(PageRequest.of(0, 100, Sort.by(Sort.Direction.ASC, "price")));
		
	}
	
	//LISTA OS 5 MAIS BARATOS
	public Page<Book> listaFiveprice(){
		
		 return bookService.ListFiveBookByPrice(PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "price")));
		
	}
	
	
	


	
	
	
}
