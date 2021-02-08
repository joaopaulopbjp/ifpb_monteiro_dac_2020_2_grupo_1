package br.edu.ifpb.dac.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.Shelf;
import br.edu.ifpb.dac.springdata.repository.ShelfRepository;

@Service
public class ShelfService {

	@Autowired
	private ShelfRepository shelfRepository;
	
	
	public Shelf save(Shelf shelf) {
		return shelfRepository.save(shelf);
	}
	
}
