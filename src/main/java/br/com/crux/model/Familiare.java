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
 * The persistent class for the familiares database table.
 * 
 */
@Entity
@Table(name="familiares")
public class Familiare  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_familiar", unique=true, nullable=false, precision=10)
	private Long idFamiliar;

	@Column(name="ds_desligamento", length=200)
	private String dsDesligamento;

	@Column(name="ds_grau_parentesco", length=45)
	private String dsGrauParentesco;

	@Column(name="ds_outras_informacoes", length=200)
	private String dsOutrasInformacoes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro", nullable=false)
	private Date dtCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_desligamento")
	private Date dtDesligamento;

	@Column(name="st_situacao_parentesco", length=1)
	private String stSituacaoParentesco;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="familiare")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica", nullable=false)
	private PessoasFisica pessoasFisica;

	//bi-directional many-to-one association to Responsavei
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_responsavel", nullable=false)
	private Responsavei responsavei;

	//bi-directional many-to-one association to VulnerabilidadesFamiliar
	@OneToMany(mappedBy="familiare")
	private List<VulnerabilidadesFamiliar> vulnerabilidadesFamiliars;

	public Familiare() {
	}

	public Long getIdFamiliar() {
		return this.idFamiliar;
	}

	public void setIdFamiliar(Long idFamiliar) {
		this.idFamiliar = idFamiliar;
	}

	public String getDsDesligamento() {
		return this.dsDesligamento;
	}

	public void setDsDesligamento(String dsDesligamento) {
		this.dsDesligamento = dsDesligamento;
	}

	public String getDsGrauParentesco() {
		return this.dsGrauParentesco;
	}

	public void setDsGrauParentesco(String dsGrauParentesco) {
		this.dsGrauParentesco = dsGrauParentesco;
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

	public String getStSituacaoParentesco() {
		return this.stSituacaoParentesco;
	}

	public void setStSituacaoParentesco(String stSituacaoParentesco) {
		this.stSituacaoParentesco = stSituacaoParentesco;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setFamiliare(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setFamiliare(null);

		return atendimento;
	}

	public PessoasFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoasFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public Responsavei getResponsavei() {
		return this.responsavei;
	}

	public void setResponsavei(Responsavei responsavei) {
		this.responsavei = responsavei;
	}

	public List<VulnerabilidadesFamiliar> getVulnerabilidadesFamiliars() {
		return this.vulnerabilidadesFamiliars;
	}

	public void setVulnerabilidadesFamiliars(List<VulnerabilidadesFamiliar> vulnerabilidadesFamiliars) {
		this.vulnerabilidadesFamiliars = vulnerabilidadesFamiliars;
	}

	public VulnerabilidadesFamiliar addVulnerabilidadesFamiliar(VulnerabilidadesFamiliar vulnerabilidadesFamiliar) {
		getVulnerabilidadesFamiliars().add(vulnerabilidadesFamiliar);
		vulnerabilidadesFamiliar.setFamiliare(this);

		return vulnerabilidadesFamiliar;
	}

	public VulnerabilidadesFamiliar removeVulnerabilidadesFamiliar(VulnerabilidadesFamiliar vulnerabilidadesFamiliar) {
		getVulnerabilidadesFamiliars().remove(vulnerabilidadesFamiliar);
		vulnerabilidadesFamiliar.setFamiliare(null);

		return vulnerabilidadesFamiliar;
	}

}