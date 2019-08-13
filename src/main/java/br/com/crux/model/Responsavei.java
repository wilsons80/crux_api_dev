package br.com.crux.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the responsaveis database table.
 * 
 */
@Entity
@Table(name="responsaveis")
public class Responsavei  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_responsavel", unique=true, nullable=false, precision=10)
	private Long idResponsavel;

	@Column(name="ds_desligamento", length=200)
	private String dsDesligamento;

	@Column(name="ds_outras_informacoes", length=200)
	private String dsOutrasInformacoes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro", nullable=false)
	private Date dtCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_desligamento")
	private Date dtDesligamento;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="responsavei")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to Familiare
	@OneToMany(mappedBy="responsavei")
	private List<Familiare> familiares;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica", nullable=false)
	private PessoasFisica pessoasFisica;

	//bi-directional many-to-one association to ResponsaveisAluno
	@OneToMany(mappedBy="responsavei")
	private List<ResponsaveisAluno> responsaveisAlunos;

	//bi-directional many-to-one association to VulnerabilidadesResponsavel
	@OneToMany(mappedBy="responsavei")
	private List<VulnerabilidadesResponsavel> vulnerabilidadesResponsavels;

	public Responsavei() {
	}

	public Long getIdResponsavel() {
		return this.idResponsavel;
	}

	public void setIdResponsavel(Long idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getDsDesligamento() {
		return this.dsDesligamento;
	}

	public void setDsDesligamento(String dsDesligamento) {
		this.dsDesligamento = dsDesligamento;
	}

	public String getDsOutrasInformacoes() {
		return this.dsOutrasInformacoes;
	}

	public void setDsOutrasInformacoes(String dsOutrasInformacoes) {
		this.dsOutrasInformacoes = dsOutrasInformacoes;
	}

	public Date getDtCadastro() {
		return this.dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtDesligamento() {
		return this.dtDesligamento;
	}

	public void setDtDesligamento(Date dtDesligamento) {
		this.dtDesligamento = dtDesligamento;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setResponsavei(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setResponsavei(null);

		return atendimento;
	}

	public List<Familiare> getFamiliares() {
		return this.familiares;
	}

	public void setFamiliares(List<Familiare> familiares) {
		this.familiares = familiares;
	}

	public Familiare addFamiliare(Familiare familiare) {
		getFamiliares().add(familiare);
		familiare.setResponsavei(this);

		return familiare;
	}

	public Familiare removeFamiliare(Familiare familiare) {
		getFamiliares().remove(familiare);
		familiare.setResponsavei(null);

		return familiare;
	}

	public PessoasFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoasFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public List<ResponsaveisAluno> getResponsaveisAlunos() {
		return this.responsaveisAlunos;
	}

	public void setResponsaveisAlunos(List<ResponsaveisAluno> responsaveisAlunos) {
		this.responsaveisAlunos = responsaveisAlunos;
	}

	public ResponsaveisAluno addResponsaveisAluno(ResponsaveisAluno responsaveisAluno) {
		getResponsaveisAlunos().add(responsaveisAluno);
		responsaveisAluno.setResponsavei(this);

		return responsaveisAluno;
	}

	public ResponsaveisAluno removeResponsaveisAluno(ResponsaveisAluno responsaveisAluno) {
		getResponsaveisAlunos().remove(responsaveisAluno);
		responsaveisAluno.setResponsavei(null);

		return responsaveisAluno;
	}

	public List<VulnerabilidadesResponsavel> getVulnerabilidadesResponsavels() {
		return this.vulnerabilidadesResponsavels;
	}

	public void setVulnerabilidadesResponsavels(List<VulnerabilidadesResponsavel> vulnerabilidadesResponsavels) {
		this.vulnerabilidadesResponsavels = vulnerabilidadesResponsavels;
	}

	public VulnerabilidadesResponsavel addVulnerabilidadesResponsavel(VulnerabilidadesResponsavel vulnerabilidadesResponsavel) {
		getVulnerabilidadesResponsavels().add(vulnerabilidadesResponsavel);
		vulnerabilidadesResponsavel.setResponsavei(this);

		return vulnerabilidadesResponsavel;
	}

	public VulnerabilidadesResponsavel removeVulnerabilidadesResponsavel(VulnerabilidadesResponsavel vulnerabilidadesResponsavel) {
		getVulnerabilidadesResponsavels().remove(vulnerabilidadesResponsavel);
		vulnerabilidadesResponsavel.setResponsavei(null);

		return vulnerabilidadesResponsavel;
	}

}