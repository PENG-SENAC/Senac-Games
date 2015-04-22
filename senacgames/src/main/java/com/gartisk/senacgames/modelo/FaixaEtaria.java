package com.gartisk.senacgames.modelo;

public enum FaixaEtaria {
	maior18("18+"),
	maior14("14+"),
	maior12("12+"),
	maior10("10+"),
	maior8("8+"),
	maior6("6+"),
	maior4("4+"),
	maior2("2+"),
	livreParaTodasAsIdades("Livre para Todas as Idades");
	
	private String value;
	
	private FaixaEtaria(String value) {
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
