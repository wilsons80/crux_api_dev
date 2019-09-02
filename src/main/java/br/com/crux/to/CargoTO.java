package br.com.crux.to;

import br.com.crux.enums.TipoCarga;

public class CargoTO {

	private Long id;
	private String codigo;
	private String nome;
	private TipoCarga tipoCargo;
	private Long usuarioAlteracao;

	public CargoTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCarga getTipoCargo() {
		return tipoCargo;
	}

	public void setTipoCargo(TipoCarga tipoCargo) {
		this.tipoCargo = tipoCargo;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

}
