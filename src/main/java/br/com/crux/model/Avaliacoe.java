package br.com.crux.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the avaliacoes database table.
 * 
 */
@Entity
@Table(name="avaliacoes")
public class Avaliacoe  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_avaliacao", unique=true, nullable=false, precision=10)
	private Long idAvaliacao;

	@Column(name="ds_avaliacao", length=200)
	private String dsAvaliacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_avaliacao")
	private Date dtFimAvaliacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_avaliacao")
	private Date dtInicioAvaliacao;

	@Column(name="nm_avaliacao", length=200)
	private String nmAvaliacao;

	//bi-directional many-to-one association to AvaliacoesAluno
	@OneToMany(mappedBy="avaliacoe")
	private List<AvaliacoesAluno> avaliacoesAlunos;

	public Avaliacoe() {
	}

	public Long getIdAvaliacao() {
		return this.idAvaliacao;
	}

	public void setIdAvaliacao(Long idAvaliacao) {
		this.idAvaliacao = idAvaliacao;
	}

	public String getDsAvaliacao() {
		return this.dsAvaliacao;
	}

	public void setDsAvaliacao(String dsAvaliacao) {
		this.dsAvaliacao = dsAvaliacao;
	}

	public Date getDtFimAvaliacao() {
		return this.dtFimAvaliacao;
	}

	public void setDtFimAvaliacao(Date dtFimAvaliacao) {
		this.dtFimAvaliacao = dtFimAvaliacao;
	}

	public Date getDtInicioAvaliacao() {
		return this.dtInicioAvaliacao;
	}

	public void setDtInicioAvaliacao(Date dtInicioAvaliacao) {
		this.dtInicioAvaliacao = dtInicioAvaliacao;
	}

	public String getNmAvaliacao() {
		return this.nmAvaliacao;
	}

	public void setNmAvaliacao(String nmAvaliacao) {
		this.nmAvaliacao = nmAvaliacao;
	}

	public List<AvaliacoesAluno> getAvaliacoesAlunos() {
		return this.avaliacoesAlunos;
	}

	public void setAvaliacoesAlunos(List<AvaliacoesAluno> avaliacoesAlunos) {
		this.avaliacoesAlunos = avaliacoesAlunos;
	}

	public AvaliacoesAluno addAvaliacoesAluno(AvaliacoesAluno avaliacoesAluno) {
		getAvaliacoesAlunos().add(avaliacoesAluno);
		avaliacoesAluno.setAvaliacoe(this);

		return avaliacoesAluno;
	}

	public AvaliacoesAluno removeAvaliacoesAluno(AvaliacoesAluno avaliacoesAluno) {
		getAvaliacoesAlunos().remove(avaliacoesAluno);
		avaliacoesAluno.setAvaliacoe(null);

		return avaliacoesAluno;
	}

}