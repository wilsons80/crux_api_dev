package br.com.crux.to;

import org.springframework.stereotype.Component;

@Component
public class UsuarioLogadoHolder {

	private UsuarioLogadoTO usuarioLogadoTO;

	public UsuarioLogadoTO getUsuarioLogadoTO() {
		return usuarioLogadoTO;
	}

	public void setUsuarioLogadoTO(UsuarioLogadoTO usuarioLogadoTO) {
		this.usuarioLogadoTO = usuarioLogadoTO;
	}
	
}
