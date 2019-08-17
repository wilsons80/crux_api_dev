package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the atendimentos database table.
 * 
 */
@Entity
@Table(name="atendimentos")
@NamedQuery(name="Atendimento.findAll", query="SELECT a FROM Atendimento a")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_atendimento")
	private Long idAtendimento;

	@Column(name="ds_diagnostico")
	private String dsDiagnostico;

	@Column(name="ds_solucao")
	private String dsSolucao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_atendimento")
	private Date dtAtendimento;

	//bi-directional many-to-one association to Aluno
	@ManyToOne(fetch=FetchType.LAZY)
	private Aluno aluno;

	//bi-directional many-to-one association to Diagnostico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="diagnosticos_id_diagnostico")
	private Diagnostico diagnostico;

	//bi-directional many-to-one association to Familiare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="familiares_id_familiar")
	private Familiare familiare;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="funcionarios_id_funcionario")
	private Funcionario funcionario;

	//bi-directional many-to-one association to Responsavei
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="responsaveis_id_responsavel")
	private Responsavei responsavei;

	//bi-directional many-to-one association to Solucoe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="solucoes_id_solucao")
	private Solucoe solucoe;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public Atendimento() {
	}

	public Long getIdAtendimento() {
		return this.idAtendimento;
	}

	public void setIdAtendimento(Long idAtendimento) {
		this.idAtendimento = idAtendimento;
	}

	public String getDsDiagnostico() {
		return this.dsDiagnostico;
	}

	public void setDsDiagnostico(String dsDiagnostico) {
		this.dsDiagnostico = dsDiagnostico;
	}

	public String getDsSolucao() {
		return this.dsSolucao;
	}

	public void setDsSolucao(String dsSolucao) {
		this.dsSolucao = dsSolucao;
	}

	public Date getDtAtendimento() {
		return this.dtAtendimento;
	}

	public void setDtAtendimento(Date dtAtendimento) {
		this.dtAtendimento = dtAtendimento;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Diagnostico getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Familiare getFamiliare() {
		return this.familiare;
	}

	public void setFamiliare(Familiare familiare) {
		this.familiare = familiare;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Responsavei getResponsavei() {
		return this.responsavei;
	}

	public void setResponsavei(Responsavei responsavei) {
		this.responsavei = responsavei;
	}

	public Solucoe getSolucoe() {
		return this.solucoe;
	}

	public void setSolucoe(Solucoe solucoe) {
		this.solucoe = solucoe;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}