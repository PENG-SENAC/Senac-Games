package com.gartisk.senacgames.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.gartisk.senacgames.modelo.Entidade;


public class DAOGenerico<T extends Entidade> {

	private Map<Long, T> bancoDadosEmMemoria = new HashMap<Long, T>();
	private Long index = new Long(0);
	
	public Entidade grava(T novoObjeto) {
		index++;
		novoObjeto.setId(index);
		bancoDadosEmMemoria.put( novoObjeto.getId() , novoObjeto );
		return novoObjeto;
	}

	public boolean remove(T objetoARemover) {
		return bancoDadosEmMemoria.remove( objetoARemover.getId() ) != null;
	}

	public boolean atualiza(T objetoAAtualizarNoBanco) {
		return bancoDadosEmMemoria.put(objetoAAtualizarNoBanco.getId(),objetoAAtualizarNoBanco) != null;		
	}
	
	public Collection<T> lista() {
		return bancoDadosEmMemoria.values();
	}

}