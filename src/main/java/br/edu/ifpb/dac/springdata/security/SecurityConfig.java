package br.edu.ifpb.dac.springdata.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.edu.ifpb.dac.springdata.model.Status;
import br.edu.ifpb.dac.springdata.model.User;
import br.edu.ifpb.dac.springdata.service.UserService;

@Configuration
public class SecurityConfig {

	@Autowired
	private static UserService crud;
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		User usuario = new User();
		usuario.setUsername("admin");
		usuario.setPasswordUser(new BCryptPasswordEncoder().encode("1234"));
		usuario.setRoles(new ArrayList<>());
		usuario.setStatus(Status.ATIVO);
		usuario.setEmail("gabriel0@gmail.com");
		crud.save(usuario);
		
		System.out.println("Criando Usuário ........");
//	System.out.println(new BCryptPasswordEncoder().encode("admins"));
	}
}
