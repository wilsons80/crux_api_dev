package br.com.crux.model;

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
 * The persistent class for the alunos_trabalhando database table.
 * 
 */
@Entity
@Table(name="alunos_trabalhando")
public class AlunosTrabalhando  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aluno_trabalhando", unique=true, nullable=false, precision=10)
	private Long idAlunoTrabalhando;

	@Column(name="ds_tipo_empreendimento", length=200)
	private String dsTipoEmpreendimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_aluno_trabalhando")
	private Date dtFimAlunoTrabalhando;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_aluno_trabalhando")
	private Date dtInicioAlunoTrabalhando;

	@Column(name="nm_empreendimento", length=200)
	private String nmEmpreendimento;

	//bi-directional many-to-one association to AtividadesAluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade_aluno", nullable=false)
	private AtividadesAluno atividadesAluno;

	public AlunosTrabalhando() {
	}

	public Long getIdAlunoTrabalhando() {
		return this.idAlunoTrabalhando;
	}

	public void setIdAlunoTrabalhando(Long idAlunoTrabalhando) {
		this.idAlunoTrabalhando = idAlunoTrabalhando;
	}

	public String getDsTipoEmpreendimento() {
		return this.dsTipoEmpreendimento;
	}

	public void setDsTipoEmpreendimento(String dsTipoEmpreendimento) {
		this.dsTipoEmpreendimento = dsTipoEmpreendimento;
	}

	public Date getDtFimAlunoTrabalhando() {
		return this.dtFimAlunoTrabalhando;
	}

	public void setDtFimAlunoTrabalhando(Date dtFimAlunoTrabalhando) {
		this.dtFimAlunoTrabalhando = dtFimAlunoTrabalhando;
	}

	public Date getDtInicioAlunoTrabalhando() {
		return this.dtInicioAlunoTrabalhando;
	}

	public void setDtInicioAlunoTrabalhando(Date dtInicioAlunoTrabalhando) {
		this.dtInicioAlunoTrabalhando = dtInicioAlunoTrabalhando;
	}

	public String getNmEmpreendimento() {
		return this.nmEmpreendimento;
	}

	public void setNmEmpreendimento(String nmEmpreendimento) {
		this.nmEmpreendimento = nmEmpreendimento;
	}

	public AtividadesAluno getAtividadesAluno() {
		return this.atividadesAluno;
	}

	public void setAtividadesAluno(AtividadesAluno atividadesAluno) {
		this.atividadesAluno = atividadesAluno;
	}

}