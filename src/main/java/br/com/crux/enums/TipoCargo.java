package br.com.crux.enums;

public enum TipoCargo {

	// F=FUNCIONÁRIO; V = VOLUNTÁRIO; E = ESTAGIÁRIO

	FUNCIONARIO(1L, "F", "Funcionário"), 
	VOLUNTARIO(2L, "V", "Voluntário"),
	ESTAGIARIO(3L, "E", "Estagiário");

	private Long id;
	private String tipo;
	private String descricao;

	private TipoCargo(Long id, String tipo, String descricao) {
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

	public static TipoCargo getPorTipo(String tipo) {
		for (TipoCargo tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
