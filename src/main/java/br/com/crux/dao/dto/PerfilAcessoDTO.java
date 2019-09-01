package br.com.crux.dao.dto;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

public class PerfilAcessoDTO {

	private Long idModulo;
	private String nomeModulo;
	private String altera;
	private String consulta;
	private String deleta;
	private String insere;

	public PerfilAcessoDTO() {
	}

	public PerfilAcessoDTO(Object[] colunas) {
		this.idModulo   = (colunas[0] != null) ? ((BigDecimal) colunas[0]).longValue() : null;
		this.nomeModulo = (String) colunas[1];
		this.altera     = StringUtils.isEmpty((String) colunas[2]) ? "N" : "S";
		this.consulta   = StringUtils.isEmpty((String) colunas[3]) ? "N" : "S";
		this.deleta     = StringUtils.isEmpty((String) colunas[4]) ? "N" : "S";
		this.insere     = StringUtils.isEmpty((String) colunas[5]) ? "N" : "S";
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
