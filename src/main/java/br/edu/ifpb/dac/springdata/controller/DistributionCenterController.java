package br.edu.ifpb.dac.springdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.edu.ifpb.dac.springdata.model.DistributionCenter;
import br.edu.ifpb.dac.springdata.service.DistributionCenterService;

@Controller
public class DistributionCenterController {

	
	@Autowired
	private DistributionCenterService distributionCenterService;
	
	public DistributionCenter save(DistributionCenter distributionCenter) {
		
		return distributionCenterService.save(distributionCenter);
	}
	
			
}
