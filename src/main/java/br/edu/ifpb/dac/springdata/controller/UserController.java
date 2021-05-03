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
	
	@PostMapping("/signUp")
    public String save(@ModelAttribute @Valid User usuario, BindingResult bindingResult) {
		
		@SuppressWarnings("unused")
		ModelAndView mv = new ModelAndView("user/sing-up");
		if (bindingResult.hasErrors()) {
            return "user/sing-up";
        }

        userService.save(usuario);
        return "redirect:/author/list";
    }
	
	@GetMapping("/signUp")
    public ModelAndView usuarios() {
		ModelAndView mv = new ModelAndView("user/sing-up");
		mv.addObject(new User());
	
		return mv;
    }
	
	@GetMapping("/signIn")
	public String login() {
		
		return "login";
	}
	
}
