package br.edu.ifpb.dac.springdata.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.dac.springdata.model.DistributionCenter;

/**
 * 
 * @author: Gabriel Oliveira && Alisson
 */

public interface DistributionCenterRepository extends JpaRepository<DistributionCenter, Long> {

	
}
