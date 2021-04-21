package br.edu.ifpb.dac.springdata.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
public class ItemPedido {
	
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


}
