package br.edu.ifpb.dac.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.User;
import br.edu.ifpb.dac.springdata.repository.UserRepository;
/**
 * responsável por se comunicar com as camadas mais internas
 * @author: Gabriel Oliveira && Alisson
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User save(User user) {
		
		String passwordBC = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPasswordUser(passwordBC);
		
		return userRepository.save(user);
	}
	
	public User findById(Long id) throws Exception {
		
		return userRepository.findById(id).orElseThrow(null);
	}
	
	public void deleteUserById(Long id) throws Exception{
		
		User user = findById(id);

		userRepository.delete(user);
	
	}
	
	public User findByEmail(String email) {
		
		return userRepository.findByEmail(email);
		
	}
	
	public User findByUsername(String usarname) {
		return userRepository.findByUsername(usarname);
	}
	
	public String getLogin() {

		Authentication principal = SecurityContextHolder.getContext().getAuthentication();

		return principal.getName();

	}
	
}
