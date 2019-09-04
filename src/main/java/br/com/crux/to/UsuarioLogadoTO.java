package br.com.crux.to;

import java.util.List;

public class UsuarioLogadoTO {
	
	private String token;
	private String username;
	private AcessoUnidadeTO unidadeLogada;

	private List<AcessoUnidadeTO> unidades;
	
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

	public List<AcessoUnidadeTO> getUnidades() {
		return unidades;
	}

	public void setUnidades(List<AcessoUnidadeTO> unidades) {
		this.unidades = unidades;
	}

	public AcessoUnidadeTO getUnidadeLogada() {
		return unidadeLogada;
	}

	public void setUnidadeLogada(AcessoUnidadeTO unidadeLogada) {
		this.unidadeLogada = unidadeLogada;
	}

	

	
}
