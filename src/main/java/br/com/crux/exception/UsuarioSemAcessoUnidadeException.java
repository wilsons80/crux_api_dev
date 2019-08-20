package br.com.crux.exception;

import br.com.crux.exception.base.NegocioException;

public class UsuarioSemAcessoUnidadeException extends NegocioException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioSemAcessoUnidadeException(String msg) {
		super(msg);
	}

}
