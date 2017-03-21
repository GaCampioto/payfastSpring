package br.com.gacampioto.payfastSpring.models;

public class DadosPagamento {
	private double value;
	
	public DadosPagamento (double value){
		this.setValue(value);
	}
	
	public DadosPagamento(){}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
