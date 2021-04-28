package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.User;

/**
 * usa a camada de persistência para gravar e recuperar os dados necessários para
 * persistir e recuperar os objetos de User
 * @author: Gabriel Oliveira && Alisson
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	User findByEmail(String email);
}
