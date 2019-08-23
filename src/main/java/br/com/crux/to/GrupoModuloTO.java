package br.com.crux.to;

public class GrupoModuloTO {
	
	private Long   idGrupo;
	private String nome;
	private String descricao;
	
	public GrupoModuloTO() {
	}
	
	public GrupoModuloTO(Long idGrupo, String nome, String descricao) {
		super();
		this.idGrupo = idGrupo;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public Long getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(Long idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
