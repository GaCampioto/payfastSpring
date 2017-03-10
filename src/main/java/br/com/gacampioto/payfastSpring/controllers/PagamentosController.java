package br.com.gacampioto.payfastSpring.controllers;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gacampioto.payfastSpring.daos.PagamentoDAO;
import br.com.gacampioto.payfastSpring.models.Pagamento;

@Controller
public class PagamentosController {
	
	@Autowired
	PagamentoDAO pagamentoDAO;
	
	@RequestMapping("pagamentos/formCadastro")
	public String getForm(){
		return "pagamentos/formCadastro";
	}

	@RequestMapping("pagamentos")
	public String salvar(Pagamento pagamento){
		pagamento.setData(Date.valueOf(LocalDate.now()));
		pagamentoDAO.gravar(pagamento);
		return "pagamentos/success";
	}
}
