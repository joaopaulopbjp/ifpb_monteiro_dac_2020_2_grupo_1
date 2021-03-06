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
 * responsável por se comunicar com as camadas mais internas
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
		Book book = bookRepository.findById(id).orElseThrow(null);
		
		bookRepository.delete(book);
	}
	
	//METODO PARA PEGAR UM LIVRO PELO ID DELE
	public Book findById(long id)throws Exception{

		return bookRepository.findById(id).orElseThrow(null);
	} 
	
	//METODO PARA ATUALIZAR INFORMAÇÕES DE UM LIVRO
	public Book update(Book book) throws Exception{

		Book updateBook = bookRepository.findById(book.getId()).orElseThrow(null);

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

		Author author = authorRepository.findById(authorId).orElseThrow(null);
		
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
	public Page<Book> findAllPage(int page, int size){
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
	// TAmbem serve para qualquer tipo de consulta relacionado a livros
	public List<Book> ListFiveBookByPrice(){
		PageRequest pageRequest = PageRequest.of(0, 5, Sort.Direction.ASC, "price");
		List<Book> list = bookRepository.findAll(pageRequest).getContent();
		return list;
			
	}
	
	public List<Book> getBooks(int pages, int elements){
		Page<Book> page = bookRepository.findAll(PageRequest.of(pages, elements, Sort.by(Sort.Direction.DESC,"title")));

		List<Book> list = page.getContent();
		
		return list;
	}
	
	public List<Book> findByTitleContaining(String bookName){
		
		return bookRepository.findByTitleContaining(bookName);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
}
