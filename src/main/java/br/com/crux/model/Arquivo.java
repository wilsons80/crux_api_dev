package br.com.crux.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the arquivos database table.
 * 
 */
@Entity
@Table(name="arquivos")
public class Arquivo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_arquivo", unique=true, nullable=false, precision=10)
	private Long idArquivo;

	private byte[] blob;

	@Column(name="ds_tipo_arquivo", length=200)
	private String dsTipoArquivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_criacao")
	private Date dtCriacao;

	@Column(length=200)
	private String hash;

	@Column(name="nm_arquivo", nullable=false, length=200)
	private String nmArquivo;

	@Column(name="nr_tamanho_arquivo", precision=10, scale=2)
	private BigDecimal nrTamanhoArquivo;

	//bi-directional many-to-one association to Entidade
	@OneToMany(mappedBy="arquivo")
	private List<Entidade> entidades;

	//bi-directional many-to-one association to PessoasFisica
	@OneToMany(mappedBy="arquivo")
	private List<PessoasFisica> pessoasFisicas;

	//bi-directional many-to-one association to Unidade
	@OneToMany(mappedBy="arquivo")
	private List<Unidade> unidades;

	public Arquivo() {
	}

	public Long getIdArquivo() {
		return this.idArquivo;
	}

	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}

	public byte[] getBlob() {
		return this.blob;
	}

	public void setBlob(byte[] blob) {
		this.blob = blob;
	}

	public String getDsTipoArquivo() {
		return this.dsTipoArquivo;
	}

	public void setDsTipoArquivo(String dsTipoArquivo) {
		this.dsTipoArquivo = dsTipoArquivo;
	}

	public Date getDtCriacao() {
		return this.dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getNmArquivo() {
		return this.nmArquivo;
	}

	public void setNmArquivo(String nmArquivo) {
		this.nmArquivo = nmArquivo;
	}

	public BigDecimal getNrTamanhoArquivo() {
		return this.nrTamanhoArquivo;
	}

	public void setNrTamanhoArquivo(BigDecimal nrTamanhoArquivo) {
		this.nrTamanhoArquivo = nrTamanhoArquivo;
	}

	public List<Entidade> getEntidades() {
		return this.entidades;
	}

	public void setEntidades(List<Entidade> entidades) {
		this.entidades = entidades;
	}

	public Entidade addEntidade(Entidade entidade) {
		getEntidades().add(entidade);
		entidade.setArquivo(this);

		return entidade;
	}

	public Entidade removeEntidade(Entidade entidade) {
		getEntidades().remove(entidade);
		entidade.setArquivo(null);

		return entidade;
	}

	public List<PessoasFisica> getPessoasFisicas() {
		return this.pessoasFisicas;
	}

	public void setPessoasFisicas(List<PessoasFisica> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}

	public PessoasFisica addPessoasFisica(PessoasFisica pessoasFisica) {
		getPessoasFisicas().add(pessoasFisica);
		pessoasFisica.setArquivo(this);

		return pessoasFisica;
	}

	public PessoasFisica removePessoasFisica(PessoasFisica pessoasFisica) {
		getPessoasFisicas().remove(pessoasFisica);
		pessoasFisica.setArquivo(null);

		return pessoasFisica;
	}

	public List<Unidade> getUnidades() {
		return this.unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public Unidade addUnidade(Unidade unidade) {
		getUnidades().add(unidade);
		unidade.setArquivo(this);

		return unidade;
	}

	public Unidade removeUnidade(Unidade unidade) {
		getUnidades().remove(unidade);
		unidade.setArquivo(null);

		return unidade;
	}

}