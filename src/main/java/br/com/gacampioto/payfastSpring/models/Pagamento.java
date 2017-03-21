package br.com.gacampioto.payfastSpring.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pagamento {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="forma_de_pagamento")
	private String forma_de_pagamento;
	private double valor;
	private String moeda;
	private String status;
	private String descricao;
	private Calendar data;
	private String comprovantePath;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFormaPagamento() {
		return forma_de_pagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.forma_de_pagamento = formaPagamento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getMoeda() {
		return moeda;
	}
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public String getComprovantePath() {
		return comprovantePath;
	}
	public void setComprovantePath(String comprovantePath) {
		this.comprovantePath = comprovantePath;
	}
	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", formaPagamento=" + forma_de_pagamento + ", valor=" + valor + ", moeda=" + moeda
				+ ", status=" + status + ", descricao=" + descricao + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagamento other = (Pagamento) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
