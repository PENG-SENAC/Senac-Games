package com.gartisk.senacgames.managedbean;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.gartisk.senacgames.modelo.Cliente;
import com.gartisk.senacgames.modelo.PaginaModo;
import com.gartisk.senacgames.modelo.Sexo;

@ManagedBean
@ViewScoped
public class ClienteMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{aplicacaoMB}")
	private AplicacaoMB aplicacaoMB;
	
	private Cliente cliente;
	private Sexo sexos = Sexo.naoInformado;
	
	private PaginaModo paginaModo = PaginaModo.adicionar;
	
	public ClienteMB() {
		
	}

	@PostConstruct
	public void inicializa() {
		cliente = new Cliente();
	}

	private void apresentaMensagem(String resumoMensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso",  resumoMensagem ) );
	}

	//CRUD
	public void adicionar() {
		aplicacaoMB.getClienteDAO().grava(this.cliente);
		apresentaMensagem("Cliente "+this.cliente.getNome()+" adicionado com Sucesso");
		this.cliente = new Cliente();

	}
	
	public void visitanteSeCadastra() {
		aplicacaoMB.getClienteDAO().grava(this.cliente);
		apresentaMensagem("Cliente "+this.cliente.getNome()+" adicionado com Sucesso");
		//return "cadastrado-com-sucesso.xhtml";
	}
	
	public void editar(){
		this.aplicacaoMB.getClienteDAO().atualiza(this.cliente);
		apresentaMensagem("Cliente "+cliente.getNome()+" editado com Sucesso");
		this.cliente = new Cliente();
		this.paginaModo = PaginaModo.adicionar;
		
	}
	
	public void remover(Cliente cliente){
		this.aplicacaoMB.getClienteDAO().remove(cliente);
		apresentaMensagem("Cliente "+cliente.getNome()+" removido com Sucesso");
	}
	
	public void preparaEditar(Cliente cliente) {
		this.paginaModo = PaginaModo.editar;
		this.cliente = cliente;
	}
	
	// ENUM GET METHODS
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public PaginaModo[] getPaginaModos(){
		return this.paginaModo.getClass().getEnumConstants();
	}
	
	public Collection<Cliente> getLista() {
		Collection<Cliente> lista = aplicacaoMB.getClienteDAO().lista(); 
		return lista;
	}

	public AplicacaoMB getAplicacaoMB() {
		return aplicacaoMB;
	}

	public void setAplicacaoMB(AplicacaoMB aplicacaoMB) {
		this.aplicacaoMB = aplicacaoMB;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PaginaModo getPaginaModo() {
		return paginaModo;
	}

	public void setPaginaModo(PaginaModo paginaModo) {
		this.paginaModo = paginaModo;
	}

}