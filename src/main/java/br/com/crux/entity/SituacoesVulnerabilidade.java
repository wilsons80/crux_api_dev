package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the situacoes_vulnerabilidades database table.
 * 
 */
@Entity
@Table(name="situacoes_vulnerabilidades")
public class SituacoesVulnerabilidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vulnerabilidade", unique=true, nullable=false, precision=10)
	private Long idVulnerabilidade;

	@Column(name="ds_situacao_vulnerabilidade", nullable=false, length=200)
	private String dsSituacaoVulnerabilidade;

	//bi-directional many-to-one association to VulnerabilidadesAluno
	@OneToMany(mappedBy="situacoesVulnerabilidade")
	private List<VulnerabilidadesAluno> vulnerabilidadesAlunos;

	//bi-directional many-to-one association to VulnerabilidadesFamiliar
	@OneToMany(mappedBy="situacoesVulnerabilidade")
	private List<VulnerabilidadesFamiliar> vulnerabilidadesFamiliars;

	//bi-directional many-to-one association to VulnerabilidadesResponsavel
	@OneToMany(mappedBy="situacoesVulnerabilidade")
	private List<VulnerabilidadesResponsavel> vulnerabilidadesResponsavels;

	public SituacoesVulnerabilidade() {
	}

	public Long getIdVulnerabilidade() {
		return this.idVulnerabilidade;
	}

	public void setIdVulnerabilidade(Long idVulnerabilidade) {
		this.idVulnerabilidade = idVulnerabilidade;
	}

	public String getDsSituacaoVulnerabilidade() {
		return this.dsSituacaoVulnerabilidade;
	}

	public void setDsSituacaoVulnerabilidade(String dsSituacaoVulnerabilidade) {
		this.dsSituacaoVulnerabilidade = dsSituacaoVulnerabilidade;
	}

	public List<VulnerabilidadesAluno> getVulnerabilidadesAlunos() {
		return this.vulnerabilidadesAlunos;
	}

	public void setVulnerabilidadesAlunos(List<VulnerabilidadesAluno> vulnerabilidadesAlunos) {
		this.vulnerabilidadesAlunos = vulnerabilidadesAlunos;
	}

	public VulnerabilidadesAluno addVulnerabilidadesAluno(VulnerabilidadesAluno vulnerabilidadesAluno) {
		getVulnerabilidadesAlunos().add(vulnerabilidadesAluno);
		vulnerabilidadesAluno.setSituacoesVulnerabilidade(this);

		return vulnerabilidadesAluno;
	}

	public VulnerabilidadesAluno removeVulnerabilidadesAluno(VulnerabilidadesAluno vulnerabilidadesAluno) {
		getVulnerabilidadesAlunos().remove(vulnerabilidadesAluno);
		vulnerabilidadesAluno.setSituacoesVulnerabilidade(null);

		return vulnerabilidadesAluno;
	}

	public List<VulnerabilidadesFamiliar> getVulnerabilidadesFamiliars() {
		return this.vulnerabilidadesFamiliars;
	}

	public void setVulnerabilidadesFamiliars(List<VulnerabilidadesFamiliar> vulnerabilidadesFamiliars) {
		this.vulnerabilidadesFamiliars = vulnerabilidadesFamiliars;
	}

	public VulnerabilidadesFamiliar addVulnerabilidadesFamiliar(VulnerabilidadesFamiliar vulnerabilidadesFamiliar) {
		getVulnerabilidadesFamiliars().add(vulnerabilidadesFamiliar);
		vulnerabilidadesFamiliar.setSituacoesVulnerabilidade(this);

		return vulnerabilidadesFamiliar;
	}

	public VulnerabilidadesFamiliar removeVulnerabilidadesFamiliar(VulnerabilidadesFamiliar vulnerabilidadesFamiliar) {
		getVulnerabilidadesFamiliars().remove(vulnerabilidadesFamiliar);
		vulnerabilidadesFamiliar.setSituacoesVulnerabilidade(null);

		return vulnerabilidadesFamiliar;
	}

	public List<VulnerabilidadesResponsavel> getVulnerabilidadesResponsavels() {
		return this.vulnerabilidadesResponsavels;
	}

	public void setVulnerabilidadesResponsavels(List<VulnerabilidadesResponsavel> vulnerabilidadesResponsavels) {
		this.vulnerabilidadesResponsavels = vulnerabilidadesResponsavels;
	}

	public VulnerabilidadesResponsavel addVulnerabilidadesResponsavel(VulnerabilidadesResponsavel vulnerabilidadesResponsavel) {
		getVulnerabilidadesResponsavels().add(vulnerabilidadesResponsavel);
		vulnerabilidadesResponsavel.setSituacoesVulnerabilidade(this);

		return vulnerabilidadesResponsavel;
	}

	public VulnerabilidadesResponsavel removeVulnerabilidadesResponsavel(VulnerabilidadesResponsavel vulnerabilidadesResponsavel) {
		getVulnerabilidadesResponsavels().remove(vulnerabilidadesResponsavel);
		vulnerabilidadesResponsavel.setSituacoesVulnerabilidade(null);

		return vulnerabilidadesResponsavel;
	}

}