package br.com.crux.enums;

public enum ConclusaoParecer {
	//S = Dar continuidade ao processo seletivo; n = Não dar continuidade ao processo seletivo	 

	CONTINUAR("S", "Dar continuidade ao processo seletivo"),
	NAO_CONTINUAR("N", "Não dar continuidade ao processo seletivo");

	private String tipo;
	private String descricao;

	private ConclusaoParecer(String tipo, String descricao) {
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

	public static ConclusaoParecer getPorTipo(String tipo) {
		for (ConclusaoParecer tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
