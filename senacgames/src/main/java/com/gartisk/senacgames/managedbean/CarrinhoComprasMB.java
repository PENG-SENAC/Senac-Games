package com.gartisk.senacgames.managedbean;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.gartisk.senacgames.modelo.Produto;
import com.gartisk.senagames.service.ItemPedido;


@ManagedBean(name="carrinhoComprasMB")
@SessionScoped
public class CarrinhoComprasMB implements Serializable{
	
	private static final long serialVersionUID = 6965570300812100928L;
	
	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	private Long indice = 0L;
	
	private boolean compraFinalizada = false;
	private Integer codigoCompras; 
			
	@PostConstruct
	private void inicializa(){
		
	}
	
	public void insereItem(Produto produto){
		ItemPedido item = new ItemPedido();
		item.setId(indice);
		item.setProduto(produto);
		itens.add(item);
		indice++;
	}
	
	public void removeItem(ItemPedido itemPedido){
		itens.remove( itemPedido );
	}
	
	public void finalizarCompras(){
		this.compraFinalizada = true;
		this.codigoCompras = ((int) Math.floor( Math.random()*10000 )); 
	}
	
	public void comprarNovamente(){
		this.itens = new ArrayList<ItemPedido>();
		this.indice = 0L;
		
		this.compraFinalizada = false;
		this.codigoCompras = null; 
		
	}
	
	public List<ItemPedido> getItens() {
		return itens;
	}
	
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	public int getQuantidadeDeItensTotal(){
		int quantidadeDeItens = 0;
		for (ItemPedido itemPedido : itens) {
			quantidadeDeItens += itemPedido.getQuantidade();
		}
		
		return quantidadeDeItens;
	}
	
	public Double getValorItensTotal(){
		Double valorTotal = 0d;
		for (ItemPedido itemPedido : itens) {
			valorTotal += itemPedido.getValorTotal();
		}
		
		return valorTotal;
	}

	public boolean isCompraFinalizada() {
		return compraFinalizada;
	}

	public void setCompraFinalizada(boolean compraFinalizada) {
		this.compraFinalizada = compraFinalizada;
	}
	
	
}
