package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.model.User;

/**
 * 
 * @author: Gabriel Oliveira && Alisson
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
	User findByEmail(String email);
}
