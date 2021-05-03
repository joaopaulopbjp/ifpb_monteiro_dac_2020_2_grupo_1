//package br.edu.ifpb.dac.springdata.security;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import br.edu.ifpb.dac.springdata.model.Status;
//import br.edu.ifpb.dac.springdata.model.User;
//import br.edu.ifpb.dac.springdata.service.UserService;
//
//@Configuration
//public class SecurityConfig {
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//
//		return new BCryptPasswordEncoder();
//	}
//
//	public static void main(String[] args) {
//
//		System.out.println(new BCryptPasswordEncoder().encode("admin"));
//	}
//}
