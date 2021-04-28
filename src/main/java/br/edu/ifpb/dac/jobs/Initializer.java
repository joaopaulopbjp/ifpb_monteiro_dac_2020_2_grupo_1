package br.edu.ifpb.dac.jobs;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.ifpb.dac.springdata.model.Role;
import br.edu.ifpb.dac.springdata.model.Status;
import br.edu.ifpb.dac.springdata.model.User;
import br.edu.ifpb.dac.springdata.service.CarrinhoService;
import br.edu.ifpb.dac.springdata.service.RoleService;
import br.edu.ifpb.dac.springdata.service.UserService;



//public class Initializer implements ApplicationListener<ContextRefreshedEvent>{
//	
//	@Autowired
//	private UserService crud;
//	
//	@Autowired
//	private RoleService crudRole;
//	
//	@Autowired
//	private CarrinhoService crudCarrinho;
//	
//	public void onApplicationEvent(ContextRefreshedEvent event) {
//		System.out.println("----- Criando Usuário ------");
//		creatUsuarioAdmin();
//		System.out.println("----- Usuário Criado com Sucesso! -----");
//	}
//	
//	private void creatUsuarioAdmin() {
//		
//    User user = crud.findByUsername("admin");
//    
////	Role roleADMIN = crudRole.findByNome("ROLE_ADMIN");	
////	Role roleUSER = crudRole.findByNome("ROLE_USER");
//	
//	if(roleADMIN == null && roleUSER == null){
//		roleADMIN = new Role();
//		roleUSER = new Role();
//		
//		roleADMIN.setNomeRole("ROLE_ADMIN");
//		roleUSER.setNomeRole("ROLE_USER");
//		
//		crudRole.create(roleADMIN);
//		crudRole.create(roleUSER);
//		System.out.println("Criando Permições ........");
//	}
//	
//		if (user == null) {
//			User usuario = new User();
//			usuario.setUsername("admin");
//			usuario.setPasswordUser(new BCryptPasswordEncoder().encode("1234"));
//			usuario.setRoles(new ArrayList<>());
//			usuario.getRoles().add(crudRole.findByNome("ROLE_ADMIN")	);
//			usuario.setStatus(Status.ATIVO);
//			usuario.setEmail("gabriel0@gmail.com");
//			crud.save(usuario);
//			
//			System.out.println("Criando Usuário ........");
//		}
//	}

