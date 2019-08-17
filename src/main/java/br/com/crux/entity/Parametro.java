package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the parametros database table.
 * 
 */
@Entity
@Table(name="parametros")
@NamedQuery(name="Parametro.findAll", query="SELECT p FROM Parametro p")
public class Parametro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_parametro")
	private Long idParametro;

	@Column(name="cd_parametro")
	private String cdParametro;

	@Column(name="ds_parametro")
	private String dsParametro;

	@Column(name="nr_paramentro")
	private BigDecimal nrParamentro;

	@Column(name="tx_parametro")
	private String txParametro;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}