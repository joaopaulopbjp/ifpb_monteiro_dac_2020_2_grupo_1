package br.edu.ifpb.dac.springdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Book")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	
	private String email;
	
}
