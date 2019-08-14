package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cursos_formacao_pf database table.
 * 
 */
@Entity
@Table(name="cursos_formacao_pf")
public class CursosFormacaoPf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_curso", unique=true, nullable=false, precision=10)
	private Long idCurso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_curso")
	private Date dtFimCurso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_curso")
	private Date dtInicioCurso;

	@Column(name="nm_curso", nullable=false, length=200)
	private String nmCurso;

	@Column(name="nm_instuicao", length=200)
	private String nmInstuicao;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica", nullable=false)
	private PessoasFisica pessoasFisica;

	public CursosFormacaoPf() {
	}

	public Long getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Date getDtFimCurso() {
		return this.dtFimCurso;
	}

	public void setDtFimCurso(Date dtFimCurso) {
		this.dtFimCurso = dtFimCurso;
	}

	public Date getDtInicioCurso() {
		return this.dtInicioCurso;
	}

	public void setDtInicioCurso(Date dtInicioCurso) {
		this.dtInicioCurso = dtInicioCurso;
	}

	public String getNmCurso() {
		return this.nmCurso;
	}

	public void setNmCurso(String nmCurso) {
		this.nmCurso = nmCurso;
	}

	public String getNmInstuicao() {
		return this.nmInstuicao;
	}

	public void setNmInstuicao(String nmInstuicao) {
		this.nmInstuicao = nmInstuicao;
	}

	public PessoasFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoasFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

}