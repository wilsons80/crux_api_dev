package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vulnerabilidades_familiar database table.
 * 
 */
@Entity
@Table(name="vulnerabilidades_familiar")
@NamedQuery(name="VulnerabilidadesFamiliar.findAll", query="SELECT v FROM VulnerabilidadesFamiliar v")
public class VulnerabilidadesFamiliar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vulnerabilidade_fam")
	private Long idVulnerabilidadeFam;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_ident_vulnerabilidade")
	private Date dtIdentVulnerabilidade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_solucao_vulnerabilidade")
	private Date dtSolucaoVulnerabilidade;

	//bi-directional many-to-one association to Familiare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_familiar")
	private Familiare familiare;

	//bi-directional many-to-one association to SituacoesVulnerabilidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vulnerabilidade")
	private SituacoesVulnerabilidade situacoesVulnerabilidade;

	//bi-directional many-to-one association to Solucoe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_solucao")
	private Solucoe solucoe;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}