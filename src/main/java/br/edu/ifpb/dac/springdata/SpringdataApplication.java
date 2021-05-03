package br.edu.ifpb.dac.springdata;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


//@ComponentScan(basePackages = {"br.edu.ifpb.dac.springdata"})
/**
 * starta a aplicação
 * @author Arkan
 *
 */

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class SpringdataApplication {
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		SpringApplication.run(SpringdataApplication.class, args);	
	
	}

}
