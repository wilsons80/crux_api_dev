package br.com.crux.to;

import java.time.LocalDateTime;

public class MateriaisAtividadeTO {

	private Long id;
	private String descricao;
	private String observacao;
	private LocalDateTime dataAquisicao;
	private Double valorMaterial;
	private LocalDateTime dataVendaMaterial;
	private String descricaoOrigemMaterial;
	private Long qtdMaterial;
	private Long qtdMaterialVendida;
	private String formaPagamento;
	private AtividadesTO atividade;
	private MaterialTO material;
	private Long usuarioAlteracao;

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

	public Double getValorMaterial() {
		return valorMaterial;
	}

	public void setValorMaterial(Double valorMaterial) {
		this.valorMaterial = valorMaterial;
	}

	public LocalDateTime getDataVendaMaterial() {
		return dataVendaMaterial;
	}

	public void setDataVendaMaterial(LocalDateTime dataVendaMaterial) {
		this.dataVendaMaterial = dataVendaMaterial;
	}

	public String getDescricaoOrigemMaterial() {
		return descricaoOrigemMaterial;
	}

	public void setDescricaoOrigemMaterial(String descricaoOrigemMaterial) {
		this.descricaoOrigemMaterial = descricaoOrigemMaterial;
	}

	public Long getQtdMaterial() {
		return qtdMaterial;
	}

	public void setQtdMaterial(Long qtdMaterial) {
		this.qtdMaterial = qtdMaterial;
	}

	public Long getQtdMaterialVendida() {
		return qtdMaterialVendida;
	}

	public void setQtdMaterialVendida(Long qtdMaterialVendida) {
		this.qtdMaterialVendida = qtdMaterialVendida;
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

	public MaterialTO getMaterial() {
		return material;
	}

	public void setMaterial(MaterialTO material) {
		this.material = material;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

}
