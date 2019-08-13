package br.com.crux.dto;
// Generated 12/08/2019 22:11:24 by Hibernate Tools 5.3.0.Beta2

import java.util.Date;

/**
 * AcoesCompetencias generated by hbm2java
 */
public class AcoesCompetencias implements java.io.Serializable {

	private long idAcaoCompetencia;
	private TalentosPf talentosPf;
	private String dsQuestionario;
	private Date dtInicioAcao;
	private Date dtFimAcao;
	private String dsResultadoAcao;
	private String dsResultadoPrevAcao;

	public AcoesCompetencias() {
	}

	public AcoesCompetencias(long idAcaoCompetencia, TalentosPf talentosPf, String dsQuestionario) {
		this.idAcaoCompetencia = idAcaoCompetencia;
		this.talentosPf = talentosPf;
		this.dsQuestionario = dsQuestionario;
	}

	public AcoesCompetencias(long idAcaoCompetencia, TalentosPf talentosPf, String dsQuestionario, Date dtInicioAcao,
			Date dtFimAcao, String dsResultadoAcao, String dsResultadoPrevAcao) {
		this.idAcaoCompetencia = idAcaoCompetencia;
		this.talentosPf = talentosPf;
		this.dsQuestionario = dsQuestionario;
		this.dtInicioAcao = dtInicioAcao;
		this.dtFimAcao = dtFimAcao;
		this.dsResultadoAcao = dsResultadoAcao;
		this.dsResultadoPrevAcao = dsResultadoPrevAcao;
	}

	public long getIdAcaoCompetencia() {
		return this.idAcaoCompetencia;
	}

	public void setIdAcaoCompetencia(long idAcaoCompetencia) {
		this.idAcaoCompetencia = idAcaoCompetencia;
	}

	public TalentosPf getTalentosPf() {
		return this.talentosPf;
	}

	public void setTalentosPf(TalentosPf talentosPf) {
		this.talentosPf = talentosPf;
	}

	public String getDsQuestionario() {
		return this.dsQuestionario;
	}

	public void setDsQuestionario(String dsQuestionario) {
		this.dsQuestionario = dsQuestionario;
	}

	public Date getDtInicioAcao() {
		return this.dtInicioAcao;
	}

	public void setDtInicioAcao(Date dtInicioAcao) {
		this.dtInicioAcao = dtInicioAcao;
	}

	public Date getDtFimAcao() {
		return this.dtFimAcao;
	}

	public void setDtFimAcao(Date dtFimAcao) {
		this.dtFimAcao = dtFimAcao;
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

}
