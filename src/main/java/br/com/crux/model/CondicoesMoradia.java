package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the condicoes_moradia database table.
 * 
 */
@Entity
@Table(name="condicoes_moradia")
public class CondicoesMoradia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_condicao_moradia", unique=true, nullable=false, precision=10)
	private Long idCondicaoMoradia;

	@Column(name="ds_condicao_moradia", nullable=false, length=200)
	private String dsCondicaoMoradia;

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