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
 * The persistent class for the funcionarios database table.
 * 
 */
@Entity
@Table(name="funcionarios")
public class Funcionario  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_funcionario", unique=true, nullable=false, precision=10)
	private Long idFuncionario;

	@Column(name="ds_parecer_entrevistador", length=200)
	private String dsParecerEntrevistador;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_admissao", nullable=false)
	private Date dtAdmissao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_demissao")
	private Date dtDemissao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_hr_entrevista")
	private Date dtHrEntrevista;

	@Column(name="nr_matricula", nullable=false, length=15)
	private String nrMatricula;

	@Column(name="st_conclusao_parecer", length=1)
	private String stConclusaoParecer;

	@Column(name="st_parecer_entrevistador", length=1)
	private String stParecerEntrevistador;

	@Column(name="st_tipo_funcionario", length=1)
	private String stTipoFuncionario;

	@Column(name="vl_salario_pretendido", precision=10, scale=2)
	private BigDecimal vlSalarioPretendido;

	//bi-directional many-to-one association to Atendimento
	@OneToMany(mappedBy="funcionario")
	private List<Atendimento> atendimentos;

	//bi-directional many-to-one association to ColaboradoresAtividade
	@OneToMany(mappedBy="funcionario")
	private List<ColaboradoresAtividade> colaboradoresAtividades;

	//bi-directional many-to-one association to ColaboradoresPrograma
	@OneToMany(mappedBy="funcionario")
	private List<ColaboradoresPrograma> colaboradoresProgramas;

	//bi-directional many-to-one association to ColaboradoresProjeto
	@OneToMany(mappedBy="funcionario")
	private List<ColaboradoresProjeto> colaboradoresProjetos;

	//bi-directional many-to-one association to Estoque
	@OneToMany(mappedBy="funcionario")
	private List<Estoque> estoques;

	//bi-directional many-to-one association to FaltasFuncionario
	@OneToMany(mappedBy="funcionario1")
	private List<FaltasFuncionario> faltasFuncionarios1;

	//bi-directional many-to-one association to FaltasFuncionario
	@OneToMany(mappedBy="funcionario2")
	private List<FaltasFuncionario> faltasFuncionarios2;

	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cargo", nullable=false)
	private Cargo cargo;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_empresa_func", nullable=false)
	private Empresa empresa;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario_entrevistador")
	private Funcionario funcionario;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="funcionario")
	private List<Funcionario> funcionarios;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica", nullable=false)
	private PessoasFisica pessoasFisica;

	//bi-directional many-to-one association to Unidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade", nullable=false)
	private Unidade unidade;

	//bi-directional many-to-one association to MovimentacoesConta
	@OneToMany(mappedBy="funcionario")
	private List<MovimentacoesConta> movimentacoesContas;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="funcionario1")
	private List<Pedido> pedidos1;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="funcionario2")
	private List<Pedido> pedidos2;

	//bi-directional many-to-one association to TalentosPf
	@OneToMany(mappedBy="funcionario")
	private List<TalentosPf> talentosPfs;

	public Funcionario() {
	}

	public Long getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getDsParecerEntrevistador() {
		return this.dsParecerEntrevistador;
	}

	public void setDsParecerEntrevistador(String dsParecerEntrevistador) {
		this.dsParecerEntrevistador = dsParecerEntrevistador;
	}

	public Date getDtAdmissao() {
		return this.dtAdmissao;
	}

	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}

	public Date getDtDemissao() {
		return this.dtDemissao;
	}

	public void setDtDemissao(Date dtDemissao) {
		this.dtDemissao = dtDemissao;
	}

	public Date getDtHrEntrevista() {
		return this.dtHrEntrevista;
	}

	public void setDtHrEntrevista(Date dtHrEntrevista) {
		this.dtHrEntrevista = dtHrEntrevista;
	}

	public String getNrMatricula() {
		return this.nrMatricula;
	}

	public void setNrMatricula(String nrMatricula) {
		this.nrMatricula = nrMatricula;
	}

	public String getStConclusaoParecer() {
		return this.stConclusaoParecer;
	}

	public void setStConclusaoParecer(String stConclusaoParecer) {
		this.stConclusaoParecer = stConclusaoParecer;
	}

	public String getStParecerEntrevistador() {
		return this.stParecerEntrevistador;
	}

	public void setStParecerEntrevistador(String stParecerEntrevistador) {
		this.stParecerEntrevistador = stParecerEntrevistador;
	}

	public String getStTipoFuncionario() {
		return this.stTipoFuncionario;
	}

	public void setStTipoFuncionario(String stTipoFuncionario) {
		this.stTipoFuncionario = stTipoFuncionario;
	}

	public BigDecimal getVlSalarioPretendido() {
		return this.vlSalarioPretendido;
	}

	public void setVlSalarioPretendido(BigDecimal vlSalarioPretendido) {
		this.vlSalarioPretendido = vlSalarioPretendido;
	}

	public List<Atendimento> getAtendimentos() {
		return this.atendimentos;
	}

	public void setAtendimentos(List<Atendimento> atendimentos) {
		this.atendimentos = atendimentos;
	}

	public Atendimento addAtendimento(Atendimento atendimento) {
		getAtendimentos().add(atendimento);
		atendimento.setFuncionario(this);

		return atendimento;
	}

	public Atendimento removeAtendimento(Atendimento atendimento) {
		getAtendimentos().remove(atendimento);
		atendimento.setFuncionario(null);

		return atendimento;
	}

	public List<ColaboradoresAtividade> getColaboradoresAtividades() {
		return this.colaboradoresAtividades;
	}

	public void setColaboradoresAtividades(List<ColaboradoresAtividade> colaboradoresAtividades) {
		this.colaboradoresAtividades = colaboradoresAtividades;
	}

	public ColaboradoresAtividade addColaboradoresAtividade(ColaboradoresAtividade colaboradoresAtividade) {
		getColaboradoresAtividades().add(colaboradoresAtividade);
		colaboradoresAtividade.setFuncionario(this);

		return colaboradoresAtividade;
	}

	public ColaboradoresAtividade removeColaboradoresAtividade(ColaboradoresAtividade colaboradoresAtividade) {
		getColaboradoresAtividades().remove(colaboradoresAtividade);
		colaboradoresAtividade.setFuncionario(null);

		return colaboradoresAtividade;
	}

	public List<ColaboradoresPrograma> getColaboradoresProgramas() {
		return this.colaboradoresProgramas;
	}

	public void setColaboradoresProgramas(List<ColaboradoresPrograma> colaboradoresProgramas) {
		this.colaboradoresProgramas = colaboradoresProgramas;
	}

	public ColaboradoresPrograma addColaboradoresPrograma(ColaboradoresPrograma colaboradoresPrograma) {
		getColaboradoresProgramas().add(colaboradoresPrograma);
		colaboradoresPrograma.setFuncionario(this);

		return colaboradoresPrograma;
	}

	public ColaboradoresPrograma removeColaboradoresPrograma(ColaboradoresPrograma colaboradoresPrograma) {
		getColaboradoresProgramas().remove(colaboradoresPrograma);
		colaboradoresPrograma.setFuncionario(null);

		return colaboradoresPrograma;
	}

	public List<ColaboradoresProjeto> getColaboradoresProjetos() {
		return this.colaboradoresProjetos;
	}

	public void setColaboradoresProjetos(List<ColaboradoresProjeto> colaboradoresProjetos) {
		this.colaboradoresProjetos = colaboradoresProjetos;
	}

	public ColaboradoresProjeto addColaboradoresProjeto(ColaboradoresProjeto colaboradoresProjeto) {
		getColaboradoresProjetos().add(colaboradoresProjeto);
		colaboradoresProjeto.setFuncionario(this);

		return colaboradoresProjeto;
	}

	public ColaboradoresProjeto removeColaboradoresProjeto(ColaboradoresProjeto colaboradoresProjeto) {
		getColaboradoresProjetos().remove(colaboradoresProjeto);
		colaboradoresProjeto.setFuncionario(null);

		return colaboradoresProjeto;
	}

	public List<Estoque> getEstoques() {
		return this.estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque addEstoque(Estoque estoque) {
		getEstoques().add(estoque);
		estoque.setFuncionario(this);

		return estoque;
	}

	public Estoque removeEstoque(Estoque estoque) {
		getEstoques().remove(estoque);
		estoque.setFuncionario(null);

		return estoque;
	}

	public List<FaltasFuncionario> getFaltasFuncionarios1() {
		return this.faltasFuncionarios1;
	}

	public void setFaltasFuncionarios1(List<FaltasFuncionario> faltasFuncionarios1) {
		this.faltasFuncionarios1 = faltasFuncionarios1;
	}

	public FaltasFuncionario addFaltasFuncionarios1(FaltasFuncionario faltasFuncionarios1) {
		getFaltasFuncionarios1().add(faltasFuncionarios1);
		faltasFuncionarios1.setFuncionario1(this);

		return faltasFuncionarios1;
	}

	public FaltasFuncionario removeFaltasFuncionarios1(FaltasFuncionario faltasFuncionarios1) {
		getFaltasFuncionarios1().remove(faltasFuncionarios1);
		faltasFuncionarios1.setFuncionario1(null);

		return faltasFuncionarios1;
	}

	public List<FaltasFuncionario> getFaltasFuncionarios2() {
		return this.faltasFuncionarios2;
	}

	public void setFaltasFuncionarios2(List<FaltasFuncionario> faltasFuncionarios2) {
		this.faltasFuncionarios2 = faltasFuncionarios2;
	}

	public FaltasFuncionario addFaltasFuncionarios2(FaltasFuncionario faltasFuncionarios2) {
		getFaltasFuncionarios2().add(faltasFuncionarios2);
		faltasFuncionarios2.setFuncionario2(this);

		return faltasFuncionarios2;
	}

	public FaltasFuncionario removeFaltasFuncionarios2(FaltasFuncionario faltasFuncionarios2) {
		getFaltasFuncionarios2().remove(faltasFuncionarios2);
		faltasFuncionarios2.setFuncionario2(null);

		return faltasFuncionarios2;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario addFuncionario(Funcionario funcionario) {
		getFuncionarios().add(funcionario);
		funcionario.setFuncionario(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setFuncionario(null);

		return funcionario;
	}

	public PessoasFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoasFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public List<MovimentacoesConta> getMovimentacoesContas() {
		return this.movimentacoesContas;
	}

	public void setMovimentacoesContas(List<MovimentacoesConta> movimentacoesContas) {
		this.movimentacoesContas = movimentacoesContas;
	}

	public MovimentacoesConta addMovimentacoesConta(MovimentacoesConta movimentacoesConta) {
		getMovimentacoesContas().add(movimentacoesConta);
		movimentacoesConta.setFuncionario(this);

		return movimentacoesConta;
	}

	public MovimentacoesConta removeMovimentacoesConta(MovimentacoesConta movimentacoesConta) {
		getMovimentacoesContas().remove(movimentacoesConta);
		movimentacoesConta.setFuncionario(null);

		return movimentacoesConta;
	}

	public List<Pedido> getPedidos1() {
		return this.pedidos1;
	}

	public void setPedidos1(List<Pedido> pedidos1) {
		this.pedidos1 = pedidos1;
	}

	public Pedido addPedidos1(Pedido pedidos1) {
		getPedidos1().add(pedidos1);
		pedidos1.setFuncionario1(this);

		return pedidos1;
	}

	public Pedido removePedidos1(Pedido pedidos1) {
		getPedidos1().remove(pedidos1);
		pedidos1.setFuncionario1(null);

		return pedidos1;
	}

	public List<Pedido> getPedidos2() {
		return this.pedidos2;
	}

	public void setPedidos2(List<Pedido> pedidos2) {
		this.pedidos2 = pedidos2;
	}

	public Pedido addPedidos2(Pedido pedidos2) {
		getPedidos2().add(pedidos2);
		pedidos2.setFuncionario2(this);

		return pedidos2;
	}

	public Pedido removePedidos2(Pedido pedidos2) {
		getPedidos2().remove(pedidos2);
		pedidos2.setFuncionario2(null);

		return pedidos2;
	}

	public List<TalentosPf> getTalentosPfs() {
		return this.talentosPfs;
	}

	public void setTalentosPfs(List<TalentosPf> talentosPfs) {
		this.talentosPfs = talentosPfs;
	}

	public TalentosPf addTalentosPf(TalentosPf talentosPf) {
		getTalentosPfs().add(talentosPf);
		talentosPf.setFuncionario(this);

		return talentosPf;
	}

	public TalentosPf removeTalentosPf(TalentosPf talentosPf) {
		getTalentosPfs().remove(talentosPf);
		talentosPf.setFuncionario(null);

		return talentosPf;
	}

}