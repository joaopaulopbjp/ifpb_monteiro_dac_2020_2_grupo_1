package br.edu.ifpb.dac.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.Role;
import br.edu.ifpb.dac.springdata.repository.RoleRepository;



@Service
public class RoleService {
	@Autowired
	private RoleRepository repository;
	
//	public Role findByNome(String nome){
//		return repository.findByNome(nome);
//	}
	
	public boolean create (Role role){
		repository.saveAndFlush(role);
		return true;
	}
	
	public List<Role>readAll(){
		return repository.findAll();
	}
}
