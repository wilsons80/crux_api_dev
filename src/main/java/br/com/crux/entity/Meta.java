package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the metas database table.
 * 
 */
@Entity
@Table(name="metas")
@NamedQuery(name="Meta.findAll", query="SELECT m FROM Meta m")
public class Meta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_meta")
	private Long idMeta;

	@Column(name="ds_meta")
	private String dsMeta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_meta")
	private Date dtFimMeta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_meta")
	private Date dtInicioMeta;

	//bi-directional many-to-one association to Iniciativa
	@OneToMany(mappedBy="meta")
	private List<Iniciativa> iniciativas;

	//bi-directional many-to-one association to Indicadore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="indicadores_id_indicador")
	private Indicadores indicadore;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public Meta() {
	}

	public Long getIdMeta() {
		return this.idMeta;
	}

	public void setIdMeta(Long idMeta) {
		this.idMeta = idMeta;
	}

	public String getDsMeta() {
		return this.dsMeta;
	}

	public void setDsMeta(String dsMeta) {
		this.dsMeta = dsMeta;
	}

	public Date getDtFimMeta() {
		return this.dtFimMeta;
	}

	public void setDtFimMeta(Date dtFimMeta) {
		this.dtFimMeta = dtFimMeta;
	}

	public Date getDtInicioMeta() {
		return this.dtInicioMeta;
	}

	public void setDtInicioMeta(Date dtInicioMeta) {
		this.dtInicioMeta = dtInicioMeta;
	}

	public List<Iniciativa> getIniciativas() {
		return this.iniciativas;
	}

	public void setIniciativas(List<Iniciativa> iniciativas) {
		this.iniciativas = iniciativas;
	}

	public Iniciativa addIniciativa(Iniciativa iniciativa) {
		getIniciativas().add(iniciativa);
		iniciativa.setMeta(this);

		return iniciativa;
	}

	public Iniciativa removeIniciativa(Iniciativa iniciativa) {
		getIniciativas().remove(iniciativa);
		iniciativa.setMeta(null);

		return iniciativa;
	}

	public Indicadores getIndicadore() {
		return this.indicadore;
	}

	public void setIndicadore(Indicadores indicadore) {
		this.indicadore = indicadore;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}