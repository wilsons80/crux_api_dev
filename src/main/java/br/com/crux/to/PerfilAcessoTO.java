package br.com.crux.to;

public class PerfilAcessoTO {

	private Long id;
	private String nome;
	private Boolean altera;
	private Boolean consulta;
	private Boolean deleta;
	private Boolean insere;
	private Long usuarioAlteracao;

	public PerfilAcessoTO() {
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

	public Boolean getAltera() {
		return altera;
	}

	public void setAltera(Boolean altera) {
		this.altera = altera;
	}

	public Boolean getConsulta() {
		return consulta;
	}

	public void setConsulta(Boolean consulta) {
		this.consulta = consulta;
	}

	public Boolean getDeleta() {
		return deleta;
	}

	public void setDeleta(Boolean deleta) {
		this.deleta = deleta;
	}

	public Boolean getInsere() {
		return insere;
	}

	public void setInsere(Boolean insere) {
		this.insere = insere;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long idUsuarioAlteracao) {
		this.usuarioAlteracao = idUsuarioAlteracao;
	}

}
