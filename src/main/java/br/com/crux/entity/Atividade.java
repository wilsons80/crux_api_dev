package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the atividades database table.
 * 
 */
@Entity
@Table(name="atividades")
@NamedQuery(name="Atividade.findAll", query="SELECT a FROM Atividade a")
public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_atividade")
	private Long idAtividade;

	@Column(name="ds_atividade")
	private String dsAtividade;

	@Column(name="ds_local_execucao")
	private String dsLocalExecucao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_atividade")
	private Date dtFimAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_atividade")
	private Date dtInicioAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_prev_inicio")
	private Date dtPrevInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_prev_termino")
	private Date dtPrevTermino;

	@Column(name="hr_fim")
	private BigDecimal hrFim;

	@Column(name="hr_inicio")
	private BigDecimal hrInicio;

	@Column(name="nr_aulas")
	private BigDecimal nrAulas;

	@Column(name="nr_carga_horaria")
	private BigDecimal nrCargaHoraria;

	@Column(name="nr_maximo_participantes")
	private BigDecimal nrMaximoParticipantes;

	@Column(name="periodo_atividade")
	private BigDecimal periodoAtividade;

	@Column(name="st_domingo")
	private String stDomingo;

	@Column(name="st_horario_fixo")
	private String stHorarioFixo;

	@Column(name="st_local_execucao")
	private String stLocalExecucao;

	@Column(name="st_quarta")
	private String stQuarta;

	@Column(name="st_quinta")
	private String stQuinta;

	@Column(name="st_sabado")
	private String stSabado;

	@Column(name="st_segunda")
	private String stSegunda;

	@Column(name="st_sexta")
	private String stSexta;

	@Column(name="st_terca")
	private String stTerca;

	@Column(name="tx_observacoes")
	private String txObservacoes;

	@Column(name="vl_custo_atividade")
	private BigDecimal vlCustoAtividade;

	//bi-directional many-to-one association to Acoe
	@OneToMany(mappedBy="atividade")
	private List<Acoe> acoes;

	//bi-directional many-to-one association to PlanosAcao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="planos_acao_id_plano_acao")
	private PlanosAcao planosAcao;

	//bi-directional many-to-one association to Projeto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="projetos_id_projeto")
	private Projeto projeto;

	//bi-directional many-to-one association to Unidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unidades_id_unidade")
	private Unidade unidade;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	//bi-directional many-to-one association to AtividadesAluno
	@OneToMany(mappedBy="atividade")
	private List<AtividadesAluno> atividadesAlunos;

	//bi-directional many-to-one association to CadastroReservaAtividade
	@OneToMany(mappedBy="atividade")
	private List<CadastroReservaAtividade> cadastroReservaAtividades;

	//bi-directional many-to-one association to ColaboradoresAtividade
	@OneToMany(mappedBy="atividade")
	private List<ColaboradoresAtividade> colaboradoresAtividades;

	//bi-directional many-to-one association to DocumentosAtividade
	@OneToMany(mappedBy="atividade")
	private List<DocumentosAtividade> documentosAtividades;

	//bi-directional many-to-one association to ProdutosAtividade
	@OneToMany(mappedBy="atividade")
	private List<ProdutosAtividade> produtosAtividades;

	public Atividade() {
	}

	public Long getIdAtividade() {
		return this.idAtividade;
	}

	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}

	public String getDsAtividade() {
		return this.dsAtividade;
	}

	public void setDsAtividade(String dsAtividade) {
		this.dsAtividade = dsAtividade;
	}

	public String getDsLocalExecucao() {
		return this.dsLocalExecucao;
	}

	public void setDsLocalExecucao(String dsLocalExecucao) {
		this.dsLocalExecucao = dsLocalExecucao;
	}

	public Date getDtFimAtividade() {
		return this.dtFimAtividade;
	}

	public void setDtFimAtividade(Date dtFimAtividade) {
		this.dtFimAtividade = dtFimAtividade;
	}

	public Date getDtInicioAtividade() {
		return this.dtInicioAtividade;
	}

	public void setDtInicioAtividade(Date dtInicioAtividade) {
		this.dtInicioAtividade = dtInicioAtividade;
	}

	public Date getDtPrevInicio() {
		return this.dtPrevInicio;
	}

	public void setDtPrevInicio(Date dtPrevInicio) {
		this.dtPrevInicio = dtPrevInicio;
	}

	public Date getDtPrevTermino() {
		return this.dtPrevTermino;
	}

	public void setDtPrevTermino(Date dtPrevTermino) {
		this.dtPrevTermino = dtPrevTermino;
	}

	public BigDecimal getHrFim() {
		return this.hrFim;
	}

	public void setHrFim(BigDecimal hrFim) {
		this.hrFim = hrFim;
	}

	public BigDecimal getHrInicio() {
		return this.hrInicio;
	}

	public void setHrInicio(BigDecimal hrInicio) {
		this.hrInicio = hrInicio;
	}

	public BigDecimal getNrAulas() {
		return this.nrAulas;
	}

	public void setNrAulas(BigDecimal nrAulas) {
		this.nrAulas = nrAulas;
	}

	public BigDecimal getNrCargaHoraria() {
		return this.nrCargaHoraria;
	}

	public void setNrCargaHoraria(BigDecimal nrCargaHoraria) {
		this.nrCargaHoraria = nrCargaHoraria;
	}

	public BigDecimal getNrMaximoParticipantes() {
		return this.nrMaximoParticipantes;
	}

	public void setNrMaximoParticipantes(BigDecimal nrMaximoParticipantes) {
		this.nrMaximoParticipantes = nrMaximoParticipantes;
	}

	public BigDecimal getPeriodoAtividade() {
		return this.periodoAtividade;
	}

	public void setPeriodoAtividade(BigDecimal periodoAtividade) {
		this.periodoAtividade = periodoAtividade;
	}

	public String getStDomingo() {
		return this.stDomingo;
	}

	public void setStDomingo(String stDomingo) {
		this.stDomingo = stDomingo;
	}

	public String getStHorarioFixo() {
		return this.stHorarioFixo;
	}

	public void setStHorarioFixo(String stHorarioFixo) {
		this.stHorarioFixo = stHorarioFixo;
	}

	public String getStLocalExecucao() {
		return this.stLocalExecucao;
	}

	public void setStLocalExecucao(String stLocalExecucao) {
		this.stLocalExecucao = stLocalExecucao;
	}

	public String getStQuarta() {
		return this.stQuarta;
	}

	public void setStQuarta(String stQuarta) {
		this.stQuarta = stQuarta;
	}

	public String getStQuinta() {
		return this.stQuinta;
	}

	public void setStQuinta(String stQuinta) {
		this.stQuinta = stQuinta;
	}

	public String getStSabado() {
		return this.stSabado;
	}

	public void setStSabado(String stSabado) {
		this.stSabado = stSabado;
	}

	public String getStSegunda() {
		return this.stSegunda;
	}

	public void setStSegunda(String stSegunda) {
		this.stSegunda = stSegunda;
	}

	public String getStSexta() {
		return this.stSexta;
	}

	public void setStSexta(String stSexta) {
		this.stSexta = stSexta;
	}

	public String getStTerca() {
		return this.stTerca;
	}

	public void setStTerca(String stTerca) {
		this.stTerca = stTerca;
	}

	public String getTxObservacoes() {
		return this.txObservacoes;
	}

	public void setTxObservacoes(String txObservacoes) {
		this.txObservacoes = txObservacoes;
	}

	public BigDecimal getVlCustoAtividade() {
		return this.vlCustoAtividade;
	}

	public void setVlCustoAtividade(BigDecimal vlCustoAtividade) {
		this.vlCustoAtividade = vlCustoAtividade;
	}

	public List<Acoe> getAcoes() {
		return this.acoes;
	}

	public void setAcoes(List<Acoe> acoes) {
		this.acoes = acoes;
	}

	public Acoe addAcoe(Acoe acoe) {
		getAcoes().add(acoe);
		acoe.setAtividade(this);

		return acoe;
	}

	public Acoe removeAcoe(Acoe acoe) {
		getAcoes().remove(acoe);
		acoe.setAtividade(null);

		return acoe;
	}

	public PlanosAcao getPlanosAcao() {
		return this.planosAcao;
	}

	public void setPlanosAcao(PlanosAcao planosAcao) {
		this.planosAcao = planosAcao;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

	public List<AtividadesAluno> getAtividadesAlunos() {
		return this.atividadesAlunos;
	}

	public void setAtividadesAlunos(List<AtividadesAluno> atividadesAlunos) {
		this.atividadesAlunos = atividadesAlunos;
	}

	public AtividadesAluno addAtividadesAluno(AtividadesAluno atividadesAluno) {
		getAtividadesAlunos().add(atividadesAluno);
		atividadesAluno.setAtividade(this);

		return atividadesAluno;
	}

	public AtividadesAluno removeAtividadesAluno(AtividadesAluno atividadesAluno) {
		getAtividadesAlunos().remove(atividadesAluno);
		atividadesAluno.setAtividade(null);

		return atividadesAluno;
	}

	public List<CadastroReservaAtividade> getCadastroReservaAtividades() {
		return this.cadastroReservaAtividades;
	}

	public void setCadastroReservaAtividades(List<CadastroReservaAtividade> cadastroReservaAtividades) {
		this.cadastroReservaAtividades = cadastroReservaAtividades;
	}

	public CadastroReservaAtividade addCadastroReservaAtividade(CadastroReservaAtividade cadastroReservaAtividade) {
		getCadastroReservaAtividades().add(cadastroReservaAtividade);
		cadastroReservaAtividade.setAtividade(this);

		return cadastroReservaAtividade;
	}

	public CadastroReservaAtividade removeCadastroReservaAtividade(CadastroReservaAtividade cadastroReservaAtividade) {
		getCadastroReservaAtividades().remove(cadastroReservaAtividade);
		cadastroReservaAtividade.setAtividade(null);

		return cadastroReservaAtividade;
	}

	public List<ColaboradoresAtividade> getColaboradoresAtividades() {
		return this.colaboradoresAtividades;
	}

	public void setColaboradoresAtividades(List<ColaboradoresAtividade> colaboradoresAtividades) {
		this.colaboradoresAtividades = colaboradoresAtividades;
	}

	public ColaboradoresAtividade addColaboradoresAtividade(ColaboradoresAtividade colaboradoresAtividade) {
		getColaboradoresAtividades().add(colaboradoresAtividade);
		colaboradoresAtividade.setAtividade(this);

		return colaboradoresAtividade;
	}

	public ColaboradoresAtividade removeColaboradoresAtividade(ColaboradoresAtividade colaboradoresAtividade) {
		getColaboradoresAtividades().remove(colaboradoresAtividade);
		colaboradoresAtividade.setAtividade(null);

		return colaboradoresAtividade;
	}

	public List<DocumentosAtividade> getDocumentosAtividades() {
		return this.documentosAtividades;
	}

	public void setDocumentosAtividades(List<DocumentosAtividade> documentosAtividades) {
		this.documentosAtividades = documentosAtividades;
	}

	public DocumentosAtividade addDocumentosAtividade(DocumentosAtividade documentosAtividade) {
		getDocumentosAtividades().add(documentosAtividade);
		documentosAtividade.setAtividade(this);

		return documentosAtividade;
	}

	public DocumentosAtividade removeDocumentosAtividade(DocumentosAtividade documentosAtividade) {
		getDocumentosAtividades().remove(documentosAtividade);
		documentosAtividade.setAtividade(null);

		return documentosAtividade;
	}

	public List<ProdutosAtividade> getProdutosAtividades() {
		return this.produtosAtividades;
	}

	public void setProdutosAtividades(List<ProdutosAtividade> produtosAtividades) {
		this.produtosAtividades = produtosAtividades;
	}

	public ProdutosAtividade addProdutosAtividade(ProdutosAtividade produtosAtividade) {
		getProdutosAtividades().add(produtosAtividade);
		produtosAtividade.setAtividade(this);

		return produtosAtividade;
	}

	public ProdutosAtividade removeProdutosAtividade(ProdutosAtividade produtosAtividade) {
		getProdutosAtividades().remove(produtosAtividade);
		produtosAtividade.setAtividade(null);

		return produtosAtividade;
	}

}