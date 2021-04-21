package br.edu.ifpb.dac.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.Carrinho;
import br.edu.ifpb.dac.springdata.repository.CarrinhoRepository;


@Service
public class CarrinhoService {
	
   @Autowired
   private CarrinhoRepository repository;
   
   public boolean delete (Carrinho carrinho){
	   repository.delete(carrinho);
	   return true;
   }
   
   public Carrinho findById (long id){
	  return repository.getOne(id);
   }
   
   public boolean create(Carrinho carrinho){
	   repository.saveAndFlush(carrinho);
	   return true;
   }
}
