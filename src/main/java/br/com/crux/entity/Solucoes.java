package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the solucoes database table.
 * 
 */
@Entity
@Table(name="solucoes")
public class Solucoes implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public Solucoes() {
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


	public List<VulnerabilidadesAluno> getVulnerabilidadesAlunos() {
		return this.vulnerabilidadesAlunos;
	}

	public void setVulnerabilidadesAlunos(List<VulnerabilidadesAluno> vulnerabilidadesAlunos) {
		this.vulnerabilidadesAlunos = vulnerabilidadesAlunos;
	}

	public List<VulnerabilidadesFamiliar> getVulnerabilidadesFamiliars() {
		return this.vulnerabilidadesFamiliars;
	}

	public void setVulnerabilidadesFamiliars(List<VulnerabilidadesFamiliar> vulnerabilidadesFamiliars) {
		this.vulnerabilidadesFamiliars = vulnerabilidadesFamiliars;
	}

	public List<VulnerabilidadesResponsavel> getVulnerabilidadesResponsavels() {
		return this.vulnerabilidadesResponsavels;
	}

	public void setVulnerabilidadesResponsavels(List<VulnerabilidadesResponsavel> vulnerabilidadesResponsavels) {
		this.vulnerabilidadesResponsavels = vulnerabilidadesResponsavels;
	}


}