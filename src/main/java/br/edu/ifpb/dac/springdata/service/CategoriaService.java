package br.edu.ifpb.dac.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.dac.springdata.model.Categoria;
import br.edu.ifpb.dac.springdata.repository.CategoriaRepository;

public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria save(Categoria categoria) {
		
		return categoriaRepository.save(categoria);
		
	}
	
	public List<Categoria> findALL(){
		
		return categoriaRepository.findAll();
		
	}
	
	public Categoria findById(long id) {
		
		return categoriaRepository.findById(id).get();
		
	}
	
	public void deleteById(long id) {
		
		 categoriaRepository.deleteById(id);
	}

}
