package br.com.crux.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the situacoes_vulnerabilidades database table.
 * 
 */
@Entity
@Table(name="situacoes_vulnerabilidades")
public class SituacoesVulnerabilidade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vulnerabilidade")
	private Long id;

	@Column(name="ds_situacao_vulnerabilidade")
	private String descricao;

	@Column(name="id_usuario_apl")
	private Long usuarioAlteracao;

	public SituacoesVulnerabilidade() {
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

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}


}