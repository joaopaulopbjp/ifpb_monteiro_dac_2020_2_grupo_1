package br.edu.ifpb.dac.springdata;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import br.edu.ifpb.dac.springdata.model.Role;
import br.edu.ifpb.dac.springdata.model.Status;
import br.edu.ifpb.dac.springdata.model.User;
import br.edu.ifpb.dac.springdata.service.RoleService;
import br.edu.ifpb.dac.springdata.service.UserService;


@Component
public class ScheduledTasks  implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private UserService crud;
	
	@Autowired
	private RoleService crudRole;
	
//	@Autowired
//	private CarrinhoService crudCarrinho;
	
	private String senha;
	
	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}
	


	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("a espera de um milagre");
		System.out.println("----- Criando Usuário ------");
		creatUsuarioAdmin();
		System.out.println("----- Usuário Criado com Sucesso! -----");
	}
	
	private void creatUsuarioAdmin() {
		
    User user = crud.findByUsername("admin");
    
	Role roleADMIN = crudRole.findByNomeRole("ROLE_ADMIN");	
	Role roleUSER = crudRole.findByNomeRole("ROLE_USER");
	
	if(roleADMIN == null && roleUSER == null){
		roleADMIN = new Role();
		roleUSER = new Role();
		
		roleADMIN.setNomeRole("ROLE_ADMIN");
		roleUSER.setNomeRole("ROLE_USER");
		
		crudRole.create(roleADMIN);
		crudRole.create(roleUSER);
		System.out.println("Criando Permições ........");
	}
	
		if (user == null) {
			User usuario = new User();
			usuario.setUsername("sempus");
			senha = "aidentro";
			usuario.setRoles(new ArrayList<>());
			System.out.println("senhaDT:"+usuario.getPassword()); //1
			usuario.getRoles().add(crudRole.findByNomeRole("ROLE_ADMIN")	);
			usuario.setStatus(Status.ATIVO);
			usuario.setEmail("gabriel0@gmail.com");
		    usuario.setPasswordUser(senha);
			crud.save(usuario);

		}
	}
}

