package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the graus_instrucao database table.
 * 
 */
@Entity
@Table(name="graus_instrucao")
public class GrausInstrucao implements Serializable {
	private static final long serialVersionUID = 1L;

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