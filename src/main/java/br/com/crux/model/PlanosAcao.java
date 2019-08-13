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
 * The persistent class for the planos_acao database table.
 * 
 */
@Entity
@Table(name="planos_acao")
public class PlanosAcao  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_plano_acao", unique=true, nullable=false, precision=10)
	private Long idPlanoAcao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_plano_acao")
	private Date dtFimPlanoAcao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_plano_acao", nullable=false)
	private Date dtInicioPlanoAcao;

	@Column(name="nm_plano_acao", nullable=false, length=200)
	private String nmPlanoAcao;

	//bi-directional many-to-one association to Atividade
	@OneToMany(mappedBy="planosAcao")
	private List<Atividade> atividades;

	//bi-directional many-to-one association to Iniciativa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iniciativas_id_iniciativa", nullable=false)
	private Iniciativa iniciativa;

	public PlanosAcao() {
	}

	public Long getIdPlanoAcao() {
		return this.idPlanoAcao;
	}

	public void setIdPlanoAcao(Long idPlanoAcao) {
		this.idPlanoAcao = idPlanoAcao;
	}

	public Date getDtFimPlanoAcao() {
		return this.dtFimPlanoAcao;
	}

	public void setDtFimPlanoAcao(Date dtFimPlanoAcao) {
		this.dtFimPlanoAcao = dtFimPlanoAcao;
	}

	public Date getDtInicioPlanoAcao() {
		return this.dtInicioPlanoAcao;
	}

	public void setDtInicioPlanoAcao(Date dtInicioPlanoAcao) {
		this.dtInicioPlanoAcao = dtInicioPlanoAcao;
	}

	public String getNmPlanoAcao() {
		return this.nmPlanoAcao;
	}

	public void setNmPlanoAcao(String nmPlanoAcao) {
		this.nmPlanoAcao = nmPlanoAcao;
	}

	public List<Atividade> getAtividades() {
		return this.atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Atividade addAtividade(Atividade atividade) {
		getAtividades().add(atividade);
		atividade.setPlanosAcao(this);

		return atividade;
	}

	public Atividade removeAtividade(Atividade atividade) {
		getAtividades().remove(atividade);
		atividade.setPlanosAcao(null);

		return atividade;
	}

	public Iniciativa getIniciativa() {
		return this.iniciativa;
	}

	public void setIniciativa(Iniciativa iniciativa) {
		this.iniciativa = iniciativa;
	}

}