package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the pessoas_fisicas database table.
 * 
 */
@Entity
@Table(name="pessoas_fisicas")
public class PessoasFisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pessoa_fisica", unique=true, nullable=false, precision=10)
	private Long idPessoaFisica;

	@Column(name="cd_orgao_ci", length=45)
	private String cdOrgaoCi;

	@Column(name="cs_motivo_nao_trab", length=2)
	private String csMotivoNaoTrab;

	@Column(name="ds_atendido_orgao_rede", length=200)
	private String dsAtendidoOrgaoRede;

	@Column(name="ds_atendido_orgao_rede_1", length=200)
	private String dsAtendidoOrgaoRede1;

	@Column(name="ds_bairro", length=200)
	private String dsBairro;

	@Column(name="ds_cidade_naturalidade", length=200)
	private String dsCidadeNaturalidade;

	@Column(name="ds_condicao_moradia", length=200)
	private String dsCondicaoMoradia;

	@Column(name="ds_cor", length=45)
	private String dsCor;

	@Column(name="ds_curso_escola", length=200)
	private String dsCursoEscola;

	@Column(name="ds_email", length=100)
	private String dsEmail;

	@Column(name="ds_endereco", nullable=false, length=200)
	private String dsEndereco;

	@Column(name="ds_escola", length=200)
	private String dsEscola;

	@Column(name="ds_escolaridade", length=200)
	private String dsEscolaridade;

	@Column(name="ds_estado_civil", length=45)
	private String dsEstadoCivil;

	@Column(name="ds_forma_ingresso_entidade", length=200)
	private String dsFormaIngressoEntidade;

	@Column(name="ds_medicamentos_controlados", length=200)
	private String dsMedicamentosControlados;

	@Column(name="ds_motivo_nao_trab", length=200)
	private String dsMotivoNaoTrab;

	@Column(name="ds_nivel_escolaridade", length=200)
	private String dsNivelEscolaridade;

	@Column(name="ds_outros_ben_soc", length=200)
	private String dsOutrosBenSoc;

	@Column(name="ds_periodo_escola", length=200)
	private String dsPeriodoEscola;

	@Column(name="ds_ponto_referencia", length=200)
	private String dsPontoReferencia;

	@Column(name="ds_problema_saude", length=200)
	private String dsProblemaSaude;

	@Column(name="ds_profissao", length=100)
	private String dsProfissao;

	@Column(name="ds_rede_ap_soc_relev", length=200)
	private String dsRedeApSocRelev;

	@Column(name="ds_rede_apoio_social", length=200)
	private String dsRedeApoioSocial;

	@Column(name="ds_rede_apoio_social_1", length=1)
	private String dsRedeApoioSocial1;

	@Column(name="ds_regiao_escola", length=200)
	private String dsRegiaoEscola;

	@Column(name="ds_serie_escola", length=200)
	private String dsSerieEscola;

	@Column(name="ds_sexo", length=1)
	private String dsSexo;

	@Column(name="ds_situacao_trabalho", length=200)
	private String dsSituacaoTrabalho;

	@Column(name="ds_tipo_escola", length=200)
	private String dsTipoEscola;

	@Column(name="ds_turno", length=200)
	private String dsTurno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_nascimento")
	private Date dtNascimento;

	@Column(name="nm_empresa_trabalho", length=200)
	private String nmEmpresaTrabalho;

	@Column(name="nm_mae", length=200)
	private String nmMae;

	@Column(name="nm_pai", length=200)
	private String nmPai;

	@Column(name="nm_pessoa_fisica", nullable=false, length=255)
	private String nmPessoaFisica;

	@Column(name="nr_cep", precision=8)
	private BigDecimal nrCep;

	@Column(name="nr_ci", length=30)
	private String nrCi;

	@Column(name="nr_cpf", nullable=false, precision=11)
	private BigDecimal nrCpf;

	@Column(name="nr_cts", length=20)
	private String nrCts;

	@Column(name="nr_fone_celular", nullable=false, length=15)
	private String nrFoneCelular;

	@Column(name="nr_nis", length=200)
	private String nrNis;

	@Column(name="nr_serie_ctps", length=15)
	private String nrSerieCtps;

	@Column(name="nr_sessao_titulo", length=15)
	private String nrSessaoTitulo;

	@Column(name="nr_telefone_comercial", length=15)
	private String nrTelefoneComercial;

	@Column(name="nr_telefone_residencial", length=15)
	private String nrTelefoneResidencial;

	@Column(name="nr_titulo_eleitor", length=15)
	private String nrTituloEleitor;

	@Column(name="nr_zona_titulo", length=15)
	private String nrZonaTitulo;

	@Column(name="sg_uf_ci", length=2)
	private String sgUfCi;

	@Column(name="sg_uf_endereco", length=2)
	private String sgUfEndereco;

	@Column(name="sg_uf_nascimento", length=2)
	private String sgUfNascimento;

	@Column(name="st_atendido_orgao_rede", length=1)
	private String stAtendidoOrgaoRede;

	@Column(name="st_autoriza_email", length=1)
	private String stAutorizaEmail;

	@Column(name="st_ben_bolsa_familia", length=1)
	private String stBenBolsaFamilia;

	@Column(name="tx_observacoes", length=200)
	private String txObservacoes;

	@Column(name="vl_aluguel", precision=10, scale=2)
	private BigDecimal vlAluguel;

	@Column(name="vl_bolsa_familia", precision=10, scale=2)
	private BigDecimal vlBolsaFamilia;

	@Column(name="vl_outros_benerficios_soc", length=1500)
	private String vlOutrosBenerficiosSoc;

	@Column(name="vl_renda", precision=10, scale=2)
	private BigDecimal vlRenda;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="pessoasFisica")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to CadastroReservaAtividade
	@OneToMany(mappedBy="pessoasFisica")
	private List<CadastroReservaAtividade> cadastroReservaAtividades;

	//bi-directional many-to-one association to ContatosEmpresa
	@OneToMany(mappedBy="pessoasFisica")
	private List<ContatosEmpresa> contatosEmpresas;

	//bi-directional many-to-one association to CursosFormacaoPf
	@OneToMany(mappedBy="pessoasFisica")
	private List<CursosFormacaoPf> cursosFormacaoPfs;

	//bi-directional many-to-one association to Familiare
	@OneToMany(mappedBy="pessoasFisica")
	private List<Familiare> familiares;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="pessoasFisica")
	private List<Funcionario> funcionarios;

	//bi-directional many-to-one association to Arquivo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_arquivo_foto")
	private Arquivo arquivo;

	//bi-directional many-to-one association to CondicoesMoradia
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_condicao_moradia")
	private CondicoesMoradia condicoesMoradia;

	//bi-directional many-to-one association to GrausInstrucao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="graus_inscrucao_pf")
	private GrausInstrucao grausInstrucao;

	//bi-directional many-to-one association to Responsavei
	@OneToMany(mappedBy="pessoasFisica")
	private List<Responsaveis> responsaveis;

	//bi-directional many-to-one association to TalentosPf
	@OneToMany(mappedBy="pessoasFisica")
	private List<TalentosPf> talentosPfs;

	//bi-directional many-to-one association to UsuariosSistema
	@OneToMany(mappedBy="pessoasFisica")
	private List<UsuariosSistema> usuariosSistemas;

	public PessoasFisica() {
	}

	public Long getIdPessoaFisica() {
		return this.idPessoaFisica;
	}

	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}

	public String getCdOrgaoCi() {
		return this.cdOrgaoCi;
	}

	public void setCdOrgaoCi(String cdOrgaoCi) {
		this.cdOrgaoCi = cdOrgaoCi;
	}

	public String getCsMotivoNaoTrab() {
		return this.csMotivoNaoTrab;
	}

	public void setCsMotivoNaoTrab(String csMotivoNaoTrab) {
		this.csMotivoNaoTrab = csMotivoNaoTrab;
	}

	public String getDsAtendidoOrgaoRede() {
		return this.dsAtendidoOrgaoRede;
	}

	public void setDsAtendidoOrgaoRede(String dsAtendidoOrgaoRede) {
		this.dsAtendidoOrgaoRede = dsAtendidoOrgaoRede;
	}

	public String getDsAtendidoOrgaoRede1() {
		return this.dsAtendidoOrgaoRede1;
	}

	public void setDsAtendidoOrgaoRede1(String dsAtendidoOrgaoRede1) {
		this.dsAtendidoOrgaoRede1 = dsAtendidoOrgaoRede1;
	}

	public String getDsBairro() {
		return this.dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public String getDsCidadeNaturalidade() {
		return this.dsCidadeNaturalidade;
	}

	public void setDsCidadeNaturalidade(String dsCidadeNaturalidade) {
		this.dsCidadeNaturalidade = dsCidadeNaturalidade;
	}

	public String getDsCondicaoMoradia() {
		return this.dsCondicaoMoradia;
	}

	public void setDsCondicaoMoradia(String dsCondicaoMoradia) {
		this.dsCondicaoMoradia = dsCondicaoMoradia;
	}

	public String getDsCor() {
		return this.dsCor;
	}

	public void setDsCor(String dsCor) {
		this.dsCor = dsCor;
	}

	public String getDsCursoEscola() {
		return this.dsCursoEscola;
	}

	public void setDsCursoEscola(String dsCursoEscola) {
		this.dsCursoEscola = dsCursoEscola;
	}

	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
	}

	public String getDsEndereco() {
		return this.dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}

	public String getDsEscola() {
		return this.dsEscola;
	}

	public void setDsEscola(String dsEscola) {
		this.dsEscola = dsEscola;
	}

	public String getDsEscolaridade() {
		return this.dsEscolaridade;
	}

	public void setDsEscolaridade(String dsEscolaridade) {
		this.dsEscolaridade = dsEscolaridade;
	}

	public String getDsEstadoCivil() {
		return this.dsEstadoCivil;
	}

	public void setDsEstadoCivil(String dsEstadoCivil) {
		this.dsEstadoCivil = dsEstadoCivil;
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

	public String getDsMotivoNaoTrab() {
		return this.dsMotivoNaoTrab;
	}

	public void setDsMotivoNaoTrab(String dsMotivoNaoTrab) {
		this.dsMotivoNaoTrab = dsMotivoNaoTrab;
	}

	public String getDsNivelEscolaridade() {
		return this.dsNivelEscolaridade;
	}

	public void setDsNivelEscolaridade(String dsNivelEscolaridade) {
		this.dsNivelEscolaridade = dsNivelEscolaridade;
	}

	public String getDsOutrosBenSoc() {
		return this.dsOutrosBenSoc;
	}

	public void setDsOutrosBenSoc(String dsOutrosBenSoc) {
		this.dsOutrosBenSoc = dsOutrosBenSoc;
	}

	public String getDsPeriodoEscola() {
		return this.dsPeriodoEscola;
	}

	public void setDsPeriodoEscola(String dsPeriodoEscola) {
		this.dsPeriodoEscola = dsPeriodoEscola;
	}

	public String getDsPontoReferencia() {
		return this.dsPontoReferencia;
	}

	public void setDsPontoReferencia(String dsPontoReferencia) {
		this.dsPontoReferencia = dsPontoReferencia;
	}

	public String getDsProblemaSaude() {
		return this.dsProblemaSaude;
	}

	public void setDsProblemaSaude(String dsProblemaSaude) {
		this.dsProblemaSaude = dsProblemaSaude;
	}

	public String getDsProfissao() {
		return this.dsProfissao;
	}

	public void setDsProfissao(String dsProfissao) {
		this.dsProfissao = dsProfissao;
	}

	public String getDsRedeApSocRelev() {
		return this.dsRedeApSocRelev;
	}

	public void setDsRedeApSocRelev(String dsRedeApSocRelev) {
		this.dsRedeApSocRelev = dsRedeApSocRelev;
	}

	public String getDsRedeApoioSocial() {
		return this.dsRedeApoioSocial;
	}

	public void setDsRedeApoioSocial(String dsRedeApoioSocial) {
		this.dsRedeApoioSocial = dsRedeApoioSocial;
	}

	public String getDsRedeApoioSocial1() {
		return this.dsRedeApoioSocial1;
	}

	public void setDsRedeApoioSocial1(String dsRedeApoioSocial1) {
		this.dsRedeApoioSocial1 = dsRedeApoioSocial1;
	}

	public String getDsRegiaoEscola() {
		return this.dsRegiaoEscola;
	}

	public void setDsRegiaoEscola(String dsRegiaoEscola) {
		this.dsRegiaoEscola = dsRegiaoEscola;
	}

	public String getDsSerieEscola() {
		return this.dsSerieEscola;
	}

	public void setDsSerieEscola(String dsSerieEscola) {
		this.dsSerieEscola = dsSerieEscola;
	}

	public String getDsSexo() {
		return this.dsSexo;
	}

	public void setDsSexo(String dsSexo) {
		this.dsSexo = dsSexo;
	}

	public String getDsSituacaoTrabalho() {
		return this.dsSituacaoTrabalho;
	}

	public void setDsSituacaoTrabalho(String dsSituacaoTrabalho) {
		this.dsSituacaoTrabalho = dsSituacaoTrabalho;
	}

	public String getDsTipoEscola() {
		return this.dsTipoEscola;
	}

	public void setDsTipoEscola(String dsTipoEscola) {
		this.dsTipoEscola = dsTipoEscola;
	}

	public String getDsTurno() {
		return this.dsTurno;
	}

	public void setDsTurno(String dsTurno) {
		this.dsTurno = dsTurno;
	}

	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNmEmpresaTrabalho() {
		return this.nmEmpresaTrabalho;
	}

	public void setNmEmpresaTrabalho(String nmEmpresaTrabalho) {
		this.nmEmpresaTrabalho = nmEmpresaTrabalho;
	}

	public String getNmMae() {
		return this.nmMae;
	}

	public void setNmMae(String nmMae) {
		this.nmMae = nmMae;
	}

	public String getNmPai() {
		return this.nmPai;
	}

	public void setNmPai(String nmPai) {
		this.nmPai = nmPai;
	}

	public String getNmPessoaFisica() {
		return this.nmPessoaFisica;
	}

	public void setNmPessoaFisica(String nmPessoaFisica) {
		this.nmPessoaFisica = nmPessoaFisica;
	}

	public BigDecimal getNrCep() {
		return this.nrCep;
	}

	public void setNrCep(BigDecimal nrCep) {
		this.nrCep = nrCep;
	}

	public String getNrCi() {
		return this.nrCi;
	}

	public void setNrCi(String nrCi) {
		this.nrCi = nrCi;
	}

	public BigDecimal getNrCpf() {
		return this.nrCpf;
	}

	public void setNrCpf(BigDecimal nrCpf) {
		this.nrCpf = nrCpf;
	}

	public String getNrCts() {
		return this.nrCts;
	}

	public void setNrCts(String nrCts) {
		this.nrCts = nrCts;
	}

	public String getNrFoneCelular() {
		return this.nrFoneCelular;
	}

	public void setNrFoneCelular(String nrFoneCelular) {
		this.nrFoneCelular = nrFoneCelular;
	}

	public String getNrNis() {
		return this.nrNis;
	}

	public void setNrNis(String nrNis) {
		this.nrNis = nrNis;
	}

	public String getNrSerieCtps() {
		return this.nrSerieCtps;
	}

	public void setNrSerieCtps(String nrSerieCtps) {
		this.nrSerieCtps = nrSerieCtps;
	}

	public String getNrSessaoTitulo() {
		return this.nrSessaoTitulo;
	}

	public void setNrSessaoTitulo(String nrSessaoTitulo) {
		this.nrSessaoTitulo = nrSessaoTitulo;
	}

	public String getNrTelefoneComercial() {
		return this.nrTelefoneComercial;
	}

	public void setNrTelefoneComercial(String nrTelefoneComercial) {
		this.nrTelefoneComercial = nrTelefoneComercial;
	}

	public String getNrTelefoneResidencial() {
		return this.nrTelefoneResidencial;
	}

	public void setNrTelefoneResidencial(String nrTelefoneResidencial) {
		this.nrTelefoneResidencial = nrTelefoneResidencial;
	}

	public String getNrTituloEleitor() {
		return this.nrTituloEleitor;
	}

	public void setNrTituloEleitor(String nrTituloEleitor) {
		this.nrTituloEleitor = nrTituloEleitor;
	}

	public String getNrZonaTitulo() {
		return this.nrZonaTitulo;
	}

	public void setNrZonaTitulo(String nrZonaTitulo) {
		this.nrZonaTitulo = nrZonaTitulo;
	}

	public String getSgUfCi() {
		return this.sgUfCi;
	}

	public void setSgUfCi(String sgUfCi) {
		this.sgUfCi = sgUfCi;
	}

	public String getSgUfEndereco() {
		return this.sgUfEndereco;
	}

	public void setSgUfEndereco(String sgUfEndereco) {
		this.sgUfEndereco = sgUfEndereco;
	}

	public String getSgUfNascimento() {
		return this.sgUfNascimento;
	}

	public void setSgUfNascimento(String sgUfNascimento) {
		this.sgUfNascimento = sgUfNascimento;
	}

	public String getStAtendidoOrgaoRede() {
		return this.stAtendidoOrgaoRede;
	}

	public void setStAtendidoOrgaoRede(String stAtendidoOrgaoRede) {
		this.stAtendidoOrgaoRede = stAtendidoOrgaoRede;
	}

	public String getStAutorizaEmail() {
		return this.stAutorizaEmail;
	}

	public void setStAutorizaEmail(String stAutorizaEmail) {
		this.stAutorizaEmail = stAutorizaEmail;
	}

	public String getStBenBolsaFamilia() {
		return this.stBenBolsaFamilia;
	}

	public void setStBenBolsaFamilia(String stBenBolsaFamilia) {
		this.stBenBolsaFamilia = stBenBolsaFamilia;
	}

	public String getTxObservacoes() {
		return this.txObservacoes;
	}

	public void setTxObservacoes(String txObservacoes) {
		this.txObservacoes = txObservacoes;
	}

	public BigDecimal getVlAluguel() {
		return this.vlAluguel;
	}

	public void setVlAluguel(BigDecimal vlAluguel) {
		this.vlAluguel = vlAluguel;
	}

	public BigDecimal getVlBolsaFamilia() {
		return this.vlBolsaFamilia;
	}

	public void setVlBolsaFamilia(BigDecimal vlBolsaFamilia) {
		this.vlBolsaFamilia = vlBolsaFamilia;
	}

	public String getVlOutrosBenerficiosSoc() {
		return this.vlOutrosBenerficiosSoc;
	}

	public void setVlOutrosBenerficiosSoc(String vlOutrosBenerficiosSoc) {
		this.vlOutrosBenerficiosSoc = vlOutrosBenerficiosSoc;
	}

	public BigDecimal getVlRenda() {
		return this.vlRenda;
	}

	public void setVlRenda(BigDecimal vlRenda) {
		this.vlRenda = vlRenda;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setPessoasFisica(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setPessoasFisica(null);

		return aluno;
	}

	public List<CadastroReservaAtividade> getCadastroReservaAtividades() {
		return this.cadastroReservaAtividades;
	}

	public void setCadastroReservaAtividades(List<CadastroReservaAtividade> cadastroReservaAtividades) {
		this.cadastroReservaAtividades = cadastroReservaAtividades;
	}

	public CadastroReservaAtividade addCadastroReservaAtividade(CadastroReservaAtividade cadastroReservaAtividade) {
		getCadastroReservaAtividades().add(cadastroReservaAtividade);
		cadastroReservaAtividade.setPessoasFisica(this);

		return cadastroReservaAtividade;
	}

	public CadastroReservaAtividade removeCadastroReservaAtividade(CadastroReservaAtividade cadastroReservaAtividade) {
		getCadastroReservaAtividades().remove(cadastroReservaAtividade);
		cadastroReservaAtividade.setPessoasFisica(null);

		return cadastroReservaAtividade;
	}

	public List<ContatosEmpresa> getContatosEmpresas() {
		return this.contatosEmpresas;
	}

	public void setContatosEmpresas(List<ContatosEmpresa> contatosEmpresas) {
		this.contatosEmpresas = contatosEmpresas;
	}

	public ContatosEmpresa addContatosEmpresa(ContatosEmpresa contatosEmpresa) {
		getContatosEmpresas().add(contatosEmpresa);
		contatosEmpresa.setPessoasFisica(this);

		return contatosEmpresa;
	}

	public ContatosEmpresa removeContatosEmpresa(ContatosEmpresa contatosEmpresa) {
		getContatosEmpresas().remove(contatosEmpresa);
		contatosEmpresa.setPessoasFisica(null);

		return contatosEmpresa;
	}

	public List<CursosFormacaoPf> getCursosFormacaoPfs() {
		return this.cursosFormacaoPfs;
	}

	public void setCursosFormacaoPfs(List<CursosFormacaoPf> cursosFormacaoPfs) {
		this.cursosFormacaoPfs = cursosFormacaoPfs;
	}

	public CursosFormacaoPf addCursosFormacaoPf(CursosFormacaoPf cursosFormacaoPf) {
		getCursosFormacaoPfs().add(cursosFormacaoPf);
		cursosFormacaoPf.setPessoasFisica(this);

		return cursosFormacaoPf;
	}

	public CursosFormacaoPf removeCursosFormacaoPf(CursosFormacaoPf cursosFormacaoPf) {
		getCursosFormacaoPfs().remove(cursosFormacaoPf);
		cursosFormacaoPf.setPessoasFisica(null);

		return cursosFormacaoPf;
	}

	public List<Familiare> getFamiliares() {
		return this.familiares;
	}

	public void setFamiliares(List<Familiare> familiares) {
		this.familiares = familiares;
	}

	public Familiare addFamiliare(Familiare familiare) {
		getFamiliares().add(familiare);
		familiare.setPessoasFisica(this);

		return familiare;
	}

	public Familiare removeFamiliare(Familiare familiare) {
		getFamiliares().remove(familiare);
		familiare.setPessoasFisica(null);

		return familiare;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario addFuncionario(Funcionario funcionario) {
		getFuncionarios().add(funcionario);
		funcionario.setPessoasFisica(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setPessoasFisica(null);

		return funcionario;
	}

	public Arquivo getArquivo() {
		return this.arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public CondicoesMoradia getCondicoesMoradia() {
		return this.condicoesMoradia;
	}

	public void setCondicoesMoradia(CondicoesMoradia condicoesMoradia) {
		this.condicoesMoradia = condicoesMoradia;
	}

	public GrausInstrucao getGrausInstrucao() {
		return this.grausInstrucao;
	}

	public void setGrausInstrucao(GrausInstrucao grausInstrucao) {
		this.grausInstrucao = grausInstrucao;
	}

	public List<Responsaveis> getResponsaveis() {
		return this.responsaveis;
	}

	public void setResponsaveis(List<Responsaveis> responsaveis) {
		this.responsaveis = responsaveis;
	}

	public Responsaveis addResponsavei(Responsaveis responsavei) {
		getResponsaveis().add(responsavei);
		responsavei.setPessoasFisica(this);

		return responsavei;
	}

	public Responsaveis removeResponsavei(Responsaveis responsavei) {
		getResponsaveis().remove(responsavei);
		responsavei.setPessoasFisica(null);

		return responsavei;
	}

	public List<TalentosPf> getTalentosPfs() {
		return this.talentosPfs;
	}

	public void setTalentosPfs(List<TalentosPf> talentosPfs) {
		this.talentosPfs = talentosPfs;
	}

	public TalentosPf addTalentosPf(TalentosPf talentosPf) {
		getTalentosPfs().add(talentosPf);
		talentosPf.setPessoasFisica(this);

		return talentosPf;
	}

	public TalentosPf removeTalentosPf(TalentosPf talentosPf) {
		getTalentosPfs().remove(talentosPf);
		talentosPf.setPessoasFisica(null);

		return talentosPf;
	}

	public List<UsuariosSistema> getUsuariosSistemas() {
		return this.usuariosSistemas;
	}

	public void setUsuariosSistemas(List<UsuariosSistema> usuariosSistemas) {
		this.usuariosSistemas = usuariosSistemas;
	}

	public UsuariosSistema addUsuariosSistema(UsuariosSistema usuariosSistema) {
		getUsuariosSistemas().add(usuariosSistema);
		usuariosSistema.setPessoasFisica(this);

		return usuariosSistema;
	}

	public UsuariosSistema removeUsuariosSistema(UsuariosSistema usuariosSistema) {
		getUsuariosSistemas().remove(usuariosSistema);
		usuariosSistema.setPessoasFisica(null);

		return usuariosSistema;
	}

}