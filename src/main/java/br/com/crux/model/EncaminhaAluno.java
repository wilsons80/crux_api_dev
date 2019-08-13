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
 * The persistent class for the encaminha_alunos database table.
 * 
 */
@Entity
@Table(name="encaminha_alunos")
public class EncaminhaAluno  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_encaminha_aluno", unique=true, nullable=false, precision=10)
	private Long idEncaminhaAluno;

	@Column(name="ds_encaminha_aluno", length=200)
	private String dsEncaminhaAluno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_encaminha_aluno", length=45)
	private Date dtEncaminhaAluno;

	//bi-directional many-to-one association to Aluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aluno", nullable=false)
	private Aluno aluno;

	//bi-directional many-to-one association to EntidadesSociai
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_entidade_social", nullable=false)
	private EntidadesSociai entidadesSociai;

	public EncaminhaAluno() {
	}

	public Long getIdEncaminhaAluno() {
		return this.idEncaminhaAluno;
	}

	public void setIdEncaminhaAluno(Long idEncaminhaAluno) {
		this.idEncaminhaAluno = idEncaminhaAluno;
	}

	public String getDsEncaminhaAluno() {
		return this.dsEncaminhaAluno;
	}

	public void setDsEncaminhaAluno(String dsEncaminhaAluno) {
		this.dsEncaminhaAluno = dsEncaminhaAluno;
	}

	public Date getDtEncaminhaAluno() {
		return this.dtEncaminhaAluno;
	}

	public void setDtEncaminhaAluno(Date dtEncaminhaAluno) {
		this.dtEncaminhaAluno = dtEncaminhaAluno;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public EntidadesSociai getEntidadesSociai() {
		return this.entidadesSociai;
	}

	public void setEntidadesSociai(EntidadesSociai entidadesSociai) {
		this.entidadesSociai = entidadesSociai;
	}

}