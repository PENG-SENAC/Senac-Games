package com.gartisk.senacgames.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.gartisk.senacgames.dao.ClienteDAO;
import com.gartisk.senacgames.dao.FuncionarioDAO;
import com.gartisk.senacgames.dao.GameDAO;
import com.gartisk.senacgames.modelo.Categoria;
import com.gartisk.senacgames.modelo.Cliente;
import com.gartisk.senacgames.modelo.FaixaEtaria;
import com.gartisk.senacgames.modelo.Funcionario;
import com.gartisk.senacgames.modelo.Game;
import com.gartisk.senacgames.modelo.Produto;
import com.gartisk.senacgames.modelo.Sexo;

@ManagedBean(name="aplicacaoMB")
@ApplicationScoped()
public class AplicacaoMB implements Serializable {
	
	private static final long serialVersionUID = -355235379914074737L;
	private ClienteDAO clienteDAO = new ClienteDAO();
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	private GameDAO gameDAO = new GameDAO();

	@PostConstruct
	private void inicializa() {
		this.inicializaFuncionario();
		this.inicializaCliente();
		this.inicializaGame();
	}
	
	public void inicializaFuncionario(){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Guilherme R Araujo");
		funcionario.setSexo(Sexo.masculino);
		funcionario.setLogin("admin");
		funcionario.setSenha("senac");
		funcionarioDAO.grava(funcionario);
	}
	
	public void inicializaCliente(){
		Cliente cliente = new Cliente();
		cliente.setNome("Cliente exemplo");
		cliente.setSexo(Sexo.feminino);
		cliente.setLogin("cliente");
		cliente.setSenha("senac");
		clienteDAO.grava(cliente);
	}
	
	public void inicializaGame(){
		Game game1 = new Game();
		game1.setNome("Tomb Raider");
		game1.setCategoria(Categoria.Aventura);
		game1.setDescricao("Jogo de aventura");
		game1.setFaixaEtaria(FaixaEtaria.maior14);
		game1.setPreco( 99D );
		
		Game game2 = new Game();
		game2.setNome("Counter Strike 1.6");
		game2.setCategoria(Categoria.FPS);
		game2.setDescricao("Terroristar x CT");
		game2.setFaixaEtaria(FaixaEtaria.maior18);
		game2.setPreco( 99D );
		
		Game game3 = new Game();
		game3.setNome("Sonic The Hedgehog");
		game3.setCategoria(Categoria.Arcade);
		game3.setDescricao("Entre nesse mundo de aventuras");
		game3.setFaixaEtaria(FaixaEtaria.maior2);
		game3.setPreco( 69D );
		
		Game game4 = new Game();
		game4.setNome("FIFA 2016");
		game4.setCategoria(Categoria.ESPORTE);
		game4.setDescricao("jogue com os craques dos maiores clubes do mundo");
		game4.setFaixaEtaria(FaixaEtaria.maior4);
		game4.setPreco( 9D );
		
		gameDAO.grava(game1);
		gameDAO.grava(game2);
		gameDAO.grava(game3);
		gameDAO.grava(game4);
		
	}

	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}

	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}

	public GameDAO getGameDAO() {
		return gameDAO;
	}

	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}

}
