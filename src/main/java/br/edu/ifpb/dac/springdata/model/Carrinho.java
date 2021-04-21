package br.edu.ifpb.dac.springdata.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



/**
 * @author Gabriel
 * Classe responsavel por habilita um carrinho de compras
 * para o usuário comprar os livros que deseja.
 */
@Entity
public class Carrinho {

	//um carrinho para um pedido
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private long id;
	
		@OneToOne(cascade = CascadeType.ALL)
		private Pedido pedido;
		
		private int quantItens;
			
		public int getQuantItens() {
			return quantItens;
		}
		public void setQuantItens(int quantItens) {
			this.quantItens = quantItens;
		}
		public Pedido getPedido() {
			return pedido;
		}
		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}
		
	}

