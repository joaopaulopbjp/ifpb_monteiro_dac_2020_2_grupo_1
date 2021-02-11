package br.edu.ifpb.dac.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.springdata.model.Author;
import br.edu.ifpb.dac.springdata.service.AuthorService;

@Controller
public class AuthorController {

	
	@Autowired
	private AuthorService authorService;
	
	
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
