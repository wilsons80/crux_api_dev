package br.com.crux.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.crux.infra.constantes.Constantes;

@Entity
@Table(name="produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_produto")
	@SequenceGenerator(name = "sq_id_produto", sequenceName = "sq_id_produto", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_produto")
	private Long id;

	@Column(name="nm_produto")
	private String nome;
	
	@Column(name="cd_unidade_medida")
	private String codigoUnidadeMedida;

	@Column(name="ds_unidade_medida")
	private String descricaoUnidadeMedida;

	@Column(name="nm_produto_nf")
	private String nomeProdutoNatafiscal;

	@Column(name="id_usuario_apl")
	private Long usuarioAlteracao;

	public Produto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoUnidadeMedida() {
		return codigoUnidadeMedida;
	}

	public void setCodigoUnidadeMedida(String codigoUnidadeMedida) {
		this.codigoUnidadeMedida = codigoUnidadeMedida;
	}

	public String getDescricaoUnidadeMedida() {
		return descricaoUnidadeMedida;
	}

	public void setDescricaoUnidadeMedida(String descricaoUnidadeMedida) {
		this.descricaoUnidadeMedida = descricaoUnidadeMedida;
	}

	public String getNomeProdutoNatafiscal() {
		return nomeProdutoNatafiscal;
	}

	public void setNomeProdutoNatafiscal(String nomeProdutoNatafiscal) {
		this.nomeProdutoNatafiscal = nomeProdutoNatafiscal;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	
}