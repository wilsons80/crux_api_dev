package br.com.crux.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
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


/**
 * The persistent class for the contas_bancarias database table.
 * 
 */
@Entity
@Table(name="contas_bancarias")
public class ContasBancaria  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_conta_bancaria", unique=true, nullable=false, precision=10)
	private Long idContaBancaria;

	@Column(name="cs_tipo_conta_bancaria", length=200)
	private String csTipoContaBancaria;

	@Column(name="nm_banco", length=200)
	private String nmBanco;

	@Column(name="nr_agencia", length=20)
	private String nrAgencia;

	@Column(name="nr_banco", precision=10, scale=2)
	private BigDecimal nrBanco;

	@Column(name="nr_conta_bancaria")
	private Timestamp nrContaBancaria;

	//bi-directional many-to-one association to Unidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade", nullable=false)
	private Unidade unidade;

	//bi-directional many-to-one association to MovimentacoesConta
	@OneToMany(mappedBy="contasBancaria")
	private List<MovimentacoesConta> movimentacoesContas;

	//bi-directional many-to-one association to PagamentosFatura
	@OneToMany(mappedBy="contasBancaria")
	private List<PagamentosFatura> pagamentosFaturas;

	public ContasBancaria() {
	}

	public Long getIdContaBancaria() {
		return this.idContaBancaria;
	}

	public void setIdContaBancaria(Long idContaBancaria) {
		this.idContaBancaria = idContaBancaria;
	}

	public String getCsTipoContaBancaria() {
		return this.csTipoContaBancaria;
	}

	public void setCsTipoContaBancaria(String csTipoContaBancaria) {
		this.csTipoContaBancaria = csTipoContaBancaria;
	}

	public String getNmBanco() {
		return this.nmBanco;
	}

	public void setNmBanco(String nmBanco) {
		this.nmBanco = nmBanco;
	}

	public String getNrAgencia() {
		return this.nrAgencia;
	}

	public void setNrAgencia(String nrAgencia) {
		this.nrAgencia = nrAgencia;
	}

	public BigDecimal getNrBanco() {
		return this.nrBanco;
	}

	public void setNrBanco(BigDecimal nrBanco) {
		this.nrBanco = nrBanco;
	}

	public Timestamp getNrContaBancaria() {
		return this.nrContaBancaria;
	}

	public void setNrContaBancaria(Timestamp nrContaBancaria) {
		this.nrContaBancaria = nrContaBancaria;
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
		movimentacoesConta.setContasBancaria(this);

		return movimentacoesConta;
	}

	public MovimentacoesConta removeMovimentacoesConta(MovimentacoesConta movimentacoesConta) {
		getMovimentacoesContas().remove(movimentacoesConta);
		movimentacoesConta.setContasBancaria(null);

		return movimentacoesConta;
	}

	public List<PagamentosFatura> getPagamentosFaturas() {
		return this.pagamentosFaturas;
	}

	public void setPagamentosFaturas(List<PagamentosFatura> pagamentosFaturas) {
		this.pagamentosFaturas = pagamentosFaturas;
	}

	public PagamentosFatura addPagamentosFatura(PagamentosFatura pagamentosFatura) {
		getPagamentosFaturas().add(pagamentosFatura);
		pagamentosFatura.setContasBancaria(this);

		return pagamentosFatura;
	}

	public PagamentosFatura removePagamentosFatura(PagamentosFatura pagamentosFatura) {
		getPagamentosFaturas().remove(pagamentosFatura);
		pagamentosFatura.setContasBancaria(null);

		return pagamentosFatura;
	}

}