package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the questionarios database table.
 * 
 */
@Entity
@Table(name="questionarios")
public class Questionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_quetionario", unique=true, nullable=false, precision=10)
	private Long idQuetionario;

	@Column(name="ds_questionario", nullable=false, length=200)
	private String dsQuestionario;

	@Column(name="ds_tipo_questionario", length=1)
	private String dsTipoQuestionario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_questionario")
	private Date dtFimQuestionario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_questionario")
	private Date dtInicioQuestionario;

	//bi-directional many-to-one association to TalentosPf
	@OneToMany(mappedBy="questionario")
	private List<TalentosPf> talentosPfs;

	public Questionario() {
	}

	public Long getIdQuetionario() {
		return this.idQuetionario;
	}

	public void setIdQuetionario(Long idQuetionario) {
		this.idQuetionario = idQuetionario;
	}

	public String getDsQuestionario() {
		return this.dsQuestionario;
	}

	public void setDsQuestionario(String dsQuestionario) {
		this.dsQuestionario = dsQuestionario;
	}

	public String getDsTipoQuestionario() {
		return this.dsTipoQuestionario;
	}

	public void setDsTipoQuestionario(String dsTipoQuestionario) {
		this.dsTipoQuestionario = dsTipoQuestionario;
	}

	public Date getDtFimQuestionario() {
		return this.dtFimQuestionario;
	}

	public void setDtFimQuestionario(Date dtFimQuestionario) {
		this.dtFimQuestionario = dtFimQuestionario;
	}

	public Date getDtInicioQuestionario() {
		return this.dtInicioQuestionario;
	}

	public void setDtInicioQuestionario(Date dtInicioQuestionario) {
		this.dtInicioQuestionario = dtInicioQuestionario;
	}

	public List<TalentosPf> getTalentosPfs() {
		return this.talentosPfs;
	}

	public void setTalentosPfs(List<TalentosPf> talentosPfs) {
		this.talentosPfs = talentosPfs;
	}

	public TalentosPf addTalentosPf(TalentosPf talentosPf) {
		getTalentosPfs().add(talentosPf);
		talentosPf.setQuestionario(this);

		return talentosPf;
	}

	public TalentosPf removeTalentosPf(TalentosPf talentosPf) {
		getTalentosPfs().remove(talentosPf);
		talentosPf.setQuestionario(null);

		return talentosPf;
	}

}