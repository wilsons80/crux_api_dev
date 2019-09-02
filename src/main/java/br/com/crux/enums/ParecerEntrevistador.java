package br.com.crux.enums;

public enum ParecerEntrevistador {

	//D = CANDIDATO A VAGA DE FUNCIONÁRIO;  T=  Totalmente adequado ao perfil; N = Não adequado ao perfil; A = Adequado ao perfil; I = Indicado p/ consulta futura)	 

	INDICADO_CONSULTA_FUTURA(1L, "I", "Indicado p/ consulta futura"),
	ADEQUADO_PERFIL(2L, "A", "Adequado ao perfil"),
	NAO_ADEQUADO_PERFIL(3L, "N", "Não adequado ao perfil"),
	TOTALMENTO_ADEQUADO_PERFIL(4L, "T", "Totalmente adequado ao perfil"),
	CANDIDATO_VAGA_FUNCIONARIO(5L, "D", "Candidato a vaga de funcionário");

	private Long id;
	private String tipo;
	private String descricao;

	private ParecerEntrevistador(Long id, String tipo, String descricao) {
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

	public static ParecerEntrevistador getPorTipo(String tipo) {
		for (ParecerEntrevistador tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
