package br.com.crux.to;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UsuarioLogadoHolder {

	private UsuarioLogadoTO usuarioLogadoTO;

	public UsuarioLogadoTO getUsuarioLogadoTO() {
		return usuarioLogadoTO;
	}

	public void setUsuarioLogadoTO(UsuarioLogadoTO usuarioLogadoTO) {
		this.usuarioLogadoTO = usuarioLogadoTO;
	}
	
}
