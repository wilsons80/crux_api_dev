package br.com.crux.exception;

import br.com.crux.exception.base.NegocioException;

public class PerfilAcessoCadastradoException extends NegocioException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PerfilAcessoCadastradoException(String msg) {
		super(msg);
	}

}
