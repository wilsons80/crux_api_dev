package br.com.crux.dto;
// Generated 12/08/2019 22:11:24 by Hibernate Tools 5.3.0.Beta2

import java.util.Date;

/**
 * ResponsaveisAlunos generated by hbm2java
 */
public class ResponsaveisAlunos implements java.io.Serializable {

	private long idResponsavelAluno;
	private Alunos alunos;
	private Responsaveis responsaveis;
	private String dsGrauParentesco;
	private Date dtVinculacao;
	private Date dsDesligamento;
	private Date dtDesvinculacao;
	private String stMesmoEnderResp;
	private String stTipoResponsavel;

	public ResponsaveisAlunos() {
	}

	public ResponsaveisAlunos(long idResponsavelAluno, Alunos alunos, Responsaveis responsaveis) {
		this.idResponsavelAluno = idResponsavelAluno;
		this.alunos = alunos;
		this.responsaveis = responsaveis;
	}

	public ResponsaveisAlunos(long idResponsavelAluno, Alunos alunos, Responsaveis responsaveis,
			String dsGrauParentesco, Date dtVinculacao, Date dsDesligamento, Date dtDesvinculacao,
			String stMesmoEnderResp, String stTipoResponsavel) {
		this.idResponsavelAluno = idResponsavelAluno;
		this.alunos = alunos;
		this.responsaveis = responsaveis;
		this.dsGrauParentesco = dsGrauParentesco;
		this.dtVinculacao = dtVinculacao;
		this.dsDesligamento = dsDesligamento;
		this.dtDesvinculacao = dtDesvinculacao;
		this.stMesmoEnderResp = stMesmoEnderResp;
		this.stTipoResponsavel = stTipoResponsavel;
	}

	public long getIdResponsavelAluno() {
		return this.idResponsavelAluno;
	}

	public void setIdResponsavelAluno(long idResponsavelAluno) {
		this.idResponsavelAluno = idResponsavelAluno;
	}

	public Alunos getAlunos() {
		return this.alunos;
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}

	public Responsaveis getResponsaveis() {
		return this.responsaveis;
	}

	public void setResponsaveis(Responsaveis responsaveis) {
		this.responsaveis = responsaveis;
	}

	public String getDsGrauParentesco() {
		return this.dsGrauParentesco;
	}

	public void setDsGrauParentesco(String dsGrauParentesco) {
		this.dsGrauParentesco = dsGrauParentesco;
	}

	public Date getDtVinculacao() {
		return this.dtVinculacao;
	}

	public void setDtVinculacao(Date dtVinculacao) {
		this.dtVinculacao = dtVinculacao;
	}

	public Date getDsDesligamento() {
		return this.dsDesligamento;
	}

	public void setDsDesligamento(Date dsDesligamento) {
		this.dsDesligamento = dsDesligamento;
	}

	public Date getDtDesvinculacao() {
		return this.dtDesvinculacao;
	}

	public void setDtDesvinculacao(Date dtDesvinculacao) {
		this.dtDesvinculacao = dtDesvinculacao;
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

}
