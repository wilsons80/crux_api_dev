package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the alunos_trabalhando database table.
 * 
 */
@Entity
@Table(name="alunos_trabalhando")
@NamedQuery(name="AlunosTrabalhando.findAll", query="SELECT a FROM AlunosTrabalhando a")
public class AlunosTrabalhando implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aluno_trabalhando")
	private Long idAlunoTrabalhando;

	@Column(name="ds_tipo_empreendimento")
	private String dsTipoEmpreendimento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_aluno_trabalhando")
	private Date dtFimAlunoTrabalhando;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_aluno_trabalhando")
	private Date dtInicioAlunoTrabalhando;

	@Column(name="nm_empreendimento")
	private String nmEmpreendimento;

	//bi-directional many-to-one association to AtividadesAluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade_aluno")
	private AtividadesAluno atividadesAluno;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private UsuariosSistema usuariosSistema1;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema2;

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

	public UsuariosSistema getUsuariosSistema1() {
		return this.usuariosSistema1;
	}

	public void setUsuariosSistema1(UsuariosSistema usuariosSistema1) {
		this.usuariosSistema1 = usuariosSistema1;
	}

	public UsuariosSistema getUsuariosSistema2() {
		return this.usuariosSistema2;
	}

	public void setUsuariosSistema2(UsuariosSistema usuariosSistema2) {
		this.usuariosSistema2 = usuariosSistema2;
	}

}