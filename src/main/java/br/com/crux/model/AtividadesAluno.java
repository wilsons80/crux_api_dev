package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the atividades_aluno database table.
 * 
 */
@Entity
@Table(name="atividades_aluno")
public class AtividadesAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_atividade_aluno", unique=true, nullable=false, precision=10)
	private Long idAtividadeAluno;

	@Column(name="ds_desligamento")
	private Timestamp dsDesligamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_alteracao_atividade")
	private Date dtAlteracaoAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro_atividade")
	private Date dtCadastroAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_desvinculacao")
	private Date dtDesvinculacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_atividade")
	private Date dtInicioAtividade;

	//bi-directional many-to-one association to AlunosTrabalhando
	@OneToMany(mappedBy="atividadesAluno")
	private List<AlunosTrabalhando> alunosTrabalhandos;

	//bi-directional many-to-one association to Aluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="aluno_id_aluno", nullable=false)
	private Aluno aluno;

	//bi-directional many-to-one association to Atividade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="atividades_id_atividade", nullable=false)
	private Atividade atividade;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="us_alteraca_id_usuario", nullable=false)
	private UsuariosSistema usuariosSistema1;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="us_cadastro_id_usuario", nullable=false)
	private UsuariosSistema usuariosSistema2;

	//bi-directional many-to-one association to AvaliacoesAluno
	@OneToMany(mappedBy="atividadesAluno")
	private List<AvaliacoesAluno> avaliacoesAlunos;

	//bi-directional many-to-one association to FrequenciasAluno
	@OneToMany(mappedBy="atividadesAluno")
	private List<FrequenciasAluno> frequenciasAlunos;

	//bi-directional many-to-one association to UniformesAluno
	@OneToMany(mappedBy="atividadesAluno")
	private List<UniformesAluno> uniformesAlunos;

	public AtividadesAluno() {
	}

	public Long getIdAtividadeAluno() {
		return this.idAtividadeAluno;
	}

	public void setIdAtividadeAluno(Long idAtividadeAluno) {
		this.idAtividadeAluno = idAtividadeAluno;
	}

	public Timestamp getDsDesligamento() {
		return this.dsDesligamento;
	}

	public void setDsDesligamento(Timestamp dsDesligamento) {
		this.dsDesligamento = dsDesligamento;
	}

	public Date getDtAlteracaoAtividade() {
		return this.dtAlteracaoAtividade;
	}

	public void setDtAlteracaoAtividade(Date dtAlteracaoAtividade) {
		this.dtAlteracaoAtividade = dtAlteracaoAtividade;
	}

	public Date getDtCadastroAtividade() {
		return this.dtCadastroAtividade;
	}

	public void setDtCadastroAtividade(Date dtCadastroAtividade) {
		this.dtCadastroAtividade = dtCadastroAtividade;
	}

	public Date getDtDesvinculacao() {
		return this.dtDesvinculacao;
	}

	public void setDtDesvinculacao(Date dtDesvinculacao) {
		this.dtDesvinculacao = dtDesvinculacao;
	}

	public Date getDtInicioAtividade() {
		return this.dtInicioAtividade;
	}

	public void setDtInicioAtividade(Date dtInicioAtividade) {
		this.dtInicioAtividade = dtInicioAtividade;
	}

	public List<AlunosTrabalhando> getAlunosTrabalhandos() {
		return this.alunosTrabalhandos;
	}

	public void setAlunosTrabalhandos(List<AlunosTrabalhando> alunosTrabalhandos) {
		this.alunosTrabalhandos = alunosTrabalhandos;
	}

	public AlunosTrabalhando addAlunosTrabalhando(AlunosTrabalhando alunosTrabalhando) {
		getAlunosTrabalhandos().add(alunosTrabalhando);
		alunosTrabalhando.setAtividadesAluno(this);

		return alunosTrabalhando;
	}

	public AlunosTrabalhando removeAlunosTrabalhando(AlunosTrabalhando alunosTrabalhando) {
		getAlunosTrabalhandos().remove(alunosTrabalhando);
		alunosTrabalhando.setAtividadesAluno(null);

		return alunosTrabalhando;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
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

	public List<AvaliacoesAluno> getAvaliacoesAlunos() {
		return this.avaliacoesAlunos;
	}

	public void setAvaliacoesAlunos(List<AvaliacoesAluno> avaliacoesAlunos) {
		this.avaliacoesAlunos = avaliacoesAlunos;
	}

	public AvaliacoesAluno addAvaliacoesAluno(AvaliacoesAluno avaliacoesAluno) {
		getAvaliacoesAlunos().add(avaliacoesAluno);
		avaliacoesAluno.setAtividadesAluno(this);

		return avaliacoesAluno;
	}

	public AvaliacoesAluno removeAvaliacoesAluno(AvaliacoesAluno avaliacoesAluno) {
		getAvaliacoesAlunos().remove(avaliacoesAluno);
		avaliacoesAluno.setAtividadesAluno(null);

		return avaliacoesAluno;
	}

	public List<FrequenciasAluno> getFrequenciasAlunos() {
		return this.frequenciasAlunos;
	}

	public void setFrequenciasAlunos(List<FrequenciasAluno> frequenciasAlunos) {
		this.frequenciasAlunos = frequenciasAlunos;
	}

	public FrequenciasAluno addFrequenciasAluno(FrequenciasAluno frequenciasAluno) {
		getFrequenciasAlunos().add(frequenciasAluno);
		frequenciasAluno.setAtividadesAluno(this);

		return frequenciasAluno;
	}

	public FrequenciasAluno removeFrequenciasAluno(FrequenciasAluno frequenciasAluno) {
		getFrequenciasAlunos().remove(frequenciasAluno);
		frequenciasAluno.setAtividadesAluno(null);

		return frequenciasAluno;
	}

	public List<UniformesAluno> getUniformesAlunos() {
		return this.uniformesAlunos;
	}

	public void setUniformesAlunos(List<UniformesAluno> uniformesAlunos) {
		this.uniformesAlunos = uniformesAlunos;
	}

	public UniformesAluno addUniformesAluno(UniformesAluno uniformesAluno) {
		getUniformesAlunos().add(uniformesAluno);
		uniformesAluno.setAtividadesAluno(this);

		return uniformesAluno;
	}

	public UniformesAluno removeUniformesAluno(UniformesAluno uniformesAluno) {
		getUniformesAlunos().remove(uniformesAluno);
		uniformesAluno.setAtividadesAluno(null);

		return uniformesAluno;
	}

}