package br.com.crux.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the solucoes database table.
 * 
 */
@Entity
@Table(name="solucoes")
public class Solucoe  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_solucao", unique=true, nullable=false, precision=10)
	private Long idSolucao;

	@Column(name="ds_solucao", nullable=false, length=200)
	private String dsSolucao;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="solucoe")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to VulnerabilidadesAluno
	@OneToMany(mappedBy="solucoe")
	private List<VulnerabilidadesAluno> vulnerabilidadesAlunos;

	//bi-directional many-to-one association to VulnerabilidadesFamiliar
	@OneToMany(mappedBy="solucoe")
	private List<VulnerabilidadesFamiliar> vulnerabilidadesFamiliars;

	//bi-directional many-to-one association to VulnerabilidadesResponsavel
	@OneToMany(mappedBy="solucoe")
	private List<VulnerabilidadesResponsavel> vulnerabilidadesResponsavels;

	public Solucoe() {
	}

	public Long getIdSolucao() {
		return this.idSolucao;
	}

	public void setIdSolucao(Long idSolucao) {
		this.idSolucao = idSolucao;
	}

	public String getDsSolucao() {
		return this.dsSolucao;
	}

	public void setDsSolucao(String dsSolucao) {
		this.dsSolucao = dsSolucao;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setSolucoe(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setSolucoe(null);

		return atendimento;
	}

	public List<VulnerabilidadesAluno> getVulnerabilidadesAlunos() {
		return this.vulnerabilidadesAlunos;
	}

	public void setVulnerabilidadesAlunos(List<VulnerabilidadesAluno> vulnerabilidadesAlunos) {
		this.vulnerabilidadesAlunos = vulnerabilidadesAlunos;
	}

	public VulnerabilidadesAluno addVulnerabilidadesAluno(VulnerabilidadesAluno vulnerabilidadesAluno) {
		getVulnerabilidadesAlunos().add(vulnerabilidadesAluno);
		vulnerabilidadesAluno.setSolucoe(this);

		return vulnerabilidadesAluno;
	}

	public VulnerabilidadesAluno removeVulnerabilidadesAluno(VulnerabilidadesAluno vulnerabilidadesAluno) {
		getVulnerabilidadesAlunos().remove(vulnerabilidadesAluno);
		vulnerabilidadesAluno.setSolucoe(null);

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
		vulnerabilidadesFamiliar.setSolucoe(this);

		return vulnerabilidadesFamiliar;
	}

	public VulnerabilidadesFamiliar removeVulnerabilidadesFamiliar(VulnerabilidadesFamiliar vulnerabilidadesFamiliar) {
		getVulnerabilidadesFamiliars().remove(vulnerabilidadesFamiliar);
		vulnerabilidadesFamiliar.setSolucoe(null);

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
		vulnerabilidadesResponsavel.setSolucoe(this);

		return vulnerabilidadesResponsavel;
	}

	public VulnerabilidadesResponsavel removeVulnerabilidadesResponsavel(VulnerabilidadesResponsavel vulnerabilidadesResponsavel) {
		getVulnerabilidadesResponsavels().remove(vulnerabilidadesResponsavel);
		vulnerabilidadesResponsavel.setSolucoe(null);

		return vulnerabilidadesResponsavel;
	}

}