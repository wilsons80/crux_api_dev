package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the indicadores database table.
 * 
 */
@Entity
@Table(name="indicadores")
@NamedQuery(name="Indicadore.findAll", query="SELECT i FROM Indicadore i")
public class Indicadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_indicador")
	private Long idIndicador;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_indicador")
	private Date dtFimIndicador;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_indicador")
	private Date dtInicioIndicador;

	@Column(name="nm_indicador")
	private String nmIndicador;

	//bi-directional many-to-one association to CausasEfeito
	@OneToMany(mappedBy="indicadore")
	private List<CausasEfeito> causasEfeitos;

	//bi-directional many-to-one association to Objetivo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="objetivos_id_objetivo")
	private Objetivo objetivo;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	//bi-directional many-to-one association to Meta
	@OneToMany(mappedBy="indicadore")
	private List<Meta> metas;

	public Indicadore() {
	}

	public Long getIdIndicador() {
		return this.idIndicador;
	}

	public void setIdIndicador(Long idIndicador) {
		this.idIndicador = idIndicador;
	}

	public Date getDtFimIndicador() {
		return this.dtFimIndicador;
	}

	public void setDtFimIndicador(Date dtFimIndicador) {
		this.dtFimIndicador = dtFimIndicador;
	}

	public Date getDtInicioIndicador() {
		return this.dtInicioIndicador;
	}

	public void setDtInicioIndicador(Date dtInicioIndicador) {
		this.dtInicioIndicador = dtInicioIndicador;
	}

	public String getNmIndicador() {
		return this.nmIndicador;
	}

	public void setNmIndicador(String nmIndicador) {
		this.nmIndicador = nmIndicador;
	}

	public List<CausasEfeito> getCausasEfeitos() {
		return this.causasEfeitos;
	}

	public void setCausasEfeitos(List<CausasEfeito> causasEfeitos) {
		this.causasEfeitos = causasEfeitos;
	}

	public CausasEfeito addCausasEfeito(CausasEfeito causasEfeito) {
		getCausasEfeitos().add(causasEfeito);
		causasEfeito.setIndicadore(this);

		return causasEfeito;
	}

	public CausasEfeito removeCausasEfeito(CausasEfeito causasEfeito) {
		getCausasEfeitos().remove(causasEfeito);
		causasEfeito.setIndicadore(null);

		return causasEfeito;
	}

	public Objetivo getObjetivo() {
		return this.objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

	public List<Meta> getMetas() {
		return this.metas;
	}

	public void setMetas(List<Meta> metas) {
		this.metas = metas;
	}

	public Meta addMeta(Meta meta) {
		getMetas().add(meta);
		meta.setIndicadore(this);

		return meta;
	}

	public Meta removeMeta(Meta meta) {
		getMetas().remove(meta);
		meta.setIndicadore(null);

		return meta;
	}

}