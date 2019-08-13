package br.com.crux.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the reprovacoes_aluno database table.
 * 
 */
@Entity
@Table(name="reprovacoes_aluno")
public class ReprovacoesAluno  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reprovacao_aluno", unique=true, nullable=false, precision=10)
	private Long idReprovacaoAluno;

	@Column(name="ds_reprovacao_aluno", length=200)
	private String dsReprovacaoAluno;

	@Column(name="ds_serie_reprovacao", length=20)
	private String dsSerieReprovacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_reprovacao_aluno", length=45)
	private Date dtReprovacaoAluno;

	@Column(name="qtd_reprovacao", precision=10)
	private BigDecimal qtdReprovacao;

	//bi-directional many-to-one association to Aluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aluno", nullable=false)
	private Aluno aluno;

	public ReprovacoesAluno() {
	}

	public Long getIdReprovacaoAluno() {
		return this.idReprovacaoAluno;
	}

	public void setIdReprovacaoAluno(Long idReprovacaoAluno) {
		this.idReprovacaoAluno = idReprovacaoAluno;
	}

	public String getDsReprovacaoAluno() {
		return this.dsReprovacaoAluno;
	}

	public void setDsReprovacaoAluno(String dsReprovacaoAluno) {
		this.dsReprovacaoAluno = dsReprovacaoAluno;
	}

	public String getDsSerieReprovacao() {
		return this.dsSerieReprovacao;
	}

	public void setDsSerieReprovacao(String dsSerieReprovacao) {
		this.dsSerieReprovacao = dsSerieReprovacao;
	}

	public Date getDtReprovacaoAluno() {
		return this.dtReprovacaoAluno;
	}

	public void setDtReprovacaoAluno(Date dtReprovacaoAluno) {
		this.dtReprovacaoAluno = dtReprovacaoAluno;
	}

	public BigDecimal getQtdReprovacao() {
		return this.qtdReprovacao;
	}

	public void setQtdReprovacao(BigDecimal qtdReprovacao) {
		this.qtdReprovacao = qtdReprovacao;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}