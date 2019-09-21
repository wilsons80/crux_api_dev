package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the encaminha_alunos database table.
 * 
 */
@Entity
@Table(name="encaminha_alunos")
@NamedQuery(name="EncaminhaAluno.findAll", query="SELECT e FROM EncaminhaAluno e")
public class EncaminhaAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_encaminha_aluno")
	private Long idEncaminhaAluno;

	@Column(name="ds_encaminha_aluno")
	private String dsEncaminhaAluno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_encaminha_aluno")
	private Date dtEncaminhaAluno;

	//bi-directional many-to-one association to Aluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aluno")
	private Aluno aluno;

	//bi-directional many-to-one association to EntidadesSociai
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_entidade_social")
	private EntidadesSociais entidadesSociai;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public EntidadesSociais getEntidadesSociai() {
		return this.entidadesSociai;
	}

	public void setEntidadesSociai(EntidadesSociais entidadesSociai) {
		this.entidadesSociai = entidadesSociai;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}