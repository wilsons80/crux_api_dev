package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.crux.infra.constantes.Constantes;

import java.util.Date;


@Entity
@Table(name="atendimentos")
public class Atendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_atendimento")
	@SequenceGenerator(name = "sq_id_atendimento", sequenceName = "sq_id_atendimento", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_atendimento", unique=true, nullable=false, precision=10)
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
	private Diagnosticos diagnostico;

	//bi-directional many-to-one association to Familiare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="familiares_id_familiar")
	private Familiares familiare;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="funcionarios_id_funcionario")
	private Funcionario funcionario;

	//bi-directional many-to-one association to Responsavei
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="responsaveis_id_responsavel")
	private Responsaveis responsaveis;

	//bi-directional many-to-one association to Solucoe
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="solucoes_id_solucao")
	private Solucoes solucoe;

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

	public Diagnosticos getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(Diagnosticos diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Familiares getFamiliare() {
		return this.familiare;
	}

	public void setFamiliare(Familiares familiare) {
		this.familiare = familiare;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Responsaveis getResponsaveis() {
		return this.responsaveis;
	}

	public void setResponsaveis(Responsaveis responsavei) {
		this.responsaveis = responsavei;
	}

	public Solucoes getSolucoe() {
		return this.solucoe;
	}

	public void setSolucoe(Solucoes solucoe) {
		this.solucoe = solucoe;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}