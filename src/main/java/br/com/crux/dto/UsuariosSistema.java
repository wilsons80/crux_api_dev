package br.com.crux.dto;
// Generated 12/08/2019 22:11:24 by Hibernate Tools 5.3.0.Beta2

public class UsuariosSistema {
	
	private String userName;
	private String senha;
	
	public UsuariosSistema() {
	}

	public UsuariosSistema(String userName, String senha) {
		super();
		this.userName = userName;
		this.senha = senha;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
