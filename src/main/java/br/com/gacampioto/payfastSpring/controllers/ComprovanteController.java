package br.com.gacampioto.payfastSpring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import br.com.gacampioto.payfastSpring.daos.PagamentoDAO;
import br.com.gacampioto.payfastSpring.models.Comprovante;
import br.com.gacampioto.payfastSpring.models.ComprovanteItem;
import br.com.gacampioto.payfastSpring.models.Pagamento;

@Controller
@RequestMapping("/comprovante")
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
public class ComprovanteController {
	
	@Autowired
	PagamentoDAO pagamentoDAO;
	
	@Autowired
	Comprovante comprovante;
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView addComprovante (Integer pagamentoId){
		Pagamento pagamento = pagamentoDAO.find(pagamentoId);
		ComprovanteItem comprovanteItem = createComprovanteItem(pagamento);
		comprovante.add(comprovanteItem);
		ModelAndView modelAndView = new ModelAndView("redirect:pagamentos");
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getComprovante(){
		return new ModelAndView("comprovantes/comprovante");
	}
	
	private ComprovanteItem createComprovanteItem(Pagamento pagamento){
		ComprovanteItem comprovanteItem = new ComprovanteItem();
		comprovanteItem.setPagamento(pagamento);
		return comprovanteItem;
	}
}
