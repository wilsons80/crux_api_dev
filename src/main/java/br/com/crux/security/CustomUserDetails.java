package br.com.crux.security;

import br.com.crux.to.UnidadeLogadaTO;

public class CustomUserDetails {
	
	private String username;
	private UnidadeLogadaTO unidadeLogada;

	public CustomUserDetails() {
	}
	
	public UnidadeLogadaTO getUnidadeLogada() {
		return unidadeLogada;
	}

	public void setUnidadeLogada(UnidadeLogadaTO unidadeLogada) {
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
