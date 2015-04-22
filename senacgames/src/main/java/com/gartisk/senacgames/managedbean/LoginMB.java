package com.gartisk.senacgames.managedbean;
 
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.gartisk.senacgames.modelo.Cliente;
import com.gartisk.senacgames.modelo.Funcionario;
 
@ManagedBean(name="loginMB")
@SessionScoped
public class LoginMB implements Serializable{
     
	@ManagedProperty(value="#{aplicacaoMB}")
	private AplicacaoMB aplicacaoMB;
	
	private String login = "";
    private String senha = "";
    
    private boolean logado = false;
    private String tipoUsuario = null;
      
    public LoginMB()
    {
    	  	
    }
    
	@PostConstruct
	public void inicializa() {

	}
	
	@PreDestroy
	public void finaliza() {		
		
	}
	
	public void sair() throws Exception {		
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    ec.redirect("index.xhtml");
	}
    

    public boolean getLogado(){
    	return logado;
    }
    
    public void setLogado(boolean logado){
    	this.logado = logado;
    }
 
    
    public void fazerLogin() {
    	System.out.println("FAZER LOGIN");
    	FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = null;
        String idDoComponenteRelacionado = null;
        
    	if( login.trim().isEmpty() || senha.trim().isEmpty() ){
    		message.setSeverity(FacesMessage.SEVERITY_WARN);
        	message = new FacesMessage("Não é permitido o envio de campos em branco");
        	context.addMessage(null, message);
    		
    	}
    	
        
        Collection<Cliente> clientes = aplicacaoMB.getClienteDAO().lista();
        Collection<Funcionario> funcionarios = aplicacaoMB.getFuncionarioDAO().lista();
        
        if( null != clientes ){
        	
        	for (Cliente cliente : clientes) {
        		if( this.login.equals( cliente.getLogin() ) ){
        			
        			if( this.senha.equals( cliente.getSenha() ) ){
        				tipoUsuario = Cliente.class.getName();
        				logado = true;
        				message = new FacesMessage( "Seja bem vindo "+cliente.getNome() );
        				message.setSeverity(FacesMessage.SEVERITY_INFO);
        				
        				break;
        			}
        		}
			}
        	
        }
                
        if( null != funcionarios ){
        	
        	for (Funcionario funcionario : funcionarios) {
        		if( this.login.equals( funcionario.getLogin() ) ){
        			
        			if( this.senha.equals( funcionario.getSenha() ) ){
        				tipoUsuario = Funcionario.class.getName();
        				logado = true;
        				message = new FacesMessage( "Seja bem vindo "+funcionario.getNome() );
        				message.setSeverity(FacesMessage.SEVERITY_INFO);
        				break;
        			}
        		}
			}
        	
        }
        
        if( !logado ){ 
        	message = new FacesMessage("Usuário ou Senha Inválido!");
        	message.setSeverity(FacesMessage.SEVERITY_WARN);
        }
        
        context.addMessage(null, message);
 
    }

	public AplicacaoMB getAplicacaoMB() {
		return aplicacaoMB;
	}

	public void setAplicacaoMB(AplicacaoMB aplicacaoMB) {
		this.aplicacaoMB = aplicacaoMB;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getFuncionario() {
		return Funcionario.class.getName();
	}

	public String getCliente() {
		return Cliente.class.getName();
	}

	
    
    
}