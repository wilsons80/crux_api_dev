package br.com.crux.enums;

public enum CategoriaEmpresa {

	//P = PRESTADOR DE SERVIÇOS; C = COMERCIAL; I = INDUSTRIAS; O = OUTRO)
	
	PRESTADOR_SERVICO("P", "Prestador de Serviços"), 
	COMERCIAL("C", "Comercial"),
	INDUSTRIAS("I", "Industrias"),
	OUTRO("O", "Outro");

	private String tipo;
	private String descricao;

	private CategoriaEmpresa(String tipo, String descricao) {
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

	public static CategoriaEmpresa getPorTipo(String tipo) {
		for (CategoriaEmpresa tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
