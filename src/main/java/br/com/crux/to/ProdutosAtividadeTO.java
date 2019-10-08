package br.com.crux.to;

import java.time.LocalDateTime;

public class ProdutosAtividadeTO {

	private Long id;
	private String descricao;
	private String observacao;
	private LocalDateTime dataAquisicao;
	private Double valorProduto;
	private LocalDateTime dataVendaProduto;
	private String descricaoOrigemProduto;
	private Long qtdProduto;
	private Long qtdProdutoVendida;
	private String formaPagamento;

	private AtividadesTO atividade;
	private ProdutoTO produto;

	private Long usuarioAlteracao;

	public ProdutosAtividadeTO() {
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

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public AtividadesTO getAtividade() {
		return atividade;
	}

	public void setAtividade(AtividadesTO atividade) {
		this.atividade = atividade;
	}

	public ProdutoTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoTO produto) {
		this.produto = produto;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

}
