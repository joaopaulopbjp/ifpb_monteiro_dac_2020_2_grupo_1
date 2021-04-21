package restCliente;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import dto.CorreioDTO;


@Component
public class ClienteRest {
	
	public static void requestCorreios(CorreioDTO correio){
	    final String uri = "https://www.sgpweb.com.br/novo/api/consulta-precos-prazos?chave_integracao=90c067ea2d608e044af5d34790f82365";
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.postForObject( uri,correio,String.class);
	    System.out.println(result);
	}
}
