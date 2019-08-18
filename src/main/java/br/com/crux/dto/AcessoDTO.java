package br.com.crux.dto;

import java.math.BigDecimal;

public class AcessoDTO {
	
	private Long   idUsuario;
	private String username;
	private String unidade;
	private String modulo;
	private String altera;
	private String consulta;
	private String deleta;
	private String insere;
	
	public AcessoDTO() {
	}
	
	public AcessoDTO(Object[] colunas) {
		this.idUsuario     = (colunas[0] != null)? ((BigDecimal)colunas[0]).longValue() : null;
		this.username      = (String) colunas[1];
		this.unidade = (String) colunas[2];
		this.modulo   = (String) colunas[3];
		this.altera        = (String) colunas[4];
		this.consulta      = (String) colunas[5];
		this.deleta        = (String) colunas[6];
		this.insere        = (String) colunas[7];
	}
	
	

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
