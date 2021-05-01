package br.edu.ifpb.dac.springdata.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
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
	
	private static String imagePath = System.getProperty("user.dir") + "/src/main/resources/static/images/";
	
	
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
	public String newBook(@ModelAttribute Book book, BindingResult bindingResult, @RequestParam("file") MultipartFile arquivo) {
		
		
		if (bindingResult.hasErrors()) {
            return "book/form";
        }
		
		bookService.save(book);
		
		try {
			if (!arquivo.isEmpty()) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths
						.get(imagePath + String.valueOf(book.getId()) + arquivo.getOriginalFilename());
				Files.write(caminho, bytes);

				book.setImgId(String.valueOf(book.getId()) + arquivo.getOriginalFilename());
				bookService.save(book);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/book/list";
	}

	@GetMapping("/list")
	public ModelAndView listBook(@RequestParam(defaultValue = "") String title) {
	
		List<Book> books = bookService.findByTitleContaining(title);
		
		ModelAndView mv = new ModelAndView("book/list");
		mv.addObject("books",books);
		
		return mv;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	
	@GetMapping("/info/cover/{imgPath}")
	@ResponseBody
	public byte[] retornarImagem(@PathVariable("imgPath") String imagem) throws IOException {
		System.out.println(imagem);
		File imagemArquivo = new File(imagePath + imagem);
		if (imagem != null || imagem.trim().length() > 0) {
			System.out.println("No IF");
			return Files.readAllBytes(imagemArquivo.toPath());
		}
		
		
		return null;
	}
	
	@GetMapping("/info/{id}")
	public ModelAndView infoBook(@PathVariable("id")long id) {
		ModelAndView mv = new ModelAndView("book/info");
		try {
			Book book = bookService.findById(id);
			mv.addObject(book);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		return mv;
	}
		
}
