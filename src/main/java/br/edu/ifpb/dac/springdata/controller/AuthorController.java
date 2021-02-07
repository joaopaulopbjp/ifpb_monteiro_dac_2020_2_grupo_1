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
	
}
