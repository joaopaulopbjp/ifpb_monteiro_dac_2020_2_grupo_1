package br.edu.ifpb.dac.springdata.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.springdata.model.Author;
import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.repository.AuthorRepository;
import br.edu.ifpb.dac.springdata.repository.BookRepository;
/**
 * 
 * @author: Gabriel Oliveira && Alisson
 */
@Service
public class BookService{

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	//METODO PARA SALVAR UM LIVRO
	public Book save(Book book) {

		return bookRepository.save(book);

	}
	
	//METODO PARA DELETAR UM LIVRO PELO ID DELE
	public void deleteById(Long id)throws Exception{
		Book book = bookRepository.findById(id).orElseThrow();
		
		bookRepository.delete(book);
	}
	
	//METODO PARA PEGAR UM LIVRO PELO ID DELE
	public Book findById(long id)throws Exception{

		return bookRepository.findById(id).orElseThrow();
	} 
	
	//METODO PARA ATUAIZAR INFORMAÇÕES DE UM LIVRO
	public Book update(Book book) throws Exception{

		Book updateBook = bookRepository.findById(book.getId()).orElseThrow();

		updateBook.setDescription(book.getDescription());
		updateBook.setIllustrations(book.getIllustrations());
		updateBook.setIsbn(book.getIsbn());
		updateBook.setNbOfPage(book.getNbOfPage());
		updateBook.setPrice(book.getPrice());
		updateBook.setTitle(book.getTitle());

		return save(updateBook);

	}

	//METODO SALVAR O AUTHOR DO LIVRO NA TABELA DO RELACIONAMENTO DELES
	public void saveAuthor(Long authorId,Book book) throws Exception{

		Author author = authorRepository.findById(authorId).orElseThrow();
		
		book.setAuthors(new ArrayList<>());

		book.getAuthors().add(author);
		
		bookRepository.save(book);

	}
	
	//METODO PARA RETORNA A QUANTIDADE DE PAGINAS DE LIVROS
	public int countPage() {
		
		Page<Book> page = bookRepository.findAll(PageRequest.of(0, 3));
		
		return page.getTotalPages();
	}
	
	//METODO PARA RETORNAR OS LIVROS DE FORMA PAGINADA PELO PREÇO
	public Page<Book> findAll(int page, int size){
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "price");
		return bookRepository.findAll(pageRequest);
	}

	//METODO PARA RETORNAR UMA LISTA DE LIVROS APARTIR DE UMA PAGE
	public List<Book> showBook(Page<Book> page){
		
		List<Book> books = new ArrayList();
		
		for(int i = 0; i < page.getNumberOfElements();i++) {
			
			books.add(page.getContent().get(i));
			
		}
		return books;
		
	}
	
    //	METODO PARA CONSULTAR OS 5 LIVROS MAIS BARATOS;
	public Page<Book> ListFiveBookByPrice(Pageable page){
		
		return bookRepository.findAll(page);
			
	}
	



}
