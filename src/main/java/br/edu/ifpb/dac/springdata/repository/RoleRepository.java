package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.Role;



@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
//   public Role findByNome(String nomeRole);
}
