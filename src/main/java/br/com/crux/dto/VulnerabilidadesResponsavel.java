package br.com.crux.dto;
// Generated 12/08/2019 22:11:24 by Hibernate Tools 5.3.0.Beta2

import java.util.Date;

/**
 * VulnerabilidadesResponsavel generated by hbm2java
 */
public class VulnerabilidadesResponsavel implements java.io.Serializable {

	private long idVulnerabilidadeResp;
	private Responsaveis responsaveis;
	private SituacoesVulnerabilidades situacoesVulnerabilidades;
	private Solucoes solucoes;
	private Date dtIdentVulnerabilidade;
	private Date dtSolucaoVulnerabilidade;

	public VulnerabilidadesResponsavel() {
	}

	public VulnerabilidadesResponsavel(long idVulnerabilidadeResp, Responsaveis responsaveis,
			SituacoesVulnerabilidades situacoesVulnerabilidades, Solucoes solucoes, Date dtIdentVulnerabilidade) {
		this.idVulnerabilidadeResp = idVulnerabilidadeResp;
		this.responsaveis = responsaveis;
		this.situacoesVulnerabilidades = situacoesVulnerabilidades;
		this.solucoes = solucoes;
		this.dtIdentVulnerabilidade = dtIdentVulnerabilidade;
	}

	public VulnerabilidadesResponsavel(long idVulnerabilidadeResp, Responsaveis responsaveis,
			SituacoesVulnerabilidades situacoesVulnerabilidades, Solucoes solucoes, Date dtIdentVulnerabilidade,
			Date dtSolucaoVulnerabilidade) {
		this.idVulnerabilidadeResp = idVulnerabilidadeResp;
		this.responsaveis = responsaveis;
		this.situacoesVulnerabilidades = situacoesVulnerabilidades;
		this.solucoes = solucoes;
		this.dtIdentVulnerabilidade = dtIdentVulnerabilidade;
		this.dtSolucaoVulnerabilidade = dtSolucaoVulnerabilidade;
	}

	public long getIdVulnerabilidadeResp() {
		return this.idVulnerabilidadeResp;
	}

	public void setIdVulnerabilidadeResp(long idVulnerabilidadeResp) {
		this.idVulnerabilidadeResp = idVulnerabilidadeResp;
	}

	public Responsaveis getResponsaveis() {
		return this.responsaveis;
	}

	public void setResponsaveis(Responsaveis responsaveis) {
		this.responsaveis = responsaveis;
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
