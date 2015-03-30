package com.gartisk.senacgames.modelo;

public enum FaixaEtaria {
	maior18("+18"),
	maior14("+14"),
	maior12("+12"),
	maior3("+3"),
	livreParaTodasAsIdades("Livre para Todas as Idades");
	
	private String faixa;
	
	private FaixaEtaria(String faixa) {
		this.faixa = faixa;
	}
	
	public String getFaixa(){
		return faixa;
	}
}
