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
 * The persistent class for the pagamentos_faturas database table.
 * 
 */
@Entity
@Table(name="pagamentos_faturas")
public class PagamentosFatura  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pagamento_fatura", unique=true, nullable=false, precision=10)
	private Long idPagamentoFatura;

	@Column(name="cs_tipo_pagamento", length=1)
	private String csTipoPagamento;

	@Column(name="ds_item_fatura", length=200)
	private String dsItemFatura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cheque_fatura")
	private Date dtChequeFatura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pagamento_fatura")
	private Date dtPagamentoFatura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_vencimento_fatura")
	private Date dtVencimentoFatura;

	@Column(name="nr_doc_pagamento_fatura", length=20)
	private String nrDocPagamentoFatura;

	@Column(name="nr_parcela_fatura", precision=10)
	private BigDecimal nrParcelaFatura;

	@Column(name="vl_fatura", precision=10, scale=2)
	private BigDecimal vlFatura;

	@Column(name="vl_pagamento_fatura", precision=10, scale=2)
	private BigDecimal vlPagamentoFatura;

	//bi-directional many-to-one association to MovimentacoesConta
	@OneToMany(mappedBy="pagamentosFatura")
	private List<MovimentacoesConta> movimentacoesContas;

	//bi-directional many-to-one association to ContasBancaria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_conta_bancaria", nullable=false)
	private ContasBancaria contasBancaria;

	//bi-directional many-to-one association to Fatura
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fatura", nullable=false)
	private Fatura fatura;

	public PagamentosFatura() {
	}

	public Long getIdPagamentoFatura() {
		return this.idPagamentoFatura;
	}

	public void setIdPagamentoFatura(Long idPagamentoFatura) {
		this.idPagamentoFatura = idPagamentoFatura;
	}

	public String getCsTipoPagamento() {
		return this.csTipoPagamento;
	}

	public void setCsTipoPagamento(String csTipoPagamento) {
		this.csTipoPagamento = csTipoPagamento;
	}

	public String getDsItemFatura() {
		return this.dsItemFatura;
	}

	public void setDsItemFatura(String dsItemFatura) {
		this.dsItemFatura = dsItemFatura;
	}

	public Date getDtChequeFatura() {
		return this.dtChequeFatura;
	}

	public void setDtChequeFatura(Date dtChequeFatura) {
		this.dtChequeFatura = dtChequeFatura;
	}

	public Date getDtPagamentoFatura() {
		return this.dtPagamentoFatura;
	}

	public void setDtPagamentoFatura(Date dtPagamentoFatura) {
		this.dtPagamentoFatura = dtPagamentoFatura;
	}

	public Date getDtVencimentoFatura() {
		return this.dtVencimentoFatura;
	}

	public void setDtVencimentoFatura(Date dtVencimentoFatura) {
		this.dtVencimentoFatura = dtVencimentoFatura;
	}

	public String getNrDocPagamentoFatura() {
		return this.nrDocPagamentoFatura;
	}

	public void setNrDocPagamentoFatura(String nrDocPagamentoFatura) {
		this.nrDocPagamentoFatura = nrDocPagamentoFatura;
	}

	public BigDecimal getNrParcelaFatura() {
		return this.nrParcelaFatura;
	}

	public void setNrParcelaFatura(BigDecimal nrParcelaFatura) {
		this.nrParcelaFatura = nrParcelaFatura;
	}

	public BigDecimal getVlFatura() {
		return this.vlFatura;
	}

	public void setVlFatura(BigDecimal vlFatura) {
		this.vlFatura = vlFatura;
	}

	public BigDecimal getVlPagamentoFatura() {
		return this.vlPagamentoFatura;
	}

	public void setVlPagamentoFatura(BigDecimal vlPagamentoFatura) {
		this.vlPagamentoFatura = vlPagamentoFatura;
	}

	public List<MovimentacoesConta> getMovimentacoesContas() {
		return this.movimentacoesContas;
	}

	public void setMovimentacoesContas(List<MovimentacoesConta> movimentacoesContas) {
		this.movimentacoesContas = movimentacoesContas;
	}

	public MovimentacoesConta addMovimentacoesConta(MovimentacoesConta movimentacoesConta) {
		getMovimentacoesContas().add(movimentacoesConta);
		movimentacoesConta.setPagamentosFatura(this);

		return movimentacoesConta;
	}

	public MovimentacoesConta removeMovimentacoesConta(MovimentacoesConta movimentacoesConta) {
		getMovimentacoesContas().remove(movimentacoesConta);
		movimentacoesConta.setPagamentosFatura(null);

		return movimentacoesConta;
	}

	public ContasBancaria getContasBancaria() {
		return this.contasBancaria;
	}

	public void setContasBancaria(ContasBancaria contasBancaria) {
		this.contasBancaria = contasBancaria;
	}

	public Fatura getFatura() {
		return this.fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

}