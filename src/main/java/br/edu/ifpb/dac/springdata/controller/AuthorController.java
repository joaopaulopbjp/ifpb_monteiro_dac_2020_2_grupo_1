package br.edu.ifpb.dac.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.dac.springdata.model.Author;
import br.edu.ifpb.dac.springdata.service.AuthorService;
/**
 * camada intermediária responsavel por gerenciar author
 * @author: Gabriel Oliveira && Alisson
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

	
	@Autowired
	private AuthorService authorService;
	
	
	@GetMapping("/newAuthor")
	public ModelAndView newAuthor() {
		ModelAndView mv = new ModelAndView("autores/form");
		
		mv.addObject(new Author());
		return mv;
	}
	
	
	
	public Author save(Author author) {
		
		return authorService.save(author);
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
