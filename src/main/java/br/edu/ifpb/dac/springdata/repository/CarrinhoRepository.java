package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Carrinho;


@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho,Long>{
	   
}