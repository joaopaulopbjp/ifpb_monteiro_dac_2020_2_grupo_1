package br.edu.ifpb.dac.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.Historico;
import br.edu.ifpb.dac.springdata.repository.HistoricoRepository;



@Service
public class HistoricoService {
	
	@Autowired
	private HistoricoRepository repository;
     public Historico findById(long id){
    	 return repository.findById(id);
     }

}
