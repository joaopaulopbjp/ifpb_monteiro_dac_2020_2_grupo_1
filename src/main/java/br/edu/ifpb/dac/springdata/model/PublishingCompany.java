package br.edu.ifpb.dac.springdata.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;

@Entity
public class PublishingCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank (message ="O nome da Editora é obrigatorio")
	private String namePublishingCompany;
	@NotBlank (message ="O nome da cidade é obrigatorio")
	private String publisherCity;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNamePublishingCompany() {
		return namePublishingCompany;
	}

	public void setNamePublishingCompany(String namePublishingCompany) {
		this.namePublishingCompany = namePublishingCompany;
	}

	public String getPublisherCity() {
		return publisherCity;
	}

	public void setPublisherCity(String publisherCity) {
		this.publisherCity = publisherCity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		PublishingCompany other = (PublishingCompany) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
}
