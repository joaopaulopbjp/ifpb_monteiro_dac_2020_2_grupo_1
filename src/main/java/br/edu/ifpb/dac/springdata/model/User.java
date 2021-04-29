package br.edu.ifpb.dac.springdata.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




/**
 * Classe resposavel por criar o usuários, para que o spring security possa salvar esse
 *         usuário com as devidas autenticações
 * @author: Gabriel Oliveira
 */
@Entity
@Table(name = "users")
public class User implements UserDetails, Serializable{

	//private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long id;
	
	@NotBlank(message = "O nome de login é obrigatório")
	@Size(min = 4, message = "USERNAME tem que ter pelo menos 4 letras")
	@Column(unique = true)
	private String username;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@Email(message="verifique o email corretamente com @")
	private String email;
	
	/**
	 * Status ativo ou inativo
	 */
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@NotNull
	@NotEmpty(message = "Password não pode ser vazio.")
	@Size(min = 6, message = "Password deve ser no mínimo 6 caracter.")
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
	
	@OneToMany(mappedBy = "users", cascade = CascadeType.MERGE)
	private List<Endereco> enderecos;
	
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


	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> permissoes = new ArrayList<>();

		if(roles.size()> 0) {
			for (Role r : roles) {
				permissoes.add(new SimpleGrantedAuthority(r.getNomeRole()));
			} 
			
		}else {
			permissoes.add(new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		return permissoes;

	}


	public String getPassword() {

		// TODO Auto-generated method stub
		return this.passwordUser;
	}


	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	
}
