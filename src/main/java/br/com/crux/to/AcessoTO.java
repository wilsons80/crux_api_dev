package br.com.crux.to;

public class AcessoTO {
	
	private Long   idUsuario;
	private String username;
	private String unidade;
	private String modulo;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String codigoUnidade) {
		this.unidade = codigoUnidade;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String nomeUnidade) {
		this.modulo = nomeUnidade;
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
