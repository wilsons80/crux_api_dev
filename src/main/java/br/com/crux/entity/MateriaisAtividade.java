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

import br.com.crux.infra.constantes.Constantes;


@Entity
@Table(name="materiais_atividades")
public class MateriaisAtividade  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_material_atividade")
	@SequenceGenerator(name = "sq_id_material_atividade", sequenceName = "sq_id_material_atividade", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_material_programa")
	private Long id;

	@Column(name="id_atividade")
	private Long idAtividade ;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_material")
	private Material material;	
	
	@Column(name="tx_material_atividade")
	private String observacao;
	
	@Column(name="dt_aquisicao")
	private LocalDateTime dataAquisicao;
	
	@Column(name="vl_material")
	private Double valor;

	@Column(name="dt_venda_material")
	private LocalDateTime dataVenda;

	@Column(name="ds_origem_material")
	private String descricaoOrigem;
	
	@Column(name="qtd_material")
	private Long quantidadeOrigem;	
	
	@Column(name="qtd_material_vendida")
	private Long quantidadeVendida;	
	
	@Column(name="ds_forma_pagamento")
	private String formaPagamento;
	
	@Column(name="id_usuario_apl")
	private Long usuarioAlteracao;
	

	public MateriaisAtividade() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdAtividade() {
		return idAtividade;
	}


	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}


	public Material getMaterial() {
		return material;
	}


	public void setMaterial(Material material) {
		this.material = material;
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


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public LocalDateTime getDataVenda() {
		return dataVenda;
	}


	public void setDataVenda(LocalDateTime dataVenda) {
		this.dataVenda = dataVenda;
	}


	public String getDescricaoOrigem() {
		return descricaoOrigem;
	}


	public void setDescricaoOrigem(String descricaoOrigem) {
		this.descricaoOrigem = descricaoOrigem;
	}


	public Long getQuantidadeOrigem() {
		return quantidadeOrigem;
	}


	public void setQuantidadeOrigem(Long quantidadeOrigem) {
		this.quantidadeOrigem = quantidadeOrigem;
	}


	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}


	public void setQuantidadeVendida(Long quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}


	public String getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}


	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	


}