package br.edu.ifpb.dac.springdata.service;

import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.ItemPedido;
import br.edu.ifpb.dac.springdata.repository.ItemPedidoRepository;



@Service
public class ItemPedidoService {
	
	private ItemPedidoRepository crud;
	
   public boolean delete (ItemPedido itemPedido){
	   crud.delete(itemPedido);
	   return true;
   }
   
}
