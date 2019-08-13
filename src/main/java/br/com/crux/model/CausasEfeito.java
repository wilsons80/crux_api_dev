package br.com.crux.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the causas_efeitos database table.
 * 
 */
@Entity
@Table(name="causas_efeitos")
public class CausasEfeito  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_causa_efeito", unique=true, nullable=false, precision=10)
	private Long idCausaEfeito;

	@Column(name="ds_causa_efeito", nullable=false, length=200)
	private String dsCausaEfeito;

	//bi-directional many-to-one association to Indicadore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_indicador", nullable=false)
	private Indicadore indicadore;

	public CausasEfeito() {
	}

	public Long getIdCausaEfeito() {
		return this.idCausaEfeito;
	}

	public void setIdCausaEfeito(Long idCausaEfeito) {
		this.idCausaEfeito = idCausaEfeito;
	}

	public String getDsCausaEfeito() {
		return this.dsCausaEfeito;
	}

	public void setDsCausaEfeito(String dsCausaEfeito) {
		this.dsCausaEfeito = dsCausaEfeito;
	}

	public Indicadore getIndicadore() {
		return this.indicadore;
	}

	public void setIndicadore(Indicadore indicadore) {
		this.indicadore = indicadore;
	}

}