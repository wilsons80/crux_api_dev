package br.com.crux.to;

public class ModuloTO {

	private Long idModulo;
	private String descricao;
	private String nome;
	
	public ModuloTO() {
	}
	
	public ModuloTO(Long idModulo, String descricao, String nome) {
		super();
		this.idModulo = idModulo;
		this.descricao = descricao;
		this.nome = nome;
	}

	public Long getIdModulo() {
		return idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
