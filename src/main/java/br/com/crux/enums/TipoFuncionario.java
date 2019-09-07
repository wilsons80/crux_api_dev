package br.com.crux.enums;

public enum TipoFuncionario {

	//F = FUNCIONÁRIO; E = ESTAGIÁRIO; C = COLABORADOR; I = INSTRUTOR; V = VOLUNTÁRIO; D = CANDIDATO A VAGA DE FUNCIONÁRIO

	FUNCIONARIO("F", "Funcionário"), 
	VOLUNTARIO("V", "Voluntário"),
	ESTAGIARIO("E", "Estagiário"),
	COLABORADOR("C", "Colaborador"),
	INSTRUTOR("I", "Instrutor"),
	CANDIDATO_VAGA_FUNCIONARIO("D", "Candidato a vaga de funcionário");

	private String tipo;
	private String descricao;

	private TipoFuncionario(String tipo, String descricao) {
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

	public static TipoFuncionario getPorTipo(String tipo) {
		for (TipoFuncionario tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
