package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the condicoes_moradia database table.
 * 
 */
@Entity
@Table(name="condicoes_moradia")
@NamedQuery(name="CondicoesMoradia.findAll", query="SELECT c FROM CondicoesMoradia c")
public class CondicoesMoradia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_condicao_moradia")
	private Long idCondicaoMoradia;

	@Column(name="ds_condicao_moradia")
	private String dsCondicaoMoradia;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	//bi-directional many-to-one association to PessoasFisica
	@OneToMany(mappedBy="condicoesMoradia")
	private List<PessoasFisica> pessoasFisicas;

	public CondicoesMoradia() {
	}

	public Long getIdCondicaoMoradia() {
		return this.idCondicaoMoradia;
	}

	public void setIdCondicaoMoradia(Long idCondicaoMoradia) {
		this.idCondicaoMoradia = idCondicaoMoradia;
	}

	public String getDsCondicaoMoradia() {
		return this.dsCondicaoMoradia;
	}

	public void setDsCondicaoMoradia(String dsCondicaoMoradia) {
		this.dsCondicaoMoradia = dsCondicaoMoradia;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

	public List<PessoasFisica> getPessoasFisicas() {
		return this.pessoasFisicas;
	}

	public void setPessoasFisicas(List<PessoasFisica> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}

	public PessoasFisica addPessoasFisica(PessoasFisica pessoasFisica) {
		getPessoasFisicas().add(pessoasFisica);
		pessoasFisica.setCondicoesMoradia(this);

		return pessoasFisica;
	}

	public PessoasFisica removePessoasFisica(PessoasFisica pessoasFisica) {
		getPessoasFisicas().remove(pessoasFisica);
		pessoasFisica.setCondicoesMoradia(null);

		return pessoasFisica;
	}

}