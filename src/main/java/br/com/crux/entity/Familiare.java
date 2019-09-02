package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the familiares database table.
 * 
 */
@Entity
@Table(name="familiares")
@NamedQuery(name="Familiare.findAll", query="SELECT f FROM Familiare f")
public class Familiare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_familiar")
	private Long idFamiliar;

	@Column(name="ds_desligamento")
	private String dsDesligamento;

	@Column(name="ds_grau_parentesco")
	private String dsGrauParentesco;

	@Column(name="ds_outras_informacoes")
	private String dsOutrasInformacoes;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_desligamento")
	private Date dtDesligamento;

	@Column(name="st_situacao_parentesco")
	private String stSituacaoParentesco;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="familiare")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica")
	private PessoaFisica pessoasFisica;

	//bi-directional many-to-one association to Responsavei
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_responsavel")
	private Responsaveis responsavei;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public PessoaFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoaFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public Responsaveis getResponsavei() {
		return this.responsavei;
	}

	public void setResponsavei(Responsaveis responsavei) {
		this.responsavei = responsavei;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
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