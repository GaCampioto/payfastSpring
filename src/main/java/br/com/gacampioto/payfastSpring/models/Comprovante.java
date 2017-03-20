package br.com.gacampioto.payfastSpring.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class Comprovante implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<ComprovanteItem> itens = new ArrayList<>();
	
	public void add(ComprovanteItem comprovanteItem){
		itens.add(comprovanteItem);
	}
	
	public Double getTotal(){
		return	itens.stream()
				.map(ComprovanteItem::getPagamento)
				.mapToDouble(Pagamento::getValor)
				.sum();
	}
	
	public int getQuantidade(){
		return itens.size();
	}
	
	public List<ComprovanteItem> getItens() {
		return itens;
	}

	public void setItens(List<ComprovanteItem> itens) {
		this.itens = itens;
	}
}
