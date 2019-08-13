package br.com.crux.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the objetivos database table.
 * 
 */
@Entity
@Table(name="objetivos")
public class Objetivo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objetivo", unique=true, nullable=false, precision=10)
	private Long idObjetivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_implantacao", nullable=false)
	private Date dtImplantacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_termino")
	private Date dtTermino;

	@Column(name="nm_objetivo", nullable=false, length=200)
	private String nmObjetivo;

	//bi-directional many-to-one association to Indicadore
	@OneToMany(mappedBy="objetivo")
	private List<Indicadore> indicadores;

	//bi-directional many-to-one association to Perspectiva
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_perspectiva", nullable=false)
	private Perspectiva perspectiva;

	public Objetivo() {
	}

	public Long getIdObjetivo() {
		return this.idObjetivo;
	}

	public void setIdObjetivo(Long idObjetivo) {
		this.idObjetivo = idObjetivo;
	}

	public Date getDtImplantacao() {
		return this.dtImplantacao;
	}

	public void setDtImplantacao(Date dtImplantacao) {
		this.dtImplantacao = dtImplantacao;
	}

	public Date getDtTermino() {
		return this.dtTermino;
	}

	public void setDtTermino(Date dtTermino) {
		this.dtTermino = dtTermino;
	}

	public String getNmObjetivo() {
		return this.nmObjetivo;
	}

	public void setNmObjetivo(String nmObjetivo) {
		this.nmObjetivo = nmObjetivo;
	}

	public List<Indicadore> getIndicadores() {
		return this.indicadores;
	}

	public void setIndicadores(List<Indicadore> indicadores) {
		this.indicadores = indicadores;
	}

	public Indicadore addIndicadore(Indicadore indicadore) {
		getIndicadores().add(indicadore);
		indicadore.setObjetivo(this);

		return indicadore;
	}

	public Indicadore removeIndicadore(Indicadore indicadore) {
		getIndicadores().remove(indicadore);
		indicadore.setObjetivo(null);

		return indicadore;
	}

	public Perspectiva getPerspectiva() {
		return this.perspectiva;
	}

	public void setPerspectiva(Perspectiva perspectiva) {
		this.perspectiva = perspectiva;
	}

}