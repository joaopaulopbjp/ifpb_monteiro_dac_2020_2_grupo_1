package br.edu.ifpb.dac.springdata;


import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.edu.ifpb.dac.springdata.controller.AuthorController;
import br.edu.ifpb.dac.springdata.controller.BookController;
import br.edu.ifpb.dac.springdata.controller.StockController;
import br.edu.ifpb.dac.springdata.controller.UserController;
import br.edu.ifpb.dac.springdata.model.Author;
import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.model.User;

/**
 * Classe main de execução 
 * @author: Gabriel Oliveira && Alisson
 */
@SpringBootApplication
@ComponentScan(basePackages = {"br.edu.ifpb.dac.springdata"})
public class SpringdataApplication implements CommandLineRunner {

	private final BookController bookController;
	
	private final AuthorController authorController;
	
	private final UserController userController;
	
	private final StockController stockController;
	
	
	
	public SpringdataApplication(BookController bookController,AuthorController authorController,UserController userController,StockController stockController) {
		this.bookController = bookController;
		this.authorController = authorController;
		this.userController = userController;
		this.stockController = stockController;
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		SpringApplication.run(SpringdataApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//PRE CADASTRO DE AUTORES
		Author author01 = new Author();
		author01.setName("Bernard Cornwell");
		authorController.save(author01);
		
		Author author02 = new Author();
		author02.setName("C.S. Lewis");
		authorController.save(author02);
		
		Author author03 = new Author();
		author03.setName("J. K. Rowling");
		authorController.save(author03);
		
		//PRE CADASTRO DE LIVROS
		Book book01 = new Book();
		book01.setTitle("As Crônicas de Nárnia");
		book01.setPrice(40.50f);
		book01.setDescription("Tudo começa em uma brincadeira de esconde-esconde, quando Lúcia, a mais nova, descobre um guarda-roupa que reserva uma passagem secreta para um país mágico chamado Nárnia.");
		book01.setIllustrations(true);
		book01.setIsbn("978-8578270698");
		book01.setNbOfPage(752);
		bookController.saveAuthor(2l, book01);
		bookController.save(book01);
		System.out.println(book01.getAuthors().get(0).getName());
		
		
		Book book02 = new Book();
		book02.setTitle("O rei do inverno (Vol. 1 As Crônicas de Artur)");
		book02.setPrice(32.89f);
		book02.setDescription("Honra, dever e paixão em uma poderosa aventura. O primeiro volume da trilogia As crônicas de Artur.");
		book02.setIllustrations(false);
		book02.setIsbn("978-8501061140");
		book02.setNbOfPage(546);
		bookController.saveAuthor(1l, book02);
		bookController.save(book02);
		
		Book book03 = new Book();
		book03.setTitle("O inimigo de Deus (Vol. 2 As Crônicas de Artur)");
		book03.setPrice(30.28f);
		book03.setDescription("O inimigo de Deus é o segundo volume da trilogia do escritor inglês Bernard Cornwell sobre o lendário guerreiro Artur");
		book03.setIllustrations(false);
		book03.setIsbn("978-8501061188");
		book03.setNbOfPage(518);
		bookController.saveAuthor(1l, book03);
		bookController.save(book03);
		
		Book book04 = new Book();
		book04.setTitle("Harry Potter e a pedra filosofal");
		book04.setPrice(34.90f);
		book04.setDescription("Harry Potter vive com os tios Dursley, onde é mal tratado até completar seus 11 anos. É com essa idade que o jovem bruxo começa a receber cartas da escola de Hogwarts.");
		book04.setIllustrations(false);
		book04.setIsbn("978-8532531766");
		book04.setNbOfPage(256);
		bookController.saveAuthor(2l, book04);
		bookController.save(book04);
		
		
		boolean con = true;
		Scanner input = new Scanner(System.in);
		
		//APLICAÇÃO PARA TESTAR FUNCIONALIDADES DO SPRINGDATA
		while(con) {
			
			System.out.println("1 - Cadastrar livro"
					+ "\n2 - Exibir Livros"
					+ "\n3 - Editar livro"
					+ "\n4 - Excluir Livro"
					+ "\n5 - Cadastrar Livro no Estoque"
					+ "\n6 - Cadastrar Usuario"
					+ "\n7 - Buscar Usuario Por Email"
					+ "\n8 - Cadastrar autor"
					+ "\n9 - Editar autor"
					+ "\n10 - Cadastrar Centro de distribuição"
					+ "\n11 - Cadastrar Prateleira em um Centro de Distribuição"
					+ "\n12 - Adicionar Livro a Pedido");
			int chosenOption = Integer.parseInt(input.nextLine());
			
			if(chosenOption == 1) {
				
				//MODO CADASTRAR LIVRO
				
				System.out.println("Title: ");
				String title = input.nextLine();
				
				System.out.println("Descrição: ");
				String description = input.nextLine();
				
				System.out.println("Número de Páginas: ");
				int NbOfPages = Integer.parseInt(input.nextLine());
			
				System.out.println("Isbn: ");
				String isbn = input.nextLine();
				
				System.out.println("Preço: ");
				Float price =Float.parseFloat(input.nextLine());
					
				System.out.println("Tem Ilustrações? (S) sim (N) não: ");
				String illustrationsOp = input.nextLine();
				Boolean illustrations = false;
				
				Book newBook = new Book();					
				ArrayList<Long> authorsId = new ArrayList();
				
				while(true) {
					
					try {	
					System.out.println("Id do Author: ");
					authorsId.add(Long.parseLong(input.nextLine()));
					
					System.out.println("Possui Mais Autores? (S) Sim (N) Não:");
					String AuthorOp = input.nextLine();
					
					if(AuthorOp .equalsIgnoreCase("S")) {
						
					}
					else {					
						bookController.saveAuthor(authorsId.get(1), newBook);
						break;
					}					
					}catch (Exception e) {
						System.out.println("Não Possui Autores");
					}			
				}
		
				if(illustrationsOp.equalsIgnoreCase("S")) { illustrations = true; }
				else if (illustrationsOp.equalsIgnoreCase("N")) { illustrations = false; }
				
				newBook.setTitle(title);
				newBook.setPrice(price);
				newBook.setDescription(description);
				newBook.setIllustrations(illustrations);
				newBook.setIsbn(isbn);
				newBook.setNbOfPage(NbOfPages);
				bookController.save(newBook);
				
				System.out.println("Livro Cadastrado Com Sucesso!!");
				
			}
			else if(chosenOption == 2) {
				
				
			}
			else if(chosenOption == 3) {
				
				System.out.println("Id do livro a ser editado: ");
				Book updateBook = bookController.findById(Long.parseLong(input.nextLine()));
				
				System.out.println("Atual: " + updateBook.getTitle());
				System.out.println("Novo Title: ");
				String title = input.nextLine();
				
				System.out.println("Atual: " + updateBook.getDescription());
				System.out.println("Descrição: ");
				String description = input.nextLine();
				
				System.out.println("Atual: " + updateBook.getNbOfPage());
				System.out.println("Número de Páginas: ");
				int NbOfPages = Integer.parseInt(input.nextLine());
			
				System.out.println("Atual: " + updateBook.getIsbn());
				System.out.println("Isbn: ");
				String isbn = input.nextLine();
				
				System.out.println("Atual: " + updateBook.getPrice());
				System.out.println("Preço: ");
				Float price =Float.parseFloat(input.nextLine());
					
				System.out.println("Atual: " + updateBook.getIllustrations());
				System.out.println("Tem Ilustrações? (S) sim (N) não: ");
				String illustrationsOp = input.nextLine();
				Boolean illustrations = false;
				
			
				if(illustrationsOp.equalsIgnoreCase("S")) { illustrations = true; }
				else if (illustrationsOp.equalsIgnoreCase("N")) { illustrations = false; }
				
				updateBook.setTitle(title);
				updateBook.setPrice(price);
				updateBook.setDescription(description);
				updateBook.setIllustrations(illustrations);
				updateBook.setIsbn(isbn);
				updateBook.setNbOfPage(NbOfPages);
				
				bookController.save(updateBook);
			}
			else if(chosenOption == 4){
				//OPÇÃO PARA DELETAR UM LIVRO
				
				System.out.println("ID do livro a ser deletado: ");
				Long bookIdDelete = Long.parseLong(input.nextLine());
				
				bookController.deleteById(bookIdDelete);
				System.out.println("Livro Deletado");
				
			}
			else if(chosenOption == 5) {
				//MODO DE EXIBIÇÃO DOS LIVROS POR PAGINA
				
				//System.out.println("Escolha a pagina de 0 a : " + (bookService.countPage() - 1));
				//int pagOp = Integer.parseInt(input.nextLine());

				//List<Book> books = bookController.showBook(bookService.findAll(pagOp, 3));
				
				//for(int i = 0; i < books.size();i++) {
									
					//System.out.println("Nome: " + books.get(i).getTitle() +" Preço: "+ books.get(i).getPrice());
								
				//}
			}
			else if(chosenOption == 6) {
				
				//MODO PARA CADASTRAR USUARIO
				
				System.out.println("Nome do usuario: ");
				String name = input.nextLine();
				
				System.out.println("E-mail: ");
				String email = input.nextLine();
				
				System.out.println("Senha: ");
				String password = input.nextLine();
				
				System.out.println("UserName: ");
				String userName = input.nextLine();
				
				User newUser = new User();
				
				newUser.setName(name);
				newUser.setEmail(email);
				newUser.setUserName(userName);
				newUser.setPassword(password);
				
				userController.save(newUser);
				
				System.out.println("Cadastrado com secesso!");
			}
			else if(chosenOption == 7) {
				
				System.out.println("Email: ");
				String email = input.nextLine();
				
				User user = userController.FindByEmail(email);
		
				System.out.println("Username do Usuario: " + user.getName());
				
				
			}else if(chosenOption == 8) {
				
				//OPÇÃO PARA CADASTRAR UM AUTOR
				System.out.println("Nome do Author: ");
				String name = input.nextLine();
							
				Author newAuthor = new Author();
				
				newAuthor.setName(name);
				
				authorController.save(newAuthor);
				System.out.println("Author Salvo com Sucesso!!");
			}
			else if(chosenOption == 9) {
				
				
				
				
				
			}else if(chosenOption == 10) {
				
				
				
				
				
			}else if(chosenOption == 11) {
				
				
				
				
			}else if(chosenOption == 12) {
				
			}
			
		}
	}

}
