package br.com.crux.exception;

import br.com.crux.infra.NegocioException;

public class ParametroNaoInformado extends NegocioException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParametroNaoInformado(String msg) {
		super(msg);
	}

}
