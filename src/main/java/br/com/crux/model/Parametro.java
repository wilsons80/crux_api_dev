package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the parametros database table.
 * 
 */
@Entity
@Table(name="parametros")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_parametro", unique=true, nullable=false, precision=10)
	private Long idParametro;

	@Column(name="cd_parametro", length=100)
	private String cdParametro;

	@Column(name="ds_parametro", length=200)
	private String dsParametro;

	@Column(name="nr_paramentro", precision=24, scale=4)
	private BigDecimal nrParamentro;

	@Column(name="tx_parametro", length=2000)
	private String txParametro;

	public Parametro() {
	}

	public Long getIdParametro() {
		return this.idParametro;
	}

	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}

	public String getCdParametro() {
		return this.cdParametro;
	}

	public void setCdParametro(String cdParametro) {
		this.cdParametro = cdParametro;
	}

	public String getDsParametro() {
		return this.dsParametro;
	}

	public void setDsParametro(String dsParametro) {
		this.dsParametro = dsParametro;
	}

	public BigDecimal getNrParamentro() {
		return this.nrParamentro;
	}

	public void setNrParamentro(BigDecimal nrParamentro) {
		this.nrParamentro = nrParamentro;
	}

	public String getTxParametro() {
		return this.txParametro;
	}

	public void setTxParametro(String txParametro) {
		this.txParametro = txParametro;
	}

}