package br.com.gacampioto.payfastSpring.controllers;

import java.util.concurrent.Callable;

import org.hibernate.internal.jaxb.mapping.hbm.JaxbMapElement.JaxbCompositeMapKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gacampioto.payfastSpring.daos.PagamentoDAO;
import br.com.gacampioto.payfastSpring.models.Comprovante;
import br.com.gacampioto.payfastSpring.models.ComprovanteItem;
import br.com.gacampioto.payfastSpring.models.DadosPagamento;
import br.com.gacampioto.payfastSpring.models.Pagamento;

@Controller
@RequestMapping("/comprovante")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class ComprovanteController {
	
	@Autowired
	PagamentoDAO pagamentoDAO;
	
	@Autowired
	Comprovante comprovante;
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addComprovante (Integer pagamentoId){
		Pagamento pagamento = pagamentoDAO.find(pagamentoId);
		ComprovanteItem comprovanteItem = createComprovanteItem(pagamento);
		comprovante.add(comprovanteItem);
		ModelAndView modelAndView = new ModelAndView("redirect:pagamentos");
		return modelAndView;
	}
	
	@RequestMapping(value="/gerarComprovante", method=RequestMethod.POST)
	public Callable<ModelAndView> gerarComprovante(RedirectAttributes attributes){
		return () -> {
			try {
				String uri = "http://book-payment.herokuapp.com/payment";	
				String response = restTemplate.postForObject(uri, new DadosPagamento(comprovante.getTotal()), String.class);
				attributes.addFlashAttribute("mensagem", response);
				System.out.println(response);
				comprovante.limparItens();
				return new ModelAndView("redirect:/comprovante");
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				attributes.addFlashAttribute("mensagem", "Valor maior que o permitido");
				return new ModelAndView("redirect:/comprovante");
			}
		};
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getComprovante(){
		return new ModelAndView("comprovantes/comprovante");
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(int pagamentoId){
		Pagamento pagamento = new Pagamento();
		pagamento.setId(pagamentoId);
		ComprovanteItem comprovanteItem = new ComprovanteItem();
		comprovanteItem.setPagamento(pagamento);
		comprovante.remove(comprovanteItem);
		return new ModelAndView("redirect:/comprovante");
	}
	
	private ComprovanteItem createComprovanteItem(Pagamento pagamento){
		ComprovanteItem comprovanteItem = new ComprovanteItem();
		comprovanteItem.setPagamento(pagamento);
		return comprovanteItem;
	}
}
