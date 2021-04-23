package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Historico;



@Repository
public interface HistoricoRepository extends JpaRepository<Historico,Long>  {
     public Historico findById(long id);
}
