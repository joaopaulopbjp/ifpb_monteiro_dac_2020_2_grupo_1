package br.edu.ifpb.dac.springdata.controller;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.dac.springdata.model.Categoria;
import br.edu.ifpb.dac.springdata.service.CategoriaService;

public class CategoriaController {
	
	private CategoriaService categoriaService;
	
	@GetMapping("/newCategoria")
	public ModelAndView newCategoria() {
		
		ModelAndView mv = new ModelAndView("cateforia/form");
		mv.addObject(new Categoria());
	
		return mv;
	}
	
	@PostMapping("/newCategoria")
	public String newCategoria(@ModelAttribute Categoria categoria, BindingResult bindingResult) {
		
		
		if (bindingResult.hasErrors()) {
            return "cateforia/form";
        }
		
		categoriaService.save(categoria);
		
		return "redirect:/categoriay/list";
	}
	@GetMapping("/list")
	public ModelAndView listCategoria() {
		List<Categoria> categorias = categoriaService.findALL();
		System.out.println(categorias.size());
		
		ModelAndView mv = new ModelAndView("categoria/list");
		mv.addObject("categorias",categorias);
		
		return mv;
	}
	@GetMapping("/{id}")
	public ModelAndView editCategoria(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("categoria/form");
		try {
			System.out.println(id);
			mv.addObject(categoriaService.findById(id));
			System.out.println("foi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	@GetMapping("/delete/{id}")
	public String deleteCategoria(@PathVariable("id") long id) {
		
		try {
			categoriaService.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/categoria/list";
	}
	
	
}



