package br.edu.ifpb.dac.springdata.model;

import java.util.List;

import javax.persistence.CascadeType;

/**
 * Ordem
 * @author: Gabriel Oliveira && Alisson
 */

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
*  classe  responsável pelas regras de negócios de Order
* 
* * @author: Gabriel Oliveira && Alisson
*/
@Entity
@Table(name = "order_tb")
public class Order {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "order_id")
	private Long id;
	
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	@OneToOne
	private User user;
	
	@OneToMany(cascade = CascadeType.MERGE)
	//@JoinColumn(name = "book_order")
	private List<Book> books;
	
	private double totalValue;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}


}
