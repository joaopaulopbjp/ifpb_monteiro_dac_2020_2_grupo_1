package br.edu.ifpb.dac.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.dac.springdata.model.User;
import br.edu.ifpb.dac.springdata.service.UserService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("index");
		
		if(userService.getLogin().equals("anonymousUser")) {
			
		}else {
			User user = userService.findByUsername(userService.getLogin());
			mv.addObject("user", user);
		}
		
		return mv;
	}
	
}
