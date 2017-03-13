package br.com.gacampioto.payfastSpring.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gacampioto.payfastSpring.daos.PagamentoDAO;
import br.com.gacampioto.payfastSpring.models.Pagamento;

@Controller
@RequestMapping("pagamentos")
public class PagamentosController {
	
	@Autowired
	PagamentoDAO pagamentoDAO;
	
	@RequestMapping("/formCadastro")
	public String getForm(){
		return "pagamentos/formCadastro";
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Pagamento pagamento, RedirectAttributes redirectAttributes){
		pagamento.setData(Date.valueOf(LocalDate.now()));
		pagamentoDAO.gravar(pagamento);
		redirectAttributes.addFlashAttribute("sucesso", "Pagamento cadastrado com sucesso!");
		
		return new ModelAndView("redirect:pagamentos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listarPagamento(){
		List<Pagamento> listaPagamentos = pagamentoDAO.getPagamentos();
		System.out.println(listaPagamentos);
		ModelAndView modelAndView = new ModelAndView("pagamentos/listaPagamentos");
		modelAndView.addObject("pagamentos", listaPagamentos);
		return modelAndView;
	}
}
