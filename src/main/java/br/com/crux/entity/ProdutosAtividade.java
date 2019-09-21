package br.com.crux.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import br.com.crux.enums.FormaPagamento;
import br.com.crux.infra.constantes.Constantes;


@Entity
@Table(name="produtos_atividades")
public class ProdutosAtividade  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_produto_atividade")
	@SequenceGenerator(name = "sq_id_produto_atividade", sequenceName = "sq_id_produto_atividade", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_produto_atividade")
	private Long id;

	@Column(name="ds_produto_atividade")
	private String descricao;

	@Column(name="tx_produto_atividade")
	private String observacao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade")
	private Atividades atividade;
	
	@Column(name="dt_aquisicao")
	private LocalDateTime dataAquisicao;

	@Column(name="vl_produto")
	private Double valorProduto;

	@Column(name="dt_venda_produto")
	private LocalDateTime dataVendaProduto;
	
	@Column(name="ds_origem_produto")
	private String descricaoOrigemProduto;

	@Column(name="qtd_produto")
	private Long qtdProduto;
	
	@Column(name="qtd_produto_vendida")
	private Long qtdProdutoVendida;

	
	@Column(name="ds_forma_pagamento")
	@Type(type = "br.com.crux.infra.dao.GenericEnumUserType", 
    parameters = { @Parameter(name = "enumClass", value = "br.com.crux.enums.FormaPagamento") }) 
	private FormaPagamento formaPagamento;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produto")
	private Produto produto;

	@Column(name="id_usuario_apl")
	private Long usuarioAlteracao;

	public ProdutosAtividade() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Atividades getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividades atividade) {
		this.atividade = atividade;
	}

	public LocalDateTime getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(LocalDateTime dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public LocalDateTime getDataVendaProduto() {
		return dataVendaProduto;
	}

	public void setDataVendaProduto(LocalDateTime dataVendaProduto) {
		this.dataVendaProduto = dataVendaProduto;
	}

	public String getDescricaoOrigemProduto() {
		return descricaoOrigemProduto;
	}

	public void setDescricaoOrigemProduto(String descricaoOrigemProduto) {
		this.descricaoOrigemProduto = descricaoOrigemProduto;
	}

	public Long getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Long qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public Long getQtdProdutoVendida() {
		return qtdProdutoVendida;
	}

	public void setQtdProdutoVendida(Long qtdProdutoVendida) {
		this.qtdProdutoVendida = qtdProdutoVendida;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	

}