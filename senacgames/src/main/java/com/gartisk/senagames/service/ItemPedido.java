package com.gartisk.senagames.service;

import java.io.Serializable;

import com.gartisk.senacgames.modelo.Produto;

public class ItemPedido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private Produto produto; 
	private int quantidade = 1;
	private double valorTotal;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.valorTotal = produto.getPreco()*quantidade;
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.valorTotal = produto.getPreco()*quantidade;
		this.quantidade = quantidade;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", produto=" + produto
				+ ", quantidade=" + quantidade + ", valorTotal=" + valorTotal
				+ "]";
	}
	
}
