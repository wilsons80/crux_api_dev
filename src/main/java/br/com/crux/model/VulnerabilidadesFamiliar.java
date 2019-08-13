package br.com.crux.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the vulnerabilidades_familiar database table.
 * 
 */
@Entity
@Table(name="vulnerabilidades_familiar")
public class VulnerabilidadesFamiliar  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vulnerabilidade_fam", unique=true, nullable=false, precision=10)
	private Long idVulnerabilidadeFam;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_ident_vulnerabilidade", nullable=false)
	private Date dtIdentVulnerabilidade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_solucao_vulnerabilidade")
	private Date dtSolucaoVulnerabilidade;

	//bi-directional many-to-one association to Familiare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_familiar", nullable=false)
	private Familiare familiare;

	//bi-directional many-to-one association to SituacoesVulnerabilidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vulnerabilidade", nullable=false)
	private SituacoesVulnerabilidade situacoesVulnerabilidade;

	//bi-directional many-to-one association to Solucoe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_solucao", nullable=false)
	private Solucoe solucoe;

	public VulnerabilidadesFamiliar() {
	}

	public Long getIdVulnerabilidadeFam() {
		return this.idVulnerabilidadeFam;
	}

	public void setIdVulnerabilidadeFam(Long idVulnerabilidadeFam) {
		this.idVulnerabilidadeFam = idVulnerabilidadeFam;
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

	public Familiare getFamiliare() {
		return this.familiare;
	}

	public void setFamiliare(Familiare familiare) {
		this.familiare = familiare;
	}

	public SituacoesVulnerabilidade getSituacoesVulnerabilidade() {
		return this.situacoesVulnerabilidade;
	}

	public void setSituacoesVulnerabilidade(SituacoesVulnerabilidade situacoesVulnerabilidade) {
		this.situacoesVulnerabilidade = situacoesVulnerabilidade;
	}

	public Solucoe getSolucoe() {
		return this.solucoe;
	}

	public void setSolucoe(Solucoe solucoe) {
		this.solucoe = solucoe;
	}

}