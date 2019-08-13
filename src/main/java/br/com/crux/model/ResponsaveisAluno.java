package br.com.crux.model;

import java.sql.Timestamp;
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
 * The persistent class for the responsaveis_alunos database table.
 * 
 */
@Entity
@Table(name="responsaveis_alunos")
public class ResponsaveisAluno  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_responsavel_aluno", unique=true, nullable=false, precision=10)
	private Long idResponsavelAluno;

	@Column(name="ds_desligamento")
	private Timestamp dsDesligamento;

	@Column(name="ds_grau_parentesco", length=45)
	private String dsGrauParentesco;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_desvinculacao")
	private Date dtDesvinculacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_vinculacao")
	private Date dtVinculacao;

	@Column(name="st_mesmo_ender_resp", length=1)
	private String stMesmoEnderResp;

	@Column(name="st_tipo_responsavel", length=1)
	private String stTipoResponsavel;

	//bi-directional many-to-one association to Aluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aluno", nullable=false)
	private Aluno aluno;

	//bi-directional many-to-one association to Responsavei
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_responsavel", nullable=false)
	private Responsavei responsavei;

	public ResponsaveisAluno() {
	}

	public Long getIdResponsavelAluno() {
		return this.idResponsavelAluno;
	}

	public void setIdResponsavelAluno(Long idResponsavelAluno) {
		this.idResponsavelAluno = idResponsavelAluno;
	}

	public Timestamp getDsDesligamento() {
		return this.dsDesligamento;
	}

	public void setDsDesligamento(Timestamp dsDesligamento) {
		this.dsDesligamento = dsDesligamento;
	}

	public String getDsGrauParentesco() {
		return this.dsGrauParentesco;
	}

	public void setDsGrauParentesco(String dsGrauParentesco) {
		this.dsGrauParentesco = dsGrauParentesco;
	}

	public Date getDtDesvinculacao() {
		return this.dtDesvinculacao;
	}

	public void setDtDesvinculacao(Date dtDesvinculacao) {
		this.dtDesvinculacao = dtDesvinculacao;
	}

	public Date getDtVinculacao() {
		return this.dtVinculacao;
	}

	public void setDtVinculacao(Date dtVinculacao) {
		this.dtVinculacao = dtVinculacao;
	}

	public String getStMesmoEnderResp() {
		return this.stMesmoEnderResp;
	}

	public void setStMesmoEnderResp(String stMesmoEnderResp) {
		this.stMesmoEnderResp = stMesmoEnderResp;
	}

	public String getStTipoResponsavel() {
		return this.stTipoResponsavel;
	}

	public void setStTipoResponsavel(String stTipoResponsavel) {
		this.stTipoResponsavel = stTipoResponsavel;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Responsavei getResponsavei() {
		return this.responsavei;
	}

	public void setResponsavei(Responsavei responsavei) {
		this.responsavei = responsavei;
	}

}