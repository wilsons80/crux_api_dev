package br.com.crux.model;

import java.math.BigDecimal;
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
 * The persistent class for the atividades database table.
 * 
 */
@Entity
@Table(name="atividades")
public class Atividade  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_atividade", unique=true, nullable=false, precision=10)
	private Long idAtividade;

	@Column(name="ds_atividade", nullable=false, length=200)
	private String dsAtividade;

	@Column(name="ds_local_execucao", length=200)
	private String dsLocalExecucao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_atividade")
	private Date dtFimAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_atividade")
	private Date dtInicioAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_prev_inicio", nullable=false)
	private Date dtPrevInicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_prev_termino")
	private Date dtPrevTermino;

	@Column(name="hr_fim", precision=4)
	private BigDecimal hrFim;

	@Column(name="hr_inicio", precision=4)
	private BigDecimal hrInicio;

	@Column(name="nr_aulas", precision=10)
	private BigDecimal nrAulas;

	@Column(name="nr_carga_horaria", precision=131089)
	private BigDecimal nrCargaHoraria;

	@Column(name="nr_maximo_participantes", precision=131089)
	private BigDecimal nrMaximoParticipantes;

	@Column(name="periodo_atividade", precision=131089)
	private BigDecimal periodoAtividade;

	@Column(name="st_domingo", length=1)
	private String stDomingo;

	@Column(name="st_horario_fixo", length=1)
	private String stHorarioFixo;

	@Column(name="st_local_execucao", length=1)
	private String stLocalExecucao;

	@Column(name="st_quarta", length=1)
	private String stQuarta;

	@Column(name="st_quinta", length=1)
	private String stQuinta;

	@Column(name="st_sabado", length=1)
	private String stSabado;

	@Column(name="st_segunda", length=1)
	private String stSegunda;

	@Column(name="st_sexta", length=1)
	private String stSexta;

	@Column(name="st_terca", length=1)
	private String stTerca;

	@Column(name="tx_observacoes", length=200)
	private String txObservacoes;

	@Column(name="vl_custo_atividade", precision=10, scale=2)
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
	@JoinColumn(name="unidades_id_unidade", nullable=false)
	private Unidade unidade;

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