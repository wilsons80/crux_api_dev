package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the acoes_competencias database table.
 * 
 */
@Entity
@Table(name="acoes_competencias")
public class AcoesCompetencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_acao_competencia", unique=true, nullable=false, precision=10)
	private Long idAcaoCompetencia;

	@Column(name="ds_questionario", nullable=false, length=200)
	private String dsQuestionario;

	@Column(name="ds_resultado_acao", length=200)
	private String dsResultadoAcao;

	@Column(name="ds_resultado_prev_acao", length=1)
	private String dsResultadoPrevAcao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_acao")
	private Date dtFimAcao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_acao")
	private Date dtInicioAcao;

	//bi-directional many-to-one association to TalentosPf
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="talentos_pf_id_talento_pf", nullable=false)
	private TalentosPf talentosPf;

	public AcoesCompetencia() {
	}

	public Long getIdAcaoCompetencia() {
		return this.idAcaoCompetencia;
	}

	public void setIdAcaoCompetencia(Long idAcaoCompetencia) {
		this.idAcaoCompetencia = idAcaoCompetencia;
	}

	public String getDsQuestionario() {
		return this.dsQuestionario;
	}

	public void setDsQuestionario(String dsQuestionario) {
		this.dsQuestionario = dsQuestionario;
	}

	public String getDsResultadoAcao() {
		return this.dsResultadoAcao;
	}

	public void setDsResultadoAcao(String dsResultadoAcao) {
		this.dsResultadoAcao = dsResultadoAcao;
	}

	public String getDsResultadoPrevAcao() {
		return this.dsResultadoPrevAcao;
	}

	public void setDsResultadoPrevAcao(String dsResultadoPrevAcao) {
		this.dsResultadoPrevAcao = dsResultadoPrevAcao;
	}

	public Date getDtFimAcao() {
		return this.dtFimAcao;
	}

	public void setDtFimAcao(Date dtFimAcao) {
		this.dtFimAcao = dtFimAcao;
	}

	public Date getDtInicioAcao() {
		return this.dtInicioAcao;
	}

	public void setDtInicioAcao(Date dtInicioAcao) {
		this.dtInicioAcao = dtInicioAcao;
	}

	public TalentosPf getTalentosPf() {
		return this.talentosPf;
	}

	public void setTalentosPf(TalentosPf talentosPf) {
		this.talentosPf = talentosPf;
	}

}