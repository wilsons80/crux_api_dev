package br.com.crux.enums;

public enum TipoCargo {

	// F=FUNCIONÁRIO; V = VOLUNTÁRIO; E = ESTAGIÁRIO

	FUNCIONARIO("F", "Funcionário"), 
	VOLUNTARIO("V", "Voluntário"),
	ESTAGIARIO("E", "Estagiário");

	private String tipo;
	private String descricao;

	private TipoCargo(String tipo, String descricao) {
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

	public static TipoCargo getPorTipo(String tipo) {
		for (TipoCargo tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
