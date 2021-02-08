package br.edu.ifpb.dac.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.springdata.model.Shelf;
import br.edu.ifpb.dac.springdata.service.ShelfService;

@Controller
public class ShelfController {

	@Autowired
	private ShelfService shelfService;
	
	
	public Shelf save(Shelf shelf) {
		
		return shelfService.save(shelf);
	}
}
