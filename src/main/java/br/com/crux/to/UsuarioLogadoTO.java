package br.com.crux.to;

import java.util.List;

public class UsuarioLogadoTO {
	
	private String token;
	private String username;

	private List<UnidadeTO> unidades;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public List<UnidadeTO> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<UnidadeTO> unidades) {
		this.unidades = unidades;
	}

	

	
}
