package br.edu.ifpb.dac.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.Author;
import br.edu.ifpb.dac.springdata.repository.AuthorRepository;
/**
 * responsável por se comunicar com as camadas mais internas
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
		
		return  (List<Author>) authorRepository.findAll();
	}
	//DELETA AUTor
	public void delet(long id) {
		
		authorRepository.deleteById(id);
	}
	
	
	public Author findAuthorById(Long id) {
		
		return authorRepository.findById(id).orElseThrow(null);
	}
	
}
