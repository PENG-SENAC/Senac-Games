package com.gartisk.senacgames.modelo;

import java.io.Serializable;

public abstract class Produto extends Entidade implements Serializable{

	private static final long serialVersionUID = -3261741078957197967L;
	private String nome;
	private String descricao;
	private FaixaEtaria faixaEtaria;
	private Double preco;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public FaixaEtaria getFaixaEtaria() {
		return faixaEtaria;
	}

	public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
