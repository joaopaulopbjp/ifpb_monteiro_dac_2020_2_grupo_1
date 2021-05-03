package br.edu.ifpb.dac.springdata.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.edu.ifpb.dac.springdata.model.Book;
import br.edu.ifpb.dac.springdata.model.Carrinho;
import br.edu.ifpb.dac.springdata.model.Historico;
import br.edu.ifpb.dac.springdata.model.ItemPedido;
import br.edu.ifpb.dac.springdata.model.Pedido;
import br.edu.ifpb.dac.springdata.model.User;
import br.edu.ifpb.dac.springdata.service.BookService;
import br.edu.ifpb.dac.springdata.service.CarrinhoService;

import br.edu.ifpb.dac.springdata.service.UserService;
import dto.CorreioDTO;
import restCliente.ClienteRest;



@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private BookService crudBook;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CarrinhoService crudCarrinho;
	
//	@Autowired
//	private HistoricoService crudHistorico;
	
	
	
	@GetMapping()
	public ModelAndView cart() {
		ModelAndView mv = new ModelAndView("cart");
		
		
		return mv;
	}
	
	
	
	
	@GetMapping("livro/{id}")
	public ModelAndView venda(@PathVariable("id") long id) throws Exception{
		ModelAndView mv = new ModelAndView("/project/sale/sale");
		Book book = crudBook.findById(id);
		
		if(book != null){
			mv.addObject("livro",book);
		}else{
			mv.addObject("livro",null);
		}
	
		return mv;
	}
	
	@GetMapping("/add/carrinho/{id}")
	public String addCarinho(@PathVariable("id") long id,HttpSession session) throws Exception{
		
		User usuario = usuarioLogado(session);
		
	    ItemPedido itemPedido = new ItemPedido();
	    itemPedido.setBook(crudBook.findById(id));  
	   	
	   
	    if(usuario.getCarrinho() == null){
	    	Carrinho carrinho = new Carrinho();
	    	carrinho.setPedido(new Pedido());
	    	carrinho.getPedido().setItemPedidos(new ArrayList<>());
	    	crudCarrinho.create(carrinho);
	    	usuario.setCarrinho(carrinho);
	    }
	    usuario.getCarrinho().getPedido().getItemPedidos().add(itemPedido);
	    usuario.getCarrinho().setQuantItens(usuario.getCarrinho().getQuantItens()+1);
	    userService.save(usuario);
	    
        int quantidade = usuario.getCarrinho().getQuantItens();
	    session.setAttribute("quantidade",quantidade);
	    session.setAttribute("usuarioLogado",usuario);
		return "redirect:/vendas/carrinho";
	}
	
	@GetMapping("/carrinho")
	public ModelAndView carrinho(HttpSession session) throws Exception{
		User usuario = usuarioLogado(session);
		ModelAndView mv = new ModelAndView("project/sale/card");  //********** lembrete SALE******************
		mv.addObject("itemPedidos",usuario.getCarrinho().getPedido().getItemPedidos());
		return mv;
	}
	
	@GetMapping("/delete/item/carrinho/{id}")
	public String deleteItemCarrinho(@PathVariable("id") long id, HttpSession session) throws Exception{
		
		User usuario  = usuarioLogado(session);
	
		for(int i = 0; i < usuario.getCarrinho().getPedido().getItemPedidos().size();i++){
			
			if(id == usuario.getCarrinho().getPedido().getItemPedidos().get(i).getId() ){
				
				usuario.getCarrinho().getPedido().getItemPedidos().remove(i);
				usuario.getCarrinho().setQuantItens(usuario.getCarrinho().getQuantItens() - 1);
				userService.save(usuario);
				session.setAttribute("usuarioLogado",usuario);
				int quantidade = usuario.getCarrinho().getQuantItens();
				session.setAttribute("quantidade",quantidade);
			}
		}
		return "redirect:/vendas/carrinho";
	}
	
	@GetMapping("/fecha/carrinho")
	public String fecharCompra(HttpSession session) throws Exception{
		
		User usuario = usuarioLogado(session);
		
		usuario.getPedidos().add(usuario.getCarrinho().getPedido());
		Historico historico;
		
		if(usuario.getHistorico() == null){
		  usuario.setHistorico(new ArrayList<>());
		}
		
		for(int i = 0; i < usuario.getCarrinho().getPedido().getItemPedidos().size();i++){
			
			historico = new Historico();
			historico.setTitulo(usuario.getCarrinho().getPedido().getItemPedidos().get(i).getBook().getTitle());
			historico.setDataHora(new Date());
			usuario.getHistorico().add(historico);
		}
		
		usuario.setCarrinho(null);
		userService.save(usuario);
		int quantidade = 0;
		session.setAttribute("quantidade",quantidade);
		 
		return "redirect:/vendas/homepage";
	}
	
//	@GetMapping("/historico")
//    public ModelAndView historico (HttpSession session) throws Exception{
//    	ModelAndView mv = new ModelAndView("/project/tables/historic");
//    	User usuarioLogado = usuarioLogado(session);
//    	User usuario = crudUsuario.findById(usuarioLogado.getId());
//    	mv.addObject("historicos",usuario.getHistorico());
//    	return mv;
//    }	
//	

	private User usuarioLogado(HttpSession session) throws Exception {
		User usuariologado = (User) session.getAttribute("usuarioLogado");
		User usuario  = userService.findById(usuariologado.getId());
		return usuario;
		
	}
	
	//realizar teste
	@GetMapping("/calc/frete")
	public String calcFrete(){
		
		CorreioDTO correio = new CorreioDTO();
		correio.setIndentificador(1);
		correio.setCep_origem("80230-110");
		correio.setCep_destino("83606-594");
		correio.setFormato(1);
		correio.setPeso("3,75");
		correio.setComprimento(25);
		correio.setAltura(40);
		correio.setLargura(11);
		correio.setMao_propria("S");
		correio.setAviso_recebimento("S");
		correio.setValor_declarado("101,00");
		String[] arrayStrings = new String[1];   
		arrayStrings[0] = "04162"; 
		correio.setServicos(arrayStrings);
		
		ClienteRest.requestCorreios(correio);
		return "/teste";
	}
	
	
}
