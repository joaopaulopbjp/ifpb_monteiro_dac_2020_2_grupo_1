package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Categoria;

@Repository
public interface  CategoriaRepository extends JpaRepository<Categoria, Long>{

}
