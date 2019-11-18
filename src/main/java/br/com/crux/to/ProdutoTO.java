package br.com.crux.to;

public class ProdutoTO {

	private Long id;
	private String nome;
	private String codigoUnidadeMedida;
	private String descricaoUnidadeMedida;
	private String nomeProdutoNatafiscal;
	private Long usuarioAlteracao;

	public ProdutoTO() {
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
