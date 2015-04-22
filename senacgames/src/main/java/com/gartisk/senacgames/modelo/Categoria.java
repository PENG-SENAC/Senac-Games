package com.gartisk.senacgames.modelo;

public enum Categoria {
	FPS("FPS"),
	RPG("RPG"),
	ESPORTE("Esporte"),
	Corrida("Corrida"),
	Aventura("Aventura"),
	Arcade("Arcade"),
	Estrategia("Estratégia");
	
	private String value;
	
	private Categoria(String value) {
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
