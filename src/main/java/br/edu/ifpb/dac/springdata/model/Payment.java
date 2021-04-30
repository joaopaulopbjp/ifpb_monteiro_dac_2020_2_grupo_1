package br.edu.ifpb.dac.springdata.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "TB_Paymente")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private BigDecimal value;
	
	private String tipo;
	

	public Payment(BigDecimal value, String tipo) {
		this.value = value;
		this.tipo = tipo;
	}
	
	public Payment() {
		
	}
	
	public BigDecimal getValue() {
		return value;
	}

}
