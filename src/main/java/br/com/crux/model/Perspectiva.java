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
 * The persistent class for the perspectivas database table.
 * 
 */
@Entity
@Table(name="perspectivas")
public class Perspectiva  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perspectiva", unique=true, nullable=false, precision=10)
	private Long idPerspectiva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_implantacao", nullable=false)
	private Date dtImplantacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_termino")
	private Date dtTermino;

	@Column(name="nm_perspectiva", nullable=false, length=200)
	private String nmPerspectiva;

	//bi-directional many-to-one association to Objetivo
	@OneToMany(mappedBy="perspectiva")
	private List<Objetivo> objetivos;

	//bi-directional many-to-one association to Entidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="entidades_id_entidade", nullable=false)
	private Entidade entidade;

	public Perspectiva() {
	}

	public Long getIdPerspectiva() {
		return this.idPerspectiva;
	}

	public void setIdPerspectiva(Long idPerspectiva) {
		this.idPerspectiva = idPerspectiva;
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

	public String getNmPerspectiva() {
		return this.nmPerspectiva;
	}

	public void setNmPerspectiva(String nmPerspectiva) {
		this.nmPerspectiva = nmPerspectiva;
	}

	public List<Objetivo> getObjetivos() {
		return this.objetivos;
	}

	public void setObjetivos(List<Objetivo> objetivos) {
		this.objetivos = objetivos;
	}

	public Objetivo addObjetivo(Objetivo objetivo) {
		getObjetivos().add(objetivo);
		objetivo.setPerspectiva(this);

		return objetivo;
	}

	public Objetivo removeObjetivo(Objetivo objetivo) {
		getObjetivos().remove(objetivo);
		objetivo.setPerspectiva(null);

		return objetivo;
	}

	public Entidade getEntidade() {
		return this.entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

}