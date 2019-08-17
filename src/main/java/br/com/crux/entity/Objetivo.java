package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the objetivos database table.
 * 
 */
@Entity
@Table(name="objetivos")
@NamedQuery(name="Objetivo.findAll", query="SELECT o FROM Objetivo o")
public class Objetivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objetivo")
	private Long idObjetivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_implantacao")
	private Date dtImplantacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_termino")
	private Date dtTermino;

	@Column(name="nm_objetivo")
	private String nmObjetivo;

	//bi-directional many-to-one association to Indicadore
	@OneToMany(mappedBy="objetivo")
	private List<Indicadore> indicadores;

	//bi-directional many-to-one association to Perspectiva
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_perspectiva")
	private Perspectiva perspectiva;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}