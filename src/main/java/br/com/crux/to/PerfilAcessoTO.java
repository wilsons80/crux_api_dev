package br.com.crux.to;

public class PerfilAcessoTO {

	private Long idModulo;
	private String nomeModulo;
	private String altera;
	private String consulta;
	private String deleta;
	private String insere;

	public PerfilAcessoTO() {
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getNomeModulo() {
		return nomeModulo;
	}

	public void setNomeModulo(String nomeModulo) {
		this.nomeModulo = nomeModulo;
	}

	public String getAltera() {
		return altera;
	}

	public void setAltera(String altera) {
		this.altera = altera;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}

	public String getDeleta() {
		return deleta;
	}

	public void setDeleta(String deleta) {
		this.deleta = deleta;
	}

	public String getInsere() {
		return insere;
	}

	public void setInsere(String insere) {
		this.insere = insere;
	}

}
