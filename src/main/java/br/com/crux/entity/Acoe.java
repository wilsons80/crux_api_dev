package br.com.crux.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.crux.constantes.Constantes;


/**
 * The persistent class for the acoes database table.
 * 
 */
@Entity
@Table(name="acoes")
public class Acoe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_acao")
	@SequenceGenerator(name = "sq_id_acao", sequenceName = "sq_id_acao", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_acao", unique=true, nullable=false, precision=10)
	private Long idAcao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim_acao")
	private Date dtFimAcao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio_acao")
	private Date dtInicioAcao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_prev_fim_acao")
	private Date dtPrevFimAcao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_prev_inicio_acao")
	private Date dtPrevInicioAcao;

	@Column(name="nm_plano_acao")
	private String nmPlanoAcao;

	//bi-directional many-to-one association to Atividade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="atividades_id_atividade")
	private Atividade atividade;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private UsuariosSistema usuariosSistema;

	public Acoe() {
	}

	public Long getIdAcao() {
		return this.idAcao;
	}

	public void setIdAcao(Long idAcao) {
		this.idAcao = idAcao;
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

	public Date getDtPrevFimAcao() {
		return this.dtPrevFimAcao;
	}

	public void setDtPrevFimAcao(Date dtPrevFimAcao) {
		this.dtPrevFimAcao = dtPrevFimAcao;
	}

	public Date getDtPrevInicioAcao() {
		return this.dtPrevInicioAcao;
	}

	public void setDtPrevInicioAcao(Date dtPrevInicioAcao) {
		this.dtPrevInicioAcao = dtPrevInicioAcao;
	}

	public String getNmPlanoAcao() {
		return this.nmPlanoAcao;
	}

	public void setNmPlanoAcao(String nmPlanoAcao) {
		this.nmPlanoAcao = nmPlanoAcao;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}