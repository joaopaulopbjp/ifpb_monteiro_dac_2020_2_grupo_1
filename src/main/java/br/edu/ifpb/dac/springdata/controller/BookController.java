package br.edu.ifpb.dac.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import br.edu.ifpb.dac.springdata.model.Author;
import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.model.PublishingCompany;
import br.edu.ifpb.dac.springdata.service.AuthorService;
import br.edu.ifpb.dac.springdata.service.BookService;
import br.edu.ifpb.dac.springdata.service.PublishingCompanyService;

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
	
	@Autowired
	private AuthorService authorService;
	
	@Autowired
	private PublishingCompanyService publishingCompanyService;
	
	
	public void saveAuthor(long id, Book book) throws Exception {
		
		bookService.saveAuthor(id, book);
		
	}
	@ModelAttribute("authorsAll")
	public List<Author> authors(){
		return authorService.findAll();
	}
	@ModelAttribute("publishers")
	public List<PublishingCompany> publishers(){
		return publishingCompanyService.findAll();
	}
	

	@GetMapping("/newBook")
	public String newBookform(Book book) {
		
		
		return "book/form";
	}
	
	@PostMapping("/newBook")
	public String newBook(@ModelAttribute Book book, BindingResult bindingResult) {
		
		
		if (bindingResult.hasErrors()) {
            return "book/form";
        }
		
		bookService.save(book);
		
		return "redirect:/book/list";
	}
	@GetMapping("/list")
	public ModelAndView listBook() {
		List<Book> books = bookService.getBooks(0, 5);
		System.out.println(books.size());
		
		ModelAndView mv = new ModelAndView("book/list");
		mv.addObject("books",books);
		
		return mv;
	}
	@GetMapping("/{id}")
	public ModelAndView editBook(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("book/form");
		try {
			System.out.println(id);
			mv.addObject(bookService.findById(id));
			System.out.println("foi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") long id) {
		
		try {
			bookService.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/book/list";
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
