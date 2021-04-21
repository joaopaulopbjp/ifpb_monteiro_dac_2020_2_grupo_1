package br.edu.ifpb.dac.springdata.model;
/**
 * Classe contendo informaçoes do livro
 * @author: Gabriel Oliveira && Alisson
 */
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
*  classe  responsável pelas regras de negócios de Book 
* 
* * @author: Gabriel Oliveira && Alisson
*/

@Entity
@Table(name = "TB_Book")
public class Book {
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name = "title", length = 50, nullable = false)
	private String title;
	@Column(name = "price")
	private double price;
	@Column(name = "Description")
	private String description;
	@Column(name = "isbn",length = 50, nullable = false)
	private String isbn;
	@Column(name = "nbOfPage")
	private Integer nbOfPage;
	@Column(name = "illustrations")
	private Boolean illustrations;
	
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
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
	
	@ManyToMany
	@JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
	private List<Author> authors;
	
	
	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Book() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getNbOfPage() {
		return nbOfPage;
	}

	public void setNbOfPage(Integer nbOfPage) {
		this.nbOfPage = nbOfPage;
	}

	public Boolean getIllustrations() {
		return illustrations;
	}

	public void setIllustrations(Boolean illustrations) {
		this.illustrations = illustrations;
	}

//	@Override
//	public String toString() {
//		return "Livro [Livro=" + titulo + ", paginas =" + qtd_pg + ", preço=" + preco + "]";
//	}

	
	
	
}
