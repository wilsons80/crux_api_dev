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
 * The persistent class for the projetos database table.
 * 
 */
@Entity
@Table(name="projetos")
public class Projeto  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_projeto", unique=true, nullable=false, precision=10)
	private Long idProjeto;

	@Column(name="ds_projeto", length=200)
	private String dsProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_projeto")
	private Date dtFimProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_projeto")
	private Date dtInicioProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_prev_projeto", nullable=false)
	private Date dtPrevProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_prev_termino")
	private Date dtPrevTermino;

	@Column(name="nm_projeto", nullable=false, length=200)
	private String nmProjeto;

	//bi-directional many-to-one association to Atividade
	@OneToMany(mappedBy="projeto")
	private List<Atividade> atividades;

	//bi-directional many-to-one association to ColaboradoresProjeto
	@OneToMany(mappedBy="projeto")
	private List<ColaboradoresProjeto> colaboradoresProjetos;

	//bi-directional many-to-one association to Iniciativa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iniciativas_id_iniciativa")
	private Iniciativa iniciativa;

	//bi-directional many-to-one association to Programa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="programas_id_programa")
	private Programa programa;

	public Projeto() {
	}

	public Long getIdProjeto() {
		return this.idProjeto;
	}

	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getDsProjeto() {
		return this.dsProjeto;
	}

	public void setDsProjeto(String dsProjeto) {
		this.dsProjeto = dsProjeto;
	}

	public Date getDtFimProjeto() {
		return this.dtFimProjeto;
	}

	public void setDtFimProjeto(Date dtFimProjeto) {
		this.dtFimProjeto = dtFimProjeto;
	}

	public Date getDtInicioProjeto() {
		return this.dtInicioProjeto;
	}

	public void setDtInicioProjeto(Date dtInicioProjeto) {
		this.dtInicioProjeto = dtInicioProjeto;
	}

	public Date getDtPrevProjeto() {
		return this.dtPrevProjeto;
	}

	public void setDtPrevProjeto(Date dtPrevProjeto) {
		this.dtPrevProjeto = dtPrevProjeto;
	}

	public Date getDtPrevTermino() {
		return this.dtPrevTermino;
	}

	public void setDtPrevTermino(Date dtPrevTermino) {
		this.dtPrevTermino = dtPrevTermino;
	}

	public String getNmProjeto() {
		return this.nmProjeto;
	}

	public void setNmProjeto(String nmProjeto) {
		this.nmProjeto = nmProjeto;
	}

	public List<Atividade> getAtividades() {
		return this.atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Atividade addAtividade(Atividade atividade) {
		getAtividades().add(atividade);
		atividade.setProjeto(this);

		return atividade;
	}

	public Atividade removeAtividade(Atividade atividade) {
		getAtividades().remove(atividade);
		atividade.setProjeto(null);

		return atividade;
	}

	public List<ColaboradoresProjeto> getColaboradoresProjetos() {
		return this.colaboradoresProjetos;
	}

	public void setColaboradoresProjetos(List<ColaboradoresProjeto> colaboradoresProjetos) {
		this.colaboradoresProjetos = colaboradoresProjetos;
	}

	public ColaboradoresProjeto addColaboradoresProjeto(ColaboradoresProjeto colaboradoresProjeto) {
		getColaboradoresProjetos().add(colaboradoresProjeto);
		colaboradoresProjeto.setProjeto(this);

		return colaboradoresProjeto;
	}

	public ColaboradoresProjeto removeColaboradoresProjeto(ColaboradoresProjeto colaboradoresProjeto) {
		getColaboradoresProjetos().remove(colaboradoresProjeto);
		colaboradoresProjeto.setProjeto(null);

		return colaboradoresProjeto;
	}

	public Iniciativa getIniciativa() {
		return this.iniciativa;
	}

	public void setIniciativa(Iniciativa iniciativa) {
		this.iniciativa = iniciativa;
	}

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

}