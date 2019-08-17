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
@NamedQuery(name="Solucoe.findAll", query="SELECT s FROM Solucoe s")
public class Solucoe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_solucao")
	private Long idSolucao;

	@Column(name="ds_solucao")
	private String dsSolucao;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="solucoe")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
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