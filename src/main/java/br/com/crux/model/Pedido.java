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
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
public class Pedido  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pedido", unique=true, nullable=false, precision=10)
	private Long idPedido;

	@Column(name="ds_pedido", length=200)
	private String dsPedido;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_entrega")
	private Date dtEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_envio")
	private Date dtEnvio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido")
	private Date dtPedido;

	@Column(name="qtd_pedido", precision=10, scale=2)
	private BigDecimal qtdPedido;

	@Column(name="vl_pedido", precision=10, scale=2)
	private BigDecimal vlPedido;

	//bi-directional many-to-one association to ItensFatura
	@OneToMany(mappedBy="pedido")
	private List<ItensFatura> itensFaturas;

	//bi-directional many-to-one association to CentrosCusto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_centro_custo", nullable=false)
	private CentrosCusto centrosCusto;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario_rec_ped", nullable=false)
	private Funcionario funcionario1;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario_pedido", nullable=false)
	private Funcionario funcionario2;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produto")
	private Produto produto;

	//bi-directional many-to-one association to Servico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_servico")
	private Servico servico;

	//bi-directional many-to-one association to Unidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade", nullable=false)
	private Unidade unidade;

	public Pedido() {
	}

	public Long getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getDsPedido() {
		return this.dsPedido;
	}

	public void setDsPedido(String dsPedido) {
		this.dsPedido = dsPedido;
	}

	public Date getDtEntrega() {
		return this.dtEntrega;
	}

	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}

	public Date getDtEnvio() {
		return this.dtEnvio;
	}

	public void setDtEnvio(Date dtEnvio) {
		this.dtEnvio = dtEnvio;
	}

	public Date getDtPedido() {
		return this.dtPedido;
	}

	public void setDtPedido(Date dtPedido) {
		this.dtPedido = dtPedido;
	}

	public BigDecimal getQtdPedido() {
		return this.qtdPedido;
	}

	public void setQtdPedido(BigDecimal qtdPedido) {
		this.qtdPedido = qtdPedido;
	}

	public BigDecimal getVlPedido() {
		return this.vlPedido;
	}

	public void setVlPedido(BigDecimal vlPedido) {
		this.vlPedido = vlPedido;
	}

	public List<ItensFatura> getItensFaturas() {
		return this.itensFaturas;
	}

	public void setItensFaturas(List<ItensFatura> itensFaturas) {
		this.itensFaturas = itensFaturas;
	}

	public ItensFatura addItensFatura(ItensFatura itensFatura) {
		getItensFaturas().add(itensFatura);
		itensFatura.setPedido(this);

		return itensFatura;
	}

	public ItensFatura removeItensFatura(ItensFatura itensFatura) {
		getItensFaturas().remove(itensFatura);
		itensFatura.setPedido(null);

		return itensFatura;
	}

	public CentrosCusto getCentrosCusto() {
		return this.centrosCusto;
	}

	public void setCentrosCusto(CentrosCusto centrosCusto) {
		this.centrosCusto = centrosCusto;
	}

	public Funcionario getFuncionario1() {
		return this.funcionario1;
	}

	public void setFuncionario1(Funcionario funcionario1) {
		this.funcionario1 = funcionario1;
	}

	public Funcionario getFuncionario2() {
		return this.funcionario2;
	}

	public void setFuncionario2(Funcionario funcionario2) {
		this.funcionario2 = funcionario2;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

}