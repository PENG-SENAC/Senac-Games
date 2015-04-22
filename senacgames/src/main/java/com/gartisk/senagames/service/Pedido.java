package com.gartisk.senagames.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gartisk.senacgames.modelo.Cliente;
import com.gartisk.senacgames.modelo.Produto;

public class Pedido {
	private Long id;
	private Date data; 
	private Cliente cliente; 
	private List<ItemPedido> itens = new ArrayList<ItemPedido>(); 
	private double valorTotal;
	
	public void adicionaItem(Produto produto, int quantidadeItem) {	
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setProduto(produto);
		itemPedido.setQuantidade(quantidadeItem);		
		int posicaoNaLista = itens.indexOf(itemPedido);
		ItemPedido itemJaAdicionado;
		
		if (posicaoNaLista>=0) {
			itemJaAdicionado = itens.get(posicaoNaLista);
			itemJaAdicionado.setQuantidade(itemJaAdicionado.getQuantidade()+itemPedido.getQuantidade());
		} else {
			itens.add(itemPedido);
			itemJaAdicionado = itemPedido;
		}
		
		itemJaAdicionado.setValorTotal(itemJaAdicionado.getQuantidade() * itemJaAdicionado.getProduto().getPreco());
		
	}; 
	
	public void removeItem(Produto produto) {
		ItemPedido item = new ItemPedido();
		item.setProduto(produto);
		itens.remove(item);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	public double getValorTotal() {
		valorTotal = 0.0;
		for (ItemPedido item : this.itens)
			valorTotal += item.getValorTotal();
		return valorTotal;
	}
	public int qtdItens()
	{
		return this.itens.size();
	}	
	public void limpar()
	{
		this.itens.clear();
	}

}
