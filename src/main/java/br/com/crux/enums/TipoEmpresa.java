package br.com.crux.enums;

public enum TipoEmpresa {

	//P = PARCEIRA; V = CONVÊNIO; T = CONTRATO; F = FORNECEDOR; C = CLIENTE; O = OUTRO)

	PARCEIRA("P", "Parceria"), 
	CONVÊNIO("V", "Convênio"),
	CONTRATO("T", "Contrato"),
	FORNECEDOR("F", "Fornecedor"),
	CLIENTE("C", "Cliente"),
	OUTRO("O", "Outro");

	private String tipo;
	private String descricao;

	private TipoEmpresa(String tipo, String descricao) {
		this.tipo = tipo;
		this.descricao = descricao;
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
