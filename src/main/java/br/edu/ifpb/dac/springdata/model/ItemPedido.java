package br.edu.ifpb.dac.springdata.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Item_pedido")
public class ItemPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	private int quantidade;
	private double valorTotal;
	
	//um item pedido para um livro
	
	@OneToOne(cascade = CascadeType.ALL)
	private Book book;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public Book getBook() {
		return book;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	@Override
	public String toString() {
		return book.getTitle();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
