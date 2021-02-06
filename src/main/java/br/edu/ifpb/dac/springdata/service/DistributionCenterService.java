package br.edu.ifpb.dac.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.ifpb.dac.springdata.model.DistributionCenter;
import br.edu.ifpb.dac.springdata.repository.DistributionCenterRepository;


/**
 * 
 * @author: Gabriel Oliveira && Alisson
 */

@Service
public class DistributionCenterService {

	
	@Autowired
	private DistributionCenterRepository distributionCenterRepository;
	
	
	public DistributionCenter save(DistributionCenter DCR) {
		
		return distributionCenterRepository.save(DCR);
		
	}
	
	public DistributionCenter findById(Long id) {
		
		return distributionCenterRepository.findById(id).orElseThrow();
	}
	
	public void delete(Long id) {
		
		distributionCenterRepository.delete(findById(id));
	}
	
	
	
}
