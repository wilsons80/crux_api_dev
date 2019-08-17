package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the perspectivas database table.
 * 
 */
@Entity
@Table(name="perspectivas")
@NamedQuery(name="Perspectiva.findAll", query="SELECT p FROM Perspectiva p")
public class Perspectiva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perspectiva")
	private Long idPerspectiva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_implantacao")
	private Date dtImplantacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_termino")
	private Date dtTermino;

	@Column(name="nm_perspectiva")
	private String nmPerspectiva;

	//bi-directional many-to-one association to Objetivo
	@OneToMany(mappedBy="perspectiva")
	private List<Objetivo> objetivos;

	//bi-directional many-to-one association to Unidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade")
	private Unidade unidade;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}