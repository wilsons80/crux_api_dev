package br.com.crux.enums;

public enum TipoFuncionario {

	//F = FUNCIONÁRIO; E = ESTAGIÁRIO; C = COLABORADOR; I = INSTRUTOR; V = VOLUNTÁRIO; D = CANDIDATO A VAGA DE FUNCIONÁRIO

	FUNCIONARIO(1L, "F", "Funcionário"), 
	VOLUNTARIO(2L, "V", "Voluntário"),
	ESTAGIARIO(3L, "E", "Estagiário"),
	COLABORADOR(4L, "C", "Colaborador"),
	INSTRUTOR(5L, "I", "Instrutor"),
	CANDIDATO_VAGA_FUNCIONARIO(6L, "D", "Candidato a vaga de funcionário");

	private Long id;
	private String tipo;
	private String descricao;

	private TipoFuncionario(Long id, String tipo, String descricao) {
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

	public static TipoFuncionario getPorTipo(String tipo) {
		for (TipoFuncionario tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
