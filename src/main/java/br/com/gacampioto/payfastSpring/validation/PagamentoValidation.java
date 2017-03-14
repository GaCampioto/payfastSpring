package br.com.gacampioto.payfastSpring.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.gacampioto.payfastSpring.models.Pagamento;

public class PagamentoValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Pagamento.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "formaPagamento", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "moeda", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "status", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "descricao", "field.required");
	}

}
