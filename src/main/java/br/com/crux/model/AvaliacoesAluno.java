package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the avaliacoes_alunos database table.
 * 
 */
@Entity
@Table(name="avaliacoes_alunos")
public class AvaliacoesAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_avaliacao_aluno", unique=true, nullable=false, precision=10)
	private Long idAvaliacaoAluno;

	@Column(name="ds_avaliacao_aluno", length=200)
	private String dsAvaliacaoAluno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_avaliacao_aluno")
	private Date dtAvaliacaoAluno;

	@Column(name="nr_avaliacao", length=1)
	private String nrAvaliacao;

	//bi-directional many-to-one association to AtividadesAluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade_aluno", nullable=false)
	private AtividadesAluno atividadesAluno;

	//bi-directional many-to-one association to Avaliacoe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_avaliacao", nullable=false)
	private Avaliacoe avaliacoe;

	public AvaliacoesAluno() {
	}

	public Long getIdAvaliacaoAluno() {
		return this.idAvaliacaoAluno;
	}

	public void setIdAvaliacaoAluno(Long idAvaliacaoAluno) {
		this.idAvaliacaoAluno = idAvaliacaoAluno;
	}

	public String getDsAvaliacaoAluno() {
		return this.dsAvaliacaoAluno;
	}

	public void setDsAvaliacaoAluno(String dsAvaliacaoAluno) {
		this.dsAvaliacaoAluno = dsAvaliacaoAluno;
	}

	public Date getDtAvaliacaoAluno() {
		return this.dtAvaliacaoAluno;
	}

	public void setDtAvaliacaoAluno(Date dtAvaliacaoAluno) {
		this.dtAvaliacaoAluno = dtAvaliacaoAluno;
	}

	public String getNrAvaliacao() {
		return this.nrAvaliacao;
	}

	public void setNrAvaliacao(String nrAvaliacao) {
		this.nrAvaliacao = nrAvaliacao;
	}

	public AtividadesAluno getAtividadesAluno() {
		return this.atividadesAluno;
	}

	public void setAtividadesAluno(AtividadesAluno atividadesAluno) {
		this.atividadesAluno = atividadesAluno;
	}

	public Avaliacoe getAvaliacoe() {
		return this.avaliacoe;
	}

	public void setAvaliacoe(Avaliacoe avaliacoe) {
		this.avaliacoe = avaliacoe;
	}

}