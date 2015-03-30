package com.gartisk.senacgames.modelo;

import java.io.Serializable;

public abstract class Produto implements Serializable{

	private static final long serialVersionUID = -3261741078957197967L;
	private String nome;
	private String descricao;
	private FaixaEtaria faixaEtaria;
	
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
	
}
