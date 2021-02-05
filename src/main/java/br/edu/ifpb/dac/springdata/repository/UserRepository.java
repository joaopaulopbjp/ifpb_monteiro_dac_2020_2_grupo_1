package br.edu.ifpb.dac.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.dac.springdata.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	
	User findByEmail(String email);
}
