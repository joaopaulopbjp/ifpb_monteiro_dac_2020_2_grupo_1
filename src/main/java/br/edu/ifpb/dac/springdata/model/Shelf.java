package br.edu.ifpb.dac.springdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * Partileira
 * @author: Gabriel Oliveira && Alisson
 */

@Entity
public class Shelf {

	@Id
	@Column(name = "shelf_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	private DistributionCenter distributionCenter;
	
	
	public DistributionCenter getDistributionCenter() {
		return distributionCenter;
	}


	public void setDistributionCenter(DistributionCenter distributionCenter) {
		this.distributionCenter = distributionCenter;
	}


	public Shelf() {
		
		
	}
	
	
	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shelf other = (Shelf) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
