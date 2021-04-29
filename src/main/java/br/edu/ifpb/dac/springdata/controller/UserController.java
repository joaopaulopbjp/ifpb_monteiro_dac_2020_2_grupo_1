package br.edu.ifpb.dac.springdata.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import br.edu.ifpb.dac.springdata.model.User;
import br.edu.ifpb.dac.springdata.service.UserService;


/**
 * camada intermediária responsavel por gerenciar User
 * @author: Gabriel Oliveira && Alisson
 */
@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/singUp")
    public ModelAndView save(@ModelAttribute @Valid User usuario, BindingResult bindingResult) {
		
		ModelAndView mv = new ModelAndView("user/form");
		if (bindingResult.hasErrors()) {
            return mv;
        }

        userService.save(usuario);
        return mv;
    }
	
	@GetMapping("/singUp")
    public ModelAndView usuarios() {
		ModelAndView mv = new ModelAndView("user/form");
		mv.addObject(new User());
	
		return mv;
    }
	
	@GetMapping("/singIn")
	public String login() {
		
		return "login";
	}
	
	
//	public User save(User newUser) {
//		
//		return userService.save(newUser);
//	}

	public User FindByEmail(String email) {
		
		
		return userService.findByEmail(email);
	}
	
}
