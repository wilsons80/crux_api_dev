package br.com.crux.enums;

public enum TipoUnidade {
	
	MATRIZ("M"),
	FILIAL("F");
	
	private String tipo;
	
	private TipoUnidade(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static TipoUnidade getPorTipo(String tipo) {
		for (TipoUnidade tipoUnidade : values()) {
			if (tipoUnidade.getTipo().equals(tipo)) {
				return tipoUnidade;
			}
		}
		return null;
	}	
	

}
