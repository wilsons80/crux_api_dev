package br.com.crux.dto;
// Generated 12/08/2019 22:11:24 by Hibernate Tools 5.3.0.Beta2

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * PagamentosFaturas generated by hbm2java
 */
public class PagamentosFaturas implements java.io.Serializable {

	private long idPagamentoFatura;
	private ContasBancarias contasBancarias;
	private Faturas faturas;
	private BigDecimal vlFatura;
	private Date dtVencimentoFatura;
	private Long nrParcelaFatura;
	private String dsItemFatura;
	private Date dtPagamentoFatura;
	private Date dtChequeFatura;
	private BigDecimal vlPagamentoFatura;
	private String nrDocPagamentoFatura;
	private String csTipoPagamento;
	private Set movimentacoesContas = new HashSet(0);

	public PagamentosFaturas() {
	}

	public PagamentosFaturas(long idPagamentoFatura, ContasBancarias contasBancarias, Faturas faturas) {
		this.idPagamentoFatura = idPagamentoFatura;
		this.contasBancarias = contasBancarias;
		this.faturas = faturas;
	}

	public PagamentosFaturas(long idPagamentoFatura, ContasBancarias contasBancarias, Faturas faturas,
			BigDecimal vlFatura, Date dtVencimentoFatura, Long nrParcelaFatura, String dsItemFatura,
			Date dtPagamentoFatura, Date dtChequeFatura, BigDecimal vlPagamentoFatura, String nrDocPagamentoFatura,
			String csTipoPagamento, Set movimentacoesContas) {
		this.idPagamentoFatura = idPagamentoFatura;
		this.contasBancarias = contasBancarias;
		this.faturas = faturas;
		this.vlFatura = vlFatura;
		this.dtVencimentoFatura = dtVencimentoFatura;
		this.nrParcelaFatura = nrParcelaFatura;
		this.dsItemFatura = dsItemFatura;
		this.dtPagamentoFatura = dtPagamentoFatura;
		this.dtChequeFatura = dtChequeFatura;
		this.vlPagamentoFatura = vlPagamentoFatura;
		this.nrDocPagamentoFatura = nrDocPagamentoFatura;
		this.csTipoPagamento = csTipoPagamento;
		this.movimentacoesContas = movimentacoesContas;
	}

	public long getIdPagamentoFatura() {
		return this.idPagamentoFatura;
	}

	public void setIdPagamentoFatura(long idPagamentoFatura) {
		this.idPagamentoFatura = idPagamentoFatura;
	}

	public ContasBancarias getContasBancarias() {
		return this.contasBancarias;
	}

	public void setContasBancarias(ContasBancarias contasBancarias) {
		this.contasBancarias = contasBancarias;
	}

	public Faturas getFaturas() {
		return this.faturas;
	}

	public void setFaturas(Faturas faturas) {
		this.faturas = faturas;
	}

	public BigDecimal getVlFatura() {
		return this.vlFatura;
	}

	public void setVlFatura(BigDecimal vlFatura) {
		this.vlFatura = vlFatura;
	}

	public Date getDtVencimentoFatura() {
		return this.dtVencimentoFatura;
	}

	public void setDtVencimentoFatura(Date dtVencimentoFatura) {
		this.dtVencimentoFatura = dtVencimentoFatura;
	}

	public Long getNrParcelaFatura() {
		return this.nrParcelaFatura;
	}

	public void setNrParcelaFatura(Long nrParcelaFatura) {
		this.nrParcelaFatura = nrParcelaFatura;
	}

	public String getDsItemFatura() {
		return this.dsItemFatura;
	}

	public void setDsItemFatura(String dsItemFatura) {
		this.dsItemFatura = dsItemFatura;
	}

	public Date getDtPagamentoFatura() {
		return this.dtPagamentoFatura;
	}

	public void setDtPagamentoFatura(Date dtPagamentoFatura) {
		this.dtPagamentoFatura = dtPagamentoFatura;
	}

	public Date getDtChequeFatura() {
		return this.dtChequeFatura;
	}

	public void setDtChequeFatura(Date dtChequeFatura) {
		this.dtChequeFatura = dtChequeFatura;
	}

	public BigDecimal getVlPagamentoFatura() {
		return this.vlPagamentoFatura;
	}

	public void setVlPagamentoFatura(BigDecimal vlPagamentoFatura) {
		this.vlPagamentoFatura = vlPagamentoFatura;
	}

	public String getNrDocPagamentoFatura() {
		return this.nrDocPagamentoFatura;
	}

	public void setNrDocPagamentoFatura(String nrDocPagamentoFatura) {
		this.nrDocPagamentoFatura = nrDocPagamentoFatura;
	}

	public String getCsTipoPagamento() {
		return this.csTipoPagamento;
	}

	public void setCsTipoPagamento(String csTipoPagamento) {
		this.csTipoPagamento = csTipoPagamento;
	}

	public Set getMovimentacoesContas() {
		return this.movimentacoesContas;
	}

	public void setMovimentacoesContas(Set movimentacoesContas) {
		this.movimentacoesContas = movimentacoesContas;
	}

}
