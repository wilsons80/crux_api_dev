package br.com.crux.enums;

public enum ParecerEntrevistador {

	//D = CANDIDATO A VAGA DE FUNCIONÁRIO;  T=  Totalmente adequado ao perfil; N = Não adequado ao perfil; A = Adequado ao perfil; I = Indicado p/ consulta futura)	 

	INDICADO_CONSULTA_FUTURA("I", "Indicado p/ consulta futura"),
	ADEQUADO_PERFIL("A", "Adequado ao perfil"),
	NAO_ADEQUADO_PERFIL("N", "Não adequado ao perfil"),
	TOTALMENTO_ADEQUADO_PERFIL("T", "Totalmente adequado ao perfil"),
	CANDIDATO_VAGA_FUNCIONARIO("D", "Candidato a vaga de funcionário");

	private String tipo;
	private String descricao;

	private ParecerEntrevistador(String tipo, String descricao) {
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

	public static ParecerEntrevistador getPorTipo(String tipo) {
		for (ParecerEntrevistador tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
