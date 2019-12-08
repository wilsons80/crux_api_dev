package br.com.crux.to;

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


public class MateriaisAtividadeTO  {

	private Long id;
	private Long idAtividade ;	
	private Material material;	
	private String observacao;
	private LocalDateTime dataAquisicao;
	private Double valor;
	private LocalDateTime dataVenda;
	private String descricaoOrigem;
	private Long quantidadeOrigem;	
	private Long quantidadeVendida;	
	private String formaPagamento;
	private Long usuarioAlteracao;
	

	public MateriaisAtividadeTO() {
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