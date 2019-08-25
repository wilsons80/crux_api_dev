package br.com.crux.enums;

public enum ClassificadorSituacaoImovel {

	// P = PRÓPRIO; C = CONCESSÃO; L = LICENÇA PARA FUNCIONAMENTO; O = OUTRO

	PROPRIO(1L, "P", "Próprio"), 
	CONCESSAO(2L, "C", "Concessão"),
	LICENCA_PARA_FUNCIONAMENTO(3L, "L", "Licença pra funcionamento"), 
	OUTRO(4L, "O", "Outro");

	private Long id;
	private String tipo;
	private String descricao;

	private ClassificadorSituacaoImovel(Long id, String tipo, String descricao) {
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

	public static ClassificadorSituacaoImovel getPorTipo(String tipo) {
		for (ClassificadorSituacaoImovel tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
