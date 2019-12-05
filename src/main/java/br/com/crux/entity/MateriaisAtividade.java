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
@Table(name="materiais_atividades")
public class MateriaisAtividade  {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_material_atividade")
	@SequenceGenerator(name = "sq_id_material_atividade", sequenceName = "sq_id_material_atividade", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_material_atividade")
	private Long id;

	@Column(name="ds_produto_atividade")
	private String descricao;

	@Column(name="tx_material_atividade")
	private String observacao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade")
	private Atividades atividade;
	
	@Column(name="dt_aquisicao")
	private LocalDateTime dataAquisicao;

	@Column(name="vl_material")
	private Double valorMaterial;

	@Column(name="dt_venda_material")
	private LocalDateTime dataVendaMaterial;
	
	@Column(name="ds_origem_material")
	private String descricaoOrigemMaterial;

	@Column(name="qtd_material")
	private Long qtdMaterial;
	
	@Column(name="qtd_material_vendida")
	private Long qtdMaterialVendida;

	
	@Column(name="ds_forma_pagamento")
	@Type(type = "br.com.crux.infra.dao.GenericEnumUserType", 
    parameters = { @Parameter(name = "enumClass", value = "br.com.crux.enums.FormaPagamento"),
    		       @Parameter(name = "keyName", value = "tipo")}) 
	private FormaPagamento formaPagamento;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_material")
	private Material material;

	@Column(name="id_usuario_apl")
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

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	
	

}