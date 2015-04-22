package com.gartisk.senacgames.modelo;

import java.io.Serializable;

public class Game extends Produto implements Serializable{
	private static final long serialVersionUID = -1121122521463508889L;
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
