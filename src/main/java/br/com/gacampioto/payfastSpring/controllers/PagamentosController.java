package br.com.gacampioto.payfastSpring.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gacampioto.payfastSpring.daos.PagamentoDAO;
import br.com.gacampioto.payfastSpring.infra.FileSaver;
import br.com.gacampioto.payfastSpring.models.Pagamento;
import br.com.gacampioto.payfastSpring.validation.PagamentoValidation;

@Controller
@RequestMapping("/pagamentos")
public class PagamentosController {
	
	@Autowired
	PagamentoDAO pagamentoDAO;
	
	@Autowired
	FileSaver fileSaver;
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new PagamentoValidation());
	}
	
	@RequestMapping("/formCadastro")
	public ModelAndView getForm(Pagamento pagamento){
		return new ModelAndView("pagamentos/formCadastro");
	}

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(MultipartFile comprovante, @Valid Pagamento pagamento, BindingResult result, RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return getForm(pagamento);
		}
		String comprovantePath = fileSaver.saveToServer(comprovante, "comprovantes");
		pagamento.setComprovantePath(comprovantePath);
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
