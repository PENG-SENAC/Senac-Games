package com.gartisk.senacgames.managedbean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.gartisk.senacgames.modelo.Categoria;
import com.gartisk.senacgames.modelo.FaixaEtaria;
import com.gartisk.senacgames.modelo.Game;
import com.gartisk.senacgames.modelo.PaginaModo;

@ManagedBean
@ViewScoped
public class GameMB implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{aplicacaoMB}")
	private AplicacaoMB aplicacaoMB;
	
	private Game game;
	private FaixaEtaria faixaEtarias = FaixaEtaria.livreParaTodasAsIdades;
	private Categoria categorias = Categoria.Arcade;
	
	private PaginaModo paginaModo = PaginaModo.adicionar;
	
	public GameMB() {
		
	}

	@PostConstruct
	public void inicializa() {
		game = new Game();
	}

	private void apresentaMensagem(String resumoMensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso",  resumoMensagem ) );
	}

	//CRUD
	public void adicionar() {
		System.out.println("EM ADICIONAR");
		aplicacaoMB.getGameDAO().grava(this.game);
		apresentaMensagem("Game "+this.game.getNome()+" adicionado com Sucesso");
		this.game = new Game();

	}
	
	public void editar(){
		System.out.println("EM EDITAR");
		this.aplicacaoMB.getGameDAO().atualiza(this.game);
		apresentaMensagem("Game "+game.getNome()+" editado com Sucesso");
		this.game = new Game();
		this.paginaModo = PaginaModo.adicionar;
		
	}
	
	public void remover(Game game){
		this.aplicacaoMB.getGameDAO().remove(game);
		apresentaMensagem("Game "+game.getNome()+" removido com Sucesso");
	}
	
	public void preparaEditar(Game game) {
		this.paginaModo = PaginaModo.editar;
		this.game = game;
	}
	
	// ENUM GET METHODS
	public FaixaEtaria[] getFaixaEtarias() {
		return FaixaEtaria.values();
	}

	public Categoria[] getCategorias() {
		return Categoria.values();
	}
	
	public PaginaModo[] getPaginaModos(){
		return this.paginaModo.getClass().getEnumConstants();
	}
	
	public Collection<Game> getLista() {
		Collection<Game> lista = aplicacaoMB.getGameDAO().lista(); 
		return lista;
	}

	public AplicacaoMB getAplicacaoMB() {
		return aplicacaoMB;
	}

	public void setAplicacaoMB(AplicacaoMB aplicacaoMB) {
		this.aplicacaoMB = aplicacaoMB;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public PaginaModo getPaginaModo() {
		return paginaModo;
	}

	public void setPaginaModo(PaginaModo paginaModo) {
		this.paginaModo = paginaModo;
	}
		
}
