package br.edu.ifpb.dac.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.Author;
import br.edu.ifpb.dac.springdata.repository.AuthorRepository;
/**
 * 
 * @author: Gabriel Oliveira && Alisson
 */
@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRepository;
	
	//METODO SALVAR UM AUTOR NO BANCO DE DADOS
	public Author save(Author author) {
		
		return authorRepository.save(author);
	}
	
	//METODO PARA RETORNAR AUTORES CADASTRADOS 
	public List<Author> findAll(){
		
		return (List<Author>) authorRepository.findAll();
	}
	
}
