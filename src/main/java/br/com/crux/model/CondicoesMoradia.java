package br.com.crux.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the condicoes_moradia database table.
 * 
 */
@Entity
@Table(name="condicoes_moradia")
public class CondicoesMoradia  {

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