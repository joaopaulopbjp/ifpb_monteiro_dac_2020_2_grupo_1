package br.edu.ifpb.dac.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.springdata.model.User;
import br.edu.ifpb.dac.springdata.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	public User save(User newUser) {
		
		return userService.save(newUser);
	}

	
	
}
