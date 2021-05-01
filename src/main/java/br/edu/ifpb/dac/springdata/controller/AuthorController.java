package br.edu.ifpb.dac.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.dac.springdata.model.Author;
import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.model.User;
import br.edu.ifpb.dac.springdata.service.AuthorService;
import br.edu.ifpb.dac.springdata.service.UserService;
/**
 * camada intermediária responsavel por gerenciar author
 * @author: Gabriel Oliveira && Alisson
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthorService authorService;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/newAuthor")
	public ModelAndView newAuthor() {
		ModelAndView mv = new ModelAndView("author/form");

		mv.addObject(new Author());
		return mv;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/newAuthor")
	public String saveAuthor(@ModelAttribute Author author ,  BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "author/form";
		}
		authorService.save(author);

		return "redirect:/author/newAuthor";
	}

	@GetMapping("/list")
	public ModelAndView listAuthors() {
		List<Author> authors = authorService.findAll();
		System.out.println(authors.size());

		ModelAndView mv = new ModelAndView("author/list");
		
		if(userService.getLogin().equals("anonymousUser")) {

		}else {
			User user = userService.findByUsername(userService.getLogin());
			mv.addObject("user", user);
		}

		
		mv.addObject("authors",authors);

		return mv;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ModelAndView editAuthor(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("author/form");
		try {
			System.out.println(id);
			mv.addObject(authorService.findAuthorById(id));
			System.out.println("foi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return mv;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteAuthor(@PathVariable("id") long id) {

		try {
			authorService.delet(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/author/list";
	}



	public Author findAuthorById(Long id) {

		return authorService.findAuthorById(id);
	}

	/**
	 * **************NOTA**************
	 * metodo para deletar
	 * Colocado a anotação ROLES_ALLOWED para deletar precisa do papel de administrador.
	 * @param id
	 * @return
	 */
	public void delet(long id) {

		authorService.delet(id);
	}





}
