package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the arquivos database table.
 * 
 */
@Entity
@Table(name="arquivos")
@NamedQuery(name="Arquivo.findAll", query="SELECT a FROM Arquivo a")
public class Arquivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_arquivo")
	private Long idArquivo;

	private byte[] blob;

	@Column(name="ds_tipo_arquivo")
	private String dsTipoArquivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_criacao")
	private Date dtCriacao;

	private String hash;

	@Column(name="nm_arquivo")
	private String nmArquivo;

	@Column(name="nr_tamanho_arquivo")
	private BigDecimal nrTamanhoArquivo;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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