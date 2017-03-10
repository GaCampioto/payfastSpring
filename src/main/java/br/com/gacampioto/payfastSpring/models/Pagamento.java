package br.com.gacampioto.payfastSpring.models;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Entity
public class Pagamento {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="forma_de_pagamento")
	private String formaPagamento;
	private double valor;
	private String moeda;
	private String status;
	private String descricao;
	private Date data;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
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
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", formaPagamento=" + formaPagamento + ", valor=" + valor + ", moeda=" + moeda
				+ ", status=" + status + ", descricao=" + descricao + ", data=" + data + "]";
	}
}
