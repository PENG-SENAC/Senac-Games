package com.gartisk.senacgames.managedbean;

import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.gartisk.senacgames.modelo.Funcionario;
import com.gartisk.senacgames.modelo.PaginaModo;
import com.gartisk.senacgames.modelo.Sexo;

@ManagedBean
@ViewScoped
public class FuncionarioMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{aplicacaoMB}")
	private AplicacaoMB aplicacaoMB;
	
	private Funcionario funcionario;
	private Sexo sexos = Sexo.naoInformado;
	
	private PaginaModo paginaModo = PaginaModo.adicionar;
	
	public FuncionarioMB() {
		
	}

	@PostConstruct
	public void inicializa() {
		funcionario = new Funcionario();
	}

	private void apresentaMensagem(String resumoMensagem) {
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso",  resumoMensagem ) );
	}

	//CRUD
	public void adicionar() {
		aplicacaoMB.getFuncionarioDAO().grava(this.funcionario);
		apresentaMensagem("Funcionario "+this.funcionario.getNome()+" adicionado com Sucesso");
		this.funcionario = new Funcionario();

	}
	
	public void editar(){
		this.aplicacaoMB.getFuncionarioDAO().atualiza(this.funcionario);
		apresentaMensagem("Funcionario "+funcionario.getNome()+" editado com Sucesso");
		this.funcionario = new Funcionario();
		this.paginaModo = PaginaModo.adicionar;
		
	}
	
	public void remover(Funcionario funcionario){
		this.aplicacaoMB.getFuncionarioDAO().remove(funcionario);
		apresentaMensagem("Funcionario "+funcionario.getNome()+" removido com Sucesso");
	}
	
	public void preparaEditar(Funcionario funcionario) {
		this.paginaModo = PaginaModo.editar;
		this.funcionario = funcionario;
	}
	
	// ENUM GET METHODS
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public PaginaModo[] getPaginaModos(){
		return this.paginaModo.getClass().getEnumConstants();
	}
	
	public Collection<Funcionario> getLista() {
		Collection<Funcionario> lista = aplicacaoMB.getFuncionarioDAO().lista(); 
		return lista;
	}

	public AplicacaoMB getAplicacaoMB() {
		return aplicacaoMB;
	}

	public void setAplicacaoMB(AplicacaoMB aplicacaoMB) {
		this.aplicacaoMB = aplicacaoMB;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public PaginaModo getPaginaModo() {
		return paginaModo;
	}

	public void setPaginaModo(PaginaModo paginaModo) {
		this.paginaModo = paginaModo;
	}

}