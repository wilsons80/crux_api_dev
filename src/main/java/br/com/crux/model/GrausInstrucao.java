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
 * The persistent class for the graus_instrucao database table.
 * 
 */
@Entity
@Table(name="graus_instrucao")
public class GrausInstrucao  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_grau_instrucao", unique=true, nullable=false, precision=10)
	private Long idGrauInstrucao;

	@Column(name="ds_grau_instrucao", nullable=false, length=200)
	private String dsGrauInstrucao;

	//bi-directional many-to-one association to PessoasFisica
	@OneToMany(mappedBy="grausInstrucao")
	private List<PessoasFisica> pessoasFisicas;

	public GrausInstrucao() {
	}

	public Long getIdGrauInstrucao() {
		return this.idGrauInstrucao;
	}

	public void setIdGrauInstrucao(Long idGrauInstrucao) {
		this.idGrauInstrucao = idGrauInstrucao;
	}

	public String getDsGrauInstrucao() {
		return this.dsGrauInstrucao;
	}

	public void setDsGrauInstrucao(String dsGrauInstrucao) {
		this.dsGrauInstrucao = dsGrauInstrucao;
	}

	public List<PessoasFisica> getPessoasFisicas() {
		return this.pessoasFisicas;
	}

	public void setPessoasFisicas(List<PessoasFisica> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}

	public PessoasFisica addPessoasFisica(PessoasFisica pessoasFisica) {
		getPessoasFisicas().add(pessoasFisica);
		pessoasFisica.setGrausInstrucao(this);

		return pessoasFisica;
	}

	public PessoasFisica removePessoasFisica(PessoasFisica pessoasFisica) {
		getPessoasFisicas().remove(pessoasFisica);
		pessoasFisica.setGrausInstrucao(null);

		return pessoasFisica;
	}

}