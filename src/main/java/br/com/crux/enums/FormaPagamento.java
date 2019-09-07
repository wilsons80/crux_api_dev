package br.com.crux.enums;

public enum FormaPagamento {

	//Forma de venda do produto da atividade (D = DINHEIRO; C = CARTÃO; D = DÉBITO; F = DESCONTO EM FOLHA
	
	DINHEIRO("R", "Dinheiro"), 
	CARTAO("C", "Cartão"),
	DEBITO("D", "Débito"),
	DESCONTO_FOLHA("F", "Desconto em Folha");

	private String tipo;
	private String descricao;

	private FormaPagamento(String tipo, String descricao) {
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

	public static FormaPagamento getPorTipo(String tipo) {
		for (FormaPagamento tipoClassificador : values()) {
			if (tipoClassificador.getTipo().equals(tipo)) {
				return tipoClassificador;
			}
		}
		return null;
	}

}
