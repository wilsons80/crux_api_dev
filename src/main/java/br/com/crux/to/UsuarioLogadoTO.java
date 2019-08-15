package br.com.crux.to;

import java.util.List;

import br.com.crux.dto.PessoasFisicas;
import br.com.crux.dto.UsuariosGrupo;

public class UsuarioLogadoTO {
	
	private String token;
	private String userName;

	private PessoasFisicas pessoasFisica;
	private List<UsuariosGrupo> usuariosGrupos;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public PessoasFisicas getPessoasFisica() {
		return pessoasFisica;
	}

	public void setPessoasFisica(PessoasFisicas pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public List<UsuariosGrupo> getUsuariosGrupos() {
		return usuariosGrupos;
	}

	public void setUsuariosGrupos(List<UsuariosGrupo> usuariosGrupos) {
		this.usuariosGrupos = usuariosGrupos;
	}

	
}
