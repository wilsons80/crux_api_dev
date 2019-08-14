package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vulnerabilidades_responsavel database table.
 * 
 */
@Entity
@Table(name="vulnerabilidades_responsavel")
public class VulnerabilidadesResponsavel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vulnerabilidade_resp", unique=true, nullable=false, precision=10)
	private Long idVulnerabilidadeResp;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_ident_vulnerabilidade", nullable=false)
	private Date dtIdentVulnerabilidade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_solucao_vulnerabilidade")
	private Date dtSolucaoVulnerabilidade;

	//bi-directional many-to-one association to Responsavei
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_responsavel", nullable=false)
	private Responsaveis responsavei;

	//bi-directional many-to-one association to SituacoesVulnerabilidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vulnerabilidade", nullable=false)
	private SituacoesVulnerabilidade situacoesVulnerabilidade;

	//bi-directional many-to-one association to Solucoe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_solucao", nullable=false)
	private Solucoes solucoe;

	public VulnerabilidadesResponsavel() {
	}

	public Long getIdVulnerabilidadeResp() {
		return this.idVulnerabilidadeResp;
	}

	public void setIdVulnerabilidadeResp(Long idVulnerabilidadeResp) {
		this.idVulnerabilidadeResp = idVulnerabilidadeResp;
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

	public Responsaveis getResponsavei() {
		return this.responsavei;
	}

	public void setResponsavei(Responsaveis responsavei) {
		this.responsavei = responsavei;
	}

	public SituacoesVulnerabilidade getSituacoesVulnerabilidade() {
		return this.situacoesVulnerabilidade;
	}

	public void setSituacoesVulnerabilidade(SituacoesVulnerabilidade situacoesVulnerabilidade) {
		this.situacoesVulnerabilidade = situacoesVulnerabilidade;
	}

	public Solucoes getSolucoe() {
		return this.solucoe;
	}

	public void setSolucoe(Solucoes solucoe) {
		this.solucoe = solucoe;
	}

}