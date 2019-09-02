package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.crux.infra.constantes.Constantes;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the alunos database table.
 * 
 */
@Entity
@Table(name="alunos")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_aluno")
	@SequenceGenerator(name = "sq_id_aluno", sequenceName = "sq_id_aluno", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_aluno", unique=true, nullable=false, precision=10)
	private Long idAluno;

	@Column(name="ds_busca_escola")
	private String dsBuscaEscola;

	@Column(name="ds_desligamento")
	private String dsDesligamento;

	@Column(name="ds_forma_ingresso_entidade")
	private String dsFormaIngressoEntidade;

	@Column(name="ds_medicamentos_controlados")
	private String dsMedicamentosControlados;

	@Column(name="ds_outras_informacoes")
	private String dsOutrasInformacoes;

	@Column(name="ds_problema_saude")
	private String dsProblemaSaude;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_alteracao_cadastro")
	private Date dtAlteracaoCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_desligamento")
	private Date dtDesligamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_entrada")
	private Date dtEntrada;

	@Column(name="st_atendido_orgao_rede")
	private String stAtendidoOrgaoRede;

	@Column(name="st_matriculado_esc_pub")
	private String stMatriculadoEscPub;

	@Column(name="st_mora_pais")
	private String stMoraPais;

	@Column(name="st_pais_casados")
	private String stPaisCasados;

	@Column(name="st_publico_prioritario")
	private String stPublicoPrioritario;

	@Column(name="tx_observacoes")
	private String txObservacoes;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica")
	private PessoaFisica pessoasFisica;

	//bi-directional many-to-one association to Unidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade")
	private Unidade unidade;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_alteracao")
	private UsuariosSistema usuarioAlteracao;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_cadastro")
	private UsuariosSistema usuarioCadastro;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private UsuariosSistema usuario;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="aluno")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to AtividadesAluno
	@OneToMany(mappedBy="aluno")
	private List<AtividadesAluno> atividadesAlunos;

	//bi-directional many-to-one association to EncaminhaAluno
	@OneToMany(mappedBy="aluno")
	private List<EncaminhaAluno> encaminhaAlunos;

	//bi-directional many-to-one association to ReprovacoesAluno
	@OneToMany(mappedBy="aluno")
	private List<ReprovacoesAluno> reprovacoesAlunos;

	//bi-directional many-to-one association to ResponsaveisAluno
	@OneToMany(mappedBy="aluno")
	private List<ResponsaveisAluno> responsaveisAlunos;

	//bi-directional many-to-one association to VulnerabilidadesAluno
	@OneToMany(mappedBy="aluno")
	private List<VulnerabilidadesAluno> vulnerabilidadesAlunos;

	public Aluno() {
	}

	public Long getIdAluno() {
		return this.idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getDsBuscaEscola() {
		return this.dsBuscaEscola;
	}

	public void setDsBuscaEscola(String dsBuscaEscola) {
		this.dsBuscaEscola = dsBuscaEscola;
	}

	public String getDsDesligamento() {
		return this.dsDesligamento;
	}

	public void setDsDesligamento(String dsDesligamento) {
		this.dsDesligamento = dsDesligamento;
	}

	public String getDsFormaIngressoEntidade() {
		return this.dsFormaIngressoEntidade;
	}

	public void setDsFormaIngressoEntidade(String dsFormaIngressoEntidade) {
		this.dsFormaIngressoEntidade = dsFormaIngressoEntidade;
	}

	public String getDsMedicamentosControlados() {
		return this.dsMedicamentosControlados;
	}

	public void setDsMedicamentosControlados(String dsMedicamentosControlados) {
		this.dsMedicamentosControlados = dsMedicamentosControlados;
	}

	public String getDsOutrasInformacoes() {
		return this.dsOutrasInformacoes;
	}

	public void setDsOutrasInformacoes(String dsOutrasInformacoes) {
		this.dsOutrasInformacoes = dsOutrasInformacoes;
	}

	public String getDsProblemaSaude() {
		return this.dsProblemaSaude;
	}

	public void setDsProblemaSaude(String dsProblemaSaude) {
		this.dsProblemaSaude = dsProblemaSaude;
	}

	public Date getDtAlteracaoCadastro() {
		return this.dtAlteracaoCadastro;
	}

	public void setDtAlteracaoCadastro(Date dtAlteracaoCadastro) {
		this.dtAlteracaoCadastro = dtAlteracaoCadastro;
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

	public Date getDtEntrada() {
		return this.dtEntrada;
	}

	public void setDtEntrada(Date dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public String getStAtendidoOrgaoRede() {
		return this.stAtendidoOrgaoRede;
	}

	public void setStAtendidoOrgaoRede(String stAtendidoOrgaoRede) {
		this.stAtendidoOrgaoRede = stAtendidoOrgaoRede;
	}

	public String getStMatriculadoEscPub() {
		return this.stMatriculadoEscPub;
	}

	public void setStMatriculadoEscPub(String stMatriculadoEscPub) {
		this.stMatriculadoEscPub = stMatriculadoEscPub;
	}

	public String getStMoraPais() {
		return this.stMoraPais;
	}

	public void setStMoraPais(String stMoraPais) {
		this.stMoraPais = stMoraPais;
	}

	public String getStPaisCasados() {
		return this.stPaisCasados;
	}

	public void setStPaisCasados(String stPaisCasados) {
		this.stPaisCasados = stPaisCasados;
	}

	public String getStPublicoPrioritario() {
		return this.stPublicoPrioritario;
	}

	public void setStPublicoPrioritario(String stPublicoPrioritario) {
		this.stPublicoPrioritario = stPublicoPrioritario;
	}

	public String getTxObservacoes() {
		return this.txObservacoes;
	}

	public void setTxObservacoes(String txObservacoes) {
		this.txObservacoes = txObservacoes;
	}

	public PessoaFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoaFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public UsuariosSistema getUsuarioAlteracao() {
		return this.usuarioAlteracao;
	}

	public void setUsuarioAlteracao(UsuariosSistema usuariosSistema1) {
		this.usuarioAlteracao = usuariosSistema1;
	}

	public UsuariosSistema getUsuarioCadastro() {
		return this.usuarioCadastro;
	}

	public void setUsuarioCadastro(UsuariosSistema usuariosSistema2) {
		this.usuarioCadastro = usuariosSistema2;
	}

	public UsuariosSistema getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuariosSistema usuariosSistema3) {
		this.usuario = usuariosSistema3;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setAluno(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setAluno(null);

		return atendimento;
	}

	public List<AtividadesAluno> getAtividadesAlunos() {
		return this.atividadesAlunos;
	}

	public void setAtividadesAlunos(List<AtividadesAluno> atividadesAlunos) {
		this.atividadesAlunos = atividadesAlunos;
	}

	public AtividadesAluno addAtividadesAluno(AtividadesAluno atividadesAluno) {
		getAtividadesAlunos().add(atividadesAluno);
		atividadesAluno.setAluno(this);

		return atividadesAluno;
	}

	public AtividadesAluno removeAtividadesAluno(AtividadesAluno atividadesAluno) {
		getAtividadesAlunos().remove(atividadesAluno);
		atividadesAluno.setAluno(null);

		return atividadesAluno;
	}

	public List<EncaminhaAluno> getEncaminhaAlunos() {
		return this.encaminhaAlunos;
	}

	public void setEncaminhaAlunos(List<EncaminhaAluno> encaminhaAlunos) {
		this.encaminhaAlunos = encaminhaAlunos;
	}

	public EncaminhaAluno addEncaminhaAluno(EncaminhaAluno encaminhaAluno) {
		getEncaminhaAlunos().add(encaminhaAluno);
		encaminhaAluno.setAluno(this);

		return encaminhaAluno;
	}

	public EncaminhaAluno removeEncaminhaAluno(EncaminhaAluno encaminhaAluno) {
		getEncaminhaAlunos().remove(encaminhaAluno);
		encaminhaAluno.setAluno(null);

		return encaminhaAluno;
	}

	public List<ReprovacoesAluno> getReprovacoesAlunos() {
		return this.reprovacoesAlunos;
	}

	public void setReprovacoesAlunos(List<ReprovacoesAluno> reprovacoesAlunos) {
		this.reprovacoesAlunos = reprovacoesAlunos;
	}

	public ReprovacoesAluno addReprovacoesAluno(ReprovacoesAluno reprovacoesAluno) {
		getReprovacoesAlunos().add(reprovacoesAluno);
		reprovacoesAluno.setAluno(this);

		return reprovacoesAluno;
	}

	public ReprovacoesAluno removeReprovacoesAluno(ReprovacoesAluno reprovacoesAluno) {
		getReprovacoesAlunos().remove(reprovacoesAluno);
		reprovacoesAluno.setAluno(null);

		return reprovacoesAluno;
	}

	public List<ResponsaveisAluno> getResponsaveisAlunos() {
		return this.responsaveisAlunos;
	}

	public void setResponsaveisAlunos(List<ResponsaveisAluno> responsaveisAlunos) {
		this.responsaveisAlunos = responsaveisAlunos;
	}

	public ResponsaveisAluno addResponsaveisAluno(ResponsaveisAluno responsaveisAluno) {
		getResponsaveisAlunos().add(responsaveisAluno);
		responsaveisAluno.setAluno(this);

		return responsaveisAluno;
	}

	public ResponsaveisAluno removeResponsaveisAluno(ResponsaveisAluno responsaveisAluno) {
		getResponsaveisAlunos().remove(responsaveisAluno);
		responsaveisAluno.setAluno(null);

		return responsaveisAluno;
	}

	public List<VulnerabilidadesAluno> getVulnerabilidadesAlunos() {
		return this.vulnerabilidadesAlunos;
	}

	public void setVulnerabilidadesAlunos(List<VulnerabilidadesAluno> vulnerabilidadesAlunos) {
		this.vulnerabilidadesAlunos = vulnerabilidadesAlunos;
	}

	public VulnerabilidadesAluno addVulnerabilidadesAluno(VulnerabilidadesAluno vulnerabilidadesAluno) {
		getVulnerabilidadesAlunos().add(vulnerabilidadesAluno);
		vulnerabilidadesAluno.setAluno(this);

		return vulnerabilidadesAluno;
	}

	public VulnerabilidadesAluno removeVulnerabilidadesAluno(VulnerabilidadesAluno vulnerabilidadesAluno) {
		getVulnerabilidadesAlunos().remove(vulnerabilidadesAluno);
		vulnerabilidadesAluno.setAluno(null);

		return vulnerabilidadesAluno;
	}

}