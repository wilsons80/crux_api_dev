package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the produtos_atividades database table.
 * 
 */
@Entity
@Table(name="produtos_atividades")
public class ProdutosAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produto_atividade", unique=true, nullable=false, precision=10)
	private Long idProdutoAtividade;

	@Column(name="ds_forma_pagamento", length=1)
	private String dsFormaPagamento;

	@Column(name="ds_origem_produto", length=200)
	private String dsOrigemProduto;

	@Column(name="ds_produto_atividade", nullable=false, length=200)
	private String dsProdutoAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_aquisicao")
	private Date dtAquisicao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_venda_produto")
	private Date dtVendaProduto;

	@Column(name="qtd_produto", precision=10, scale=2)
	private BigDecimal qtdProduto;

	@Column(name="qtd_produto_vendida", precision=131089)
	private BigDecimal qtdProdutoVendida;

	@Column(name="tx_produto_atividade", length=200)
	private String txProdutoAtividade;

	@Column(name="vl_produto", precision=10, scale=2)
	private BigDecimal vlProduto;

	//bi-directional many-to-one association to Atividade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade", nullable=false)
	private Atividade atividade;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produto", nullable=false)
	private Produto produto;

	public ProdutosAtividade() {
	}

	public Long getIdProdutoAtividade() {
		return this.idProdutoAtividade;
	}

	public void setIdProdutoAtividade(Long idProdutoAtividade) {
		this.idProdutoAtividade = idProdutoAtividade;
	}

	public String getDsFormaPagamento() {
		return this.dsFormaPagamento;
	}

	public void setDsFormaPagamento(String dsFormaPagamento) {
		this.dsFormaPagamento = dsFormaPagamento;
	}

	public String getDsOrigemProduto() {
		return this.dsOrigemProduto;
	}

	public void setDsOrigemProduto(String dsOrigemProduto) {
		this.dsOrigemProduto = dsOrigemProduto;
	}

	public String getDsProdutoAtividade() {
		return this.dsProdutoAtividade;
	}

	public void setDsProdutoAtividade(String dsProdutoAtividade) {
		this.dsProdutoAtividade = dsProdutoAtividade;
	}

	public Date getDtAquisicao() {
		return this.dtAquisicao;
	}

	public void setDtAquisicao(Date dtAquisicao) {
		this.dtAquisicao = dtAquisicao;
	}

	public Date getDtVendaProduto() {
		return this.dtVendaProduto;
	}

	public void setDtVendaProduto(Date dtVendaProduto) {
		this.dtVendaProduto = dtVendaProduto;
	}

	public BigDecimal getQtdProduto() {
		return this.qtdProduto;
	}

	public void setQtdProduto(BigDecimal qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public BigDecimal getQtdProdutoVendida() {
		return this.qtdProdutoVendida;
	}

	public void setQtdProdutoVendida(BigDecimal qtdProdutoVendida) {
		this.qtdProdutoVendida = qtdProdutoVendida;
	}

	public String getTxProdutoAtividade() {
		return this.txProdutoAtividade;
	}

	public void setTxProdutoAtividade(String txProdutoAtividade) {
		this.txProdutoAtividade = txProdutoAtividade;
	}

	public BigDecimal getVlProduto() {
		return this.vlProduto;
	}

	public void setVlProduto(BigDecimal vlProduto) {
		this.vlProduto = vlProduto;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}