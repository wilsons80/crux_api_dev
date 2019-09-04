package br.com.crux.security;

import br.com.crux.to.AcessoUnidadeTO;

public class CustomUserDetails {
	
	private String username;
	private AcessoUnidadeTO unidadeLogada;

	public CustomUserDetails() {
	}
	
	public AcessoUnidadeTO getUnidadeLogada() {
		return unidadeLogada;
	}

	public void setUnidadeLogada(AcessoUnidadeTO unidadeLogada) {
		this.unidadeLogada = unidadeLogada;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "CustomUserDetails [username=" + username + ", unidadeLogada=" + unidadeLogada + "]";
	}


	
}
