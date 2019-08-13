package br.com.crux.dto;
// Generated 12/08/2019 22:11:24 by Hibernate Tools 5.3.0.Beta2

import java.util.Date;

/**
 * VulnerabilidadesFamiliar generated by hbm2java
 */
public class VulnerabilidadesFamiliar implements java.io.Serializable {

	private long idVulnerabilidadeFam;
	private Familiares familiares;
	private SituacoesVulnerabilidades situacoesVulnerabilidades;
	private Solucoes solucoes;
	private Date dtIdentVulnerabilidade;
	private Date dtSolucaoVulnerabilidade;

	public VulnerabilidadesFamiliar() {
	}

	public VulnerabilidadesFamiliar(long idVulnerabilidadeFam, Familiares familiares,
			SituacoesVulnerabilidades situacoesVulnerabilidades, Solucoes solucoes, Date dtIdentVulnerabilidade) {
		this.idVulnerabilidadeFam = idVulnerabilidadeFam;
		this.familiares = familiares;
		this.situacoesVulnerabilidades = situacoesVulnerabilidades;
		this.solucoes = solucoes;
		this.dtIdentVulnerabilidade = dtIdentVulnerabilidade;
	}

	public VulnerabilidadesFamiliar(long idVulnerabilidadeFam, Familiares familiares,
			SituacoesVulnerabilidades situacoesVulnerabilidades, Solucoes solucoes, Date dtIdentVulnerabilidade,
			Date dtSolucaoVulnerabilidade) {
		this.idVulnerabilidadeFam = idVulnerabilidadeFam;
		this.familiares = familiares;
		this.situacoesVulnerabilidades = situacoesVulnerabilidades;
		this.solucoes = solucoes;
		this.dtIdentVulnerabilidade = dtIdentVulnerabilidade;
		this.dtSolucaoVulnerabilidade = dtSolucaoVulnerabilidade;
	}

	public long getIdVulnerabilidadeFam() {
		return this.idVulnerabilidadeFam;
	}

	public void setIdVulnerabilidadeFam(long idVulnerabilidadeFam) {
		this.idVulnerabilidadeFam = idVulnerabilidadeFam;
	}

	public Familiares getFamiliares() {
		return this.familiares;
	}

	public void setFamiliares(Familiares familiares) {
		this.familiares = familiares;
	}

	public SituacoesVulnerabilidades getSituacoesVulnerabilidades() {
		return this.situacoesVulnerabilidades;
	}

	public void setSituacoesVulnerabilidades(SituacoesVulnerabilidades situacoesVulnerabilidades) {
		this.situacoesVulnerabilidades = situacoesVulnerabilidades;
	}

	public Solucoes getSolucoes() {
		return this.solucoes;
	}

	public void setSolucoes(Solucoes solucoes) {
		this.solucoes = solucoes;
	}

	public Date getDtIdentVulnerabilidade() {
		return this.dtIdentVulnerabilidade;
	}

	public void setDtIdentVulnerabilidade(Date dtIdentVulnerabilidade) {
		this.dtIdentVulnerabilidade = dtIdentVulnerabilidade;
	}

	public Date getDtSolucaoVulnerabilidade() {
		return this.dtSolucaoVulnerabilidade;
	}

	public void setDtSolucaoVulnerabilidade(Date dtSolucaoVulnerabilidade) {
		this.dtSolucaoVulnerabilidade = dtSolucaoVulnerabilidade;
	}

}
