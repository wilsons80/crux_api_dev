package br.com.crux.to;

import br.com.crux.dto.UsuariosSistema;

public class UsuarioLogadoTO {
	
	private String token;
	private UsuariosSistema usuarioSistema;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UsuariosSistema getUsuarioSistema() {
		return usuarioSistema;
	}

	public void setUsuarioSistema(UsuariosSistema usuarioSistema) {
		this.usuarioSistema = usuarioSistema;
	}

	
}
