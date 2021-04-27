package br.edu.ifpb.dac.springdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.model.PublishingCompany;
import br.edu.ifpb.dac.springdata.service.PublishingCompanyService;

@Controller
@RequestMapping("/publishingCompany")
public class PublishingCompanyController {

	
	@Autowired
	private PublishingCompanyService publishingCompanyService;
	
	
	@GetMapping("/newPublishingCompany")
	public ModelAndView newPublishingCompany() {
		
		ModelAndView mv = new ModelAndView("publishing-company/form");
		mv.addObject(new PublishingCompany());
	
		return mv;
	}
	
	@PostMapping("/newPublishingCompany")
	public String newPublishingCompany(@ModelAttribute PublishingCompany publishingCompany, BindingResult bindingResult) {
		
		
		if (bindingResult.hasErrors()) {
            return "publishing-company/form";
        }
		
		publishingCompanyService.save(publishingCompany);
		
		return "redirect:/publishingCompany/list";
	}
	@GetMapping("/list")
	public ModelAndView listPublishingCompany() {
		List<PublishingCompany> publishers = publishingCompanyService.findAll();
		System.out.println(publishers.size());
		
		ModelAndView mv = new ModelAndView("publishing-company/list");
		mv.addObject("publishers",publishers);
		
		return mv;
	}
	@GetMapping("/{id}")
	public ModelAndView editPublishingCompany(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("publishing-company/form");
		try {
			System.out.println(id);
			mv.addObject(publishingCompanyService.findById(id));
			System.out.println("foi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return mv;
	}
	@GetMapping("/delete/{id}")
	public String deletePublishingCompany(@PathVariable("id") long id) {
		
		try {
			publishingCompanyService.deleteById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/publishingCompany/list";
	}
	
	
}
