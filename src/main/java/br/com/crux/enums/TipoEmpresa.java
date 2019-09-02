package br.com.crux.enums;

public enum TipoEmpresa {

	//P = PARCEIRA; V = CONVÊNIO; T = CONTRATO; F = FORNECEDOR; C = CLIENTE; O = OUTRO)

	PARCEIRA(1L, "P", "Parceria"), 
	CONVÊNIO(2L, "V", "Convênio"),
	CONTRATO(3L, "T", "Contrato"),
	FORNECEDOR(4L, "F", "Fornecedor"),
	CLIENTE(5L, "C", "Cliente"),
	OUTRO(6L, "O", "Outro");

	private Long id;
	private String tipo;
	private String descricao;

	private TipoEmpresa(Long id, String tipo, String descricao) {
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static TipoEmpresa getPorTipo(String tipo) {
		for (TipoEmpresa tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
