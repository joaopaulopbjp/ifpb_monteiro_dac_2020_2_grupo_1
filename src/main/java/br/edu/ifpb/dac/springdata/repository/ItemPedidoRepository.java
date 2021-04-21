package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.ItemPedido;


@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido,Long> {

}
