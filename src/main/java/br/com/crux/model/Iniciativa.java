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
 * The persistent class for the iniciativas database table.
 * 
 */
@Entity
@Table(name="iniciativas")
public class Iniciativa  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_iniciativa", unique=true, nullable=false, precision=10)
	private Long idIniciativa;

	@Column(name="ds_iniciativa", nullable=false, length=200)
	private String dsIniciativa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_iniciativa")
	private Date dtFimIniciativa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_iniciativa", nullable=false)
	private Date dtInicioIniciativa;

	//bi-directional many-to-one association to Meta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="metas_id_meta", nullable=false)
	private Meta meta;

	//bi-directional many-to-one association to PlanosAcao
	@OneToMany(mappedBy="iniciativa")
	private List<PlanosAcao> planosAcaos;

	//bi-directional many-to-one association to Programa
	@OneToMany(mappedBy="iniciativa")
	private List<Programa> programas;

	//bi-directional many-to-one association to Projeto
	@OneToMany(mappedBy="iniciativa")
	private List<Projeto> projetos;

	public Iniciativa() {
	}

	public Long getIdIniciativa() {
		return this.idIniciativa;
	}

	public void setIdIniciativa(Long idIniciativa) {
		this.idIniciativa = idIniciativa;
	}

	public String getDsIniciativa() {
		return this.dsIniciativa;
	}

	public void setDsIniciativa(String dsIniciativa) {
		this.dsIniciativa = dsIniciativa;
	}

	public Date getDtFimIniciativa() {
		return this.dtFimIniciativa;
	}

	public void setDtFimIniciativa(Date dtFimIniciativa) {
		this.dtFimIniciativa = dtFimIniciativa;
	}

	public Date getDtInicioIniciativa() {
		return this.dtInicioIniciativa;
	}

	public void setDtInicioIniciativa(Date dtInicioIniciativa) {
		this.dtInicioIniciativa = dtInicioIniciativa;
	}

	public Meta getMeta() {
		return this.meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<PlanosAcao> getPlanosAcaos() {
		return this.planosAcaos;
	}

	public void setPlanosAcaos(List<PlanosAcao> planosAcaos) {
		this.planosAcaos = planosAcaos;
	}

	public PlanosAcao addPlanosAcao(PlanosAcao planosAcao) {
		getPlanosAcaos().add(planosAcao);
		planosAcao.setIniciativa(this);

		return planosAcao;
	}

	public PlanosAcao removePlanosAcao(PlanosAcao planosAcao) {
		getPlanosAcaos().remove(planosAcao);
		planosAcao.setIniciativa(null);

		return planosAcao;
	}

	public List<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}

	public Programa addPrograma(Programa programa) {
		getProgramas().add(programa);
		programa.setIniciativa(this);

		return programa;
	}

	public Programa removePrograma(Programa programa) {
		getProgramas().remove(programa);
		programa.setIniciativa(null);

		return programa;
	}

	public List<Projeto> getProjetos() {
		return this.projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Projeto addProjeto(Projeto projeto) {
		getProjetos().add(projeto);
		projeto.setIniciativa(this);

		return projeto;
	}

	public Projeto removeProjeto(Projeto projeto) {
		getProjetos().remove(projeto);
		projeto.setIniciativa(null);

		return projeto;
	}

}