package br.com.crux.to;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.crux.enums.TipoResponsavel;
import br.com.crux.infra.adapter.LocalDateTimeAdapter;

public class ResponsaveisAlunoTO {

	private Long id;
	private String descDesligamento;
	private String descGrauParentesco;

	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataDesvinculacao;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataVinculacao;

	private String mesmoEnderResponsavel;
	private TipoResponsavel tipoResponsavel;
	private AlunoTO aluno;
	private FamiliaresTO familiar;
	private Long usuarioAlteracao;

	public ResponsaveisAlunoTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescDesligamento() {
		return descDesligamento;
	}

	public void setDescDesligamento(String descDesligamento) {
		this.descDesligamento = descDesligamento;
	}

	public String getDescGrauParentesco() {
		return descGrauParentesco;
	}

	public void setDescGrauParentesco(String descGrauParentesco) {
		this.descGrauParentesco = descGrauParentesco;
	}

	public LocalDateTime getDataDesvinculacao() {
		return dataDesvinculacao;
	}

	public void setDataDesvinculacao(LocalDateTime dataDesvinculacao) {
		this.dataDesvinculacao = dataDesvinculacao;
	}

	public LocalDateTime getDataVinculacao() {
		return dataVinculacao;
	}

	public void setDataVinculacao(LocalDateTime dataVinculacao) {
		this.dataVinculacao = dataVinculacao;
	}

	public String getMesmoEnderResponsavel() {
		return mesmoEnderResponsavel;
	}

	public void setMesmoEnderResponsavel(String mesmoEnderResponsavel) {
		this.mesmoEnderResponsavel = mesmoEnderResponsavel;
	}

	public TipoResponsavel getTipoResponsavel() {
		return tipoResponsavel;
	}

	public void setTipoResponsavel(TipoResponsavel tipoResponsavel) {
		this.tipoResponsavel = tipoResponsavel;
	}

	public AlunoTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoTO aluno) {
		this.aluno = aluno;
	}

	public FamiliaresTO getFamiliar() {
		return familiar;
	}

	public void setFamiliar(FamiliaresTO familiar) {
		this.familiar = familiar;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

}