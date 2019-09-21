package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the vulnerabilidades_aluno database table.
 * 
 */
@Entity
@Table(name="vulnerabilidades_aluno")
@NamedQuery(name="VulnerabilidadesAluno.findAll", query="SELECT v FROM VulnerabilidadesAluno v")
public class VulnerabilidadesAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vulnerabilidade_aluno")
	private Long idVulnerabilidadeAluno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_ident_vulnerabilidade")
	private Date dtIdentVulnerabilidade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_solucao_vulnerabilidade")
	private Date dtSolucaoVulnerabilidade;

	//bi-directional many-to-one association to Aluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aluno")
	private Aluno aluno;

	//bi-directional many-to-one association to SituacoesVulnerabilidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_vulnerabilidade")
	private SituacoesVulnerabilidade situacoesVulnerabilidade;

	//bi-directional many-to-one association to Solucoe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_solucao")
	private Solucoes solucoe;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public VulnerabilidadesAluno() {
	}

	public Long getIdVulnerabilidadeAluno() {
		return this.idVulnerabilidadeAluno;
	}

	public void setIdVulnerabilidadeAluno(Long idVulnerabilidadeAluno) {
		this.idVulnerabilidadeAluno = idVulnerabilidadeAluno;
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

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}