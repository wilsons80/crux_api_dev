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
 * The persistent class for the metas database table.
 * 
 */
@Entity
@Table(name="metas")
public class Meta  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_meta", unique=true, nullable=false, precision=10)
	private Long idMeta;

	@Column(name="ds_meta", nullable=false, length=200)
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
	@JoinColumn(name="indicadores_id_indicador", nullable=false)
	private Indicadore indicadore;

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

	public Indicadore getIndicadore() {
		return this.indicadore;
	}

	public void setIndicadore(Indicadore indicadore) {
		this.indicadore = indicadore;
	}

}