package br.com.crux.to;

public class CadastroAcessoTO {
	
	private Long   idUsuario;
	private Long   idUnidae;
	private Long   idModulo;
	private String altera;
	private String consulta;
	private String deleta;
	private String insere;
	
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getIdUnidade() {
		return idUnidae;
	}
	public void setIdUnidade(Long codigoUnidade) {
		this.idUnidae = codigoUnidade;
	}
	public Long getIdModulo() {
		return idModulo;
	}
	public void setIdModulo(Long nomeUnidade) {
		this.idModulo = nomeUnidade;
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
