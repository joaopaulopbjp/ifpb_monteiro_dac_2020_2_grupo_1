package br.edu.ifpb.dac.springdata.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Essa classe serve para configurar o Spring Security
 * Classe responsavel por da todas as permições do usuario e chamada da pagina de login
 *
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, "/book/newBook").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/book/newBook").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET, "/book").hasRole("ADMIN")
		.antMatchers(HttpMethod.GET,"/book/info/{id}").permitAll()
		.antMatchers(HttpMethod.GET,"/book/list").permitAll()
		.antMatchers(HttpMethod.GET,"/book/info/cover/{imgPath}").permitAll()
		.antMatchers(HttpMethod.POST,"/signUp").permitAll()
		.antMatchers(HttpMethod.GET,"/signUp").permitAll()
		.antMatchers(HttpMethod.GET,"/").permitAll()
		.anyRequest().authenticated().and().formLogin().loginPage("/singIn").permitAll().and()
		.logout().logoutSuccessUrl("/singIn?logout").permitAll();
		
	}
	
	/**
	 * Metodo de autenticação do usuario recebendo pelo repositorio ImplementsUserDetailsService 
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder, 
			PasswordEncoder passwordEncoder, 
			ImplementsUserDetailsService userDetails) throws Exception {
		builder
			.userDetailsService(userDetails)
			.passwordEncoder(passwordEncoder);
	} 
	
	
	/**
	 * Método que habilita as pastas estaticas para o spring security não interropelas
	 */
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/images/**","/js/**" ,"/css/**","/templates/**","/drivers/**");
	}
}
