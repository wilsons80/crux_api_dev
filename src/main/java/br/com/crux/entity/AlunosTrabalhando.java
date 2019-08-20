package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.crux.infra.constantes.Constantes;

import java.util.Date;


/**
 * The persistent class for the alunos_trabalhando database table.
 * 
 */
@Entity
@Table(name="alunos_trabalhando")
public class AlunosTrabalhando implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_aluno_trabalhando")
	@SequenceGenerator(name = "sq_id_aluno_trabalhando", sequenceName = "sq_id_aluno_trabalhando", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_aluno_trabalhando", unique=true, nullable=false, precision=10)
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
	private UsuariosSistema usuario;


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

	public UsuariosSistema getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuariosSistema usuariosSistema1) {
		this.usuario = usuariosSistema1;
	}


}