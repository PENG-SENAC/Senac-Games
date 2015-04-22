package com.gartisk.senacgames.modelo;

public enum Sexo {
	masculino("Masculino"),
	feminino("Feminino"),
	naoInformado("Não Informado");
	
	private String value;
	
	private Sexo(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
