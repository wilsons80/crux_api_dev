package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the responsaveis_alunos database table.
 * 
 */
@Entity
@Table(name="responsaveis_alunos")
@NamedQuery(name="ResponsaveisAluno.findAll", query="SELECT r FROM ResponsaveisAluno r")
public class ResponsaveisAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_responsavel_aluno")
	private Long idResponsavelAluno;

	@Column(name="ds_desligamento")
	private Timestamp dsDesligamento;

	@Column(name="ds_grau_parentesco")
	private String dsGrauParentesco;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_desvinculacao")
	private Date dtDesvinculacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_vinculacao")
	private Date dtVinculacao;

	@Column(name="st_mesmo_ender_resp")
	private String stMesmoEnderResp;

	@Column(name="st_tipo_responsavel")
	private String stTipoResponsavel;

	//bi-directional many-to-one association to Aluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aluno")
	private Aluno aluno;

	//bi-directional many-to-one association to Responsavei
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_responsavel")
	private Responsavei responsavei;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}