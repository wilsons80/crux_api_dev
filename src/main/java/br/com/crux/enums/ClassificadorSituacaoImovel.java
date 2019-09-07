package br.com.crux.enums;

public enum ClassificadorSituacaoImovel {

	// P = PRÓPRIO; C = CONCESSÃO; L = LICENÇA PARA FUNCIONAMENTO; O = OUTRO

	PROPRIO("P", "Próprio"), 
	CONCESSAO("C", "Concessão"),
	LICENCA_PARA_FUNCIONAMENTO("L", "Licença pra funcionamento"), 
	OUTRO("O", "Outro");

	private String tipo;
	private String descricao;

	private ClassificadorSituacaoImovel(String tipo, String descricao) {
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

	public static ClassificadorSituacaoImovel getPorTipo(String tipo) {
		for (ClassificadorSituacaoImovel tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
