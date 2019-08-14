package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the contatos_empresa database table.
 * 
 */
@Entity
@Table(name="contatos_empresa")
public class ContatosEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_contato_empresa", unique=true, nullable=false, precision=10)
	private Long idContatoEmpresa;

	@Column(name="ds_fim_contato", length=200)
	private String dsFimContato;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_contato")
	private Date dtFimContato;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_contato")
	private Date dtInicioContato;

	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cargo", nullable=false)
	private Cargo cargo;

	//bi-directional many-to-one association to Empresa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_empresa", nullable=false)
	private Empresa empresa;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica", nullable=false)
	private PessoasFisica pessoasFisica;

	public ContatosEmpresa() {
	}

	public Long getIdContatoEmpresa() {
		return this.idContatoEmpresa;
	}

	public void setIdContatoEmpresa(Long idContatoEmpresa) {
		this.idContatoEmpresa = idContatoEmpresa;
	}

	public String getDsFimContato() {
		return this.dsFimContato;
	}

	public void setDsFimContato(String dsFimContato) {
		this.dsFimContato = dsFimContato;
	}

	public Date getDtFimContato() {
		return this.dtFimContato;
	}

	public void setDtFimContato(Date dtFimContato) {
		this.dtFimContato = dtFimContato;
	}

	public Date getDtInicioContato() {
		return this.dtInicioContato;
	}

	public void setDtInicioContato(Date dtInicioContato) {
		this.dtInicioContato = dtInicioContato;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public PessoasFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoasFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

}