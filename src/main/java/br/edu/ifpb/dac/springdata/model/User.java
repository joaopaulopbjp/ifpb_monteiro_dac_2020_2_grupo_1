package br.edu.ifpb.dac.springdata.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;






 /**
 *  classe  responsável pelas regras de negócios de usuarios 
 * 
 * * @author: Gabriel Oliveira && Alisson
 */
 
 

/**
 *  classe  responsável pelas regras de negócios de usuarios 
 * @author: Gabriel Oliveira
 */
@Entity
@Table(name = "users")
public class User {//implements UserDetails, Serializable{

	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;

	private String username;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	private String email;

	private String passwordUser;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( 
			name = "usuarios_roles", 
			joinColumns = @JoinColumn(
					name = "usuario_id", referencedColumnName = "user_id"), 
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id")) 
	private List<Role> roles;
	
	/**
	 * Um usuário para muitos pedidos
	 */
	@OneToMany(cascade = CascadeType.ALL)
	private List<Pedido> pedidos;

	/**
	 * Um usuário para um carrinho
	 */
	@OneToOne
	private Carrinho carrinho;
	
	/**
	 * Um usuário para um carrinho
	 */

	@OneToMany (cascade = CascadeType.ALL)
	private List<Historico> historico;
	
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public List<Historico> getHistorico() {
		return historico;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void setHistorico(List<Historico> historico) {
		this.historico = historico;
	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		List<GrantedAuthority> permissoes = new ArrayList<>();
//
//		if(roles.size()> 0) {
//			for (Role r : roles) {
//				permissoes.add(new SimpleGrantedAuthority(r.getNomeRole()));
//			} 
//			
//		}else {
//			permissoes.add(new SimpleGrantedAuthority("ROLE_USER"));
//		}
//		
//		return permissoes;
//
//	}
//
//	@Override
//	public String getPassword() {
//
//		// TODO Auto-generated method stub
//		return this.passwordUser;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}

//}
	
}
