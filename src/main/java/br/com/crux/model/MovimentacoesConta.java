package br.com.crux.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the movimentacoes_conta database table.
 * 
 */
@Entity
@Table(name="movimentacoes_conta")
public class MovimentacoesConta  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_mov_conta", unique=true, nullable=false, precision=10)
	private Long idMovConta;

	@Column(name="cs_tipo_mov_conta", length=1)
	private String csTipoMovConta;

	@Column(name="ds_mov_conta", length=200)
	private String dsMovConta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_efet_mov_conta")
	private Date dtEfetMovConta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_mov_conta")
	private Date dtMovConta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_saldo_mov_conta")
	private Date dtSaldoMovConta;

	@Column(name="vl_mov_conta", precision=10, scale=2)
	private BigDecimal vlMovConta;

	@Column(name="vl_saldo_mov_conta", precision=10, scale=2)
	private BigDecimal vlSaldoMovConta;

	//bi-directional many-to-one association to ContasBancaria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_conta_bancaria", nullable=false)
	private ContasBancaria contasBancaria;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario", nullable=false)
	private Funcionario funcionario;

	//bi-directional many-to-one association to PagamentosFatura
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pagamento_fatura", nullable=false)
	private PagamentosFatura pagamentosFatura;

	public MovimentacoesConta() {
	}

	public Long getIdMovConta() {
		return this.idMovConta;
	}

	public void setIdMovConta(Long idMovConta) {
		this.idMovConta = idMovConta;
	}

	public String getCsTipoMovConta() {
		return this.csTipoMovConta;
	}

	public void setCsTipoMovConta(String csTipoMovConta) {
		this.csTipoMovConta = csTipoMovConta;
	}

	public String getDsMovConta() {
		return this.dsMovConta;
	}

	public void setDsMovConta(String dsMovConta) {
		this.dsMovConta = dsMovConta;
	}

	public Date getDtEfetMovConta() {
		return this.dtEfetMovConta;
	}

	public void setDtEfetMovConta(Date dtEfetMovConta) {
		this.dtEfetMovConta = dtEfetMovConta;
	}

	public Date getDtMovConta() {
		return this.dtMovConta;
	}

	public void setDtMovConta(Date dtMovConta) {
		this.dtMovConta = dtMovConta;
	}

	public Date getDtSaldoMovConta() {
		return this.dtSaldoMovConta;
	}

	public void setDtSaldoMovConta(Date dtSaldoMovConta) {
		this.dtSaldoMovConta = dtSaldoMovConta;
	}

	public BigDecimal getVlMovConta() {
		return this.vlMovConta;
	}

	public void setVlMovConta(BigDecimal vlMovConta) {
		this.vlMovConta = vlMovConta;
	}

	public BigDecimal getVlSaldoMovConta() {
		return this.vlSaldoMovConta;
	}

	public void setVlSaldoMovConta(BigDecimal vlSaldoMovConta) {
		this.vlSaldoMovConta = vlSaldoMovConta;
	}

	public ContasBancaria getContasBancaria() {
		return this.contasBancaria;
	}

	public void setContasBancaria(ContasBancaria contasBancaria) {
		this.contasBancaria = contasBancaria;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public PagamentosFatura getPagamentosFatura() {
		return this.pagamentosFatura;
	}

	public void setPagamentosFatura(PagamentosFatura pagamentosFatura) {
		this.pagamentosFatura = pagamentosFatura;
	}

}