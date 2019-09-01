package br.com.crux.dao.dto;

import java.math.BigDecimal;

public class MenuDTO {
	
	private Long idModuloPai;
	private String nomeModuloPai;
	private Long idModuloFilho;
	private String nomeModuloFilho;
	private String nivel;

	public MenuDTO() {
	}
	
	public MenuDTO(Object[] colunas) {
		this.idModuloPai        = (colunas[0] != null)? ((BigDecimal)colunas[0]).longValue() : null;
		this.nomeModuloPai      = (String) colunas[1];
		this.idModuloFilho      = (colunas[2] != null)? ((BigDecimal)colunas[2]).longValue() : null;
		this.nomeModuloFilho    = (String) colunas[3];
		this.nivel              = (String) colunas[4];
		
	}

	public Long getIdModuloPai() {
		return idModuloPai;
	}

	public void setIdModuloPai(Long idModuloPai) {
		this.idModuloPai = idModuloPai;
	}

	public String getNomeModuloPai() {
		return nomeModuloPai;
	}

	public void setNomeModuloPai(String nomeModuloPai) {
		this.nomeModuloPai = nomeModuloPai;
	}

	public Long getIdModuloFilho() {
		return idModuloFilho;
	}

	public void setIdModuloFilho(Long idModuloFilho) {
		this.idModuloFilho = idModuloFilho;
	}

	public String getNomeModuloFilho() {
		return nomeModuloFilho;
	}

	public void setNomeModuloFilho(String nomeModuloFilho) {
		this.nomeModuloFilho = nomeModuloFilho;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	
	

}
