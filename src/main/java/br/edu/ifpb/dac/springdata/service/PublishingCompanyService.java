package br.edu.ifpb.dac.springdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.PublishingCompany;
import br.edu.ifpb.dac.springdata.repository.PublishingCompanyRepository;

@Service
public class PublishingCompanyService {

	@Autowired
	private PublishingCompanyRepository publishingCompanyRepository;
	
	public PublishingCompany save(PublishingCompany publishingCompany) {
		
		return publishingCompanyRepository.save(publishingCompany);
	}
	
	public List<PublishingCompany> findAll(){
		
		return publishingCompanyRepository.findAll();
	}
	
	public PublishingCompany findById(long id) {
		
		return publishingCompanyRepository.findById(id).get();
	}
	
	public void deleteById(long id) {
		
		publishingCompanyRepository.deleteById(id);
	}
	
}
