package br.edu.ifpb.dac.springdata.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.dac.springdata.repository.UserRepository;

/**
 * Classe de serviço do spring security onde verifica no banco os dados do
 * usuario.
 */

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		br.edu.ifpb.dac.springdata.model.User user = ur.findByUsername(login);
		
		if(user == null){
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
		
	}
	
	
	
}
