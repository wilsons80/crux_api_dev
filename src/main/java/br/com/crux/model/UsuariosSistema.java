package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the usuarios_sistema database table.
 * 
 */
@Entity
@Table(name="usuarios_sistema")
public class UsuariosSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario", unique=true, nullable=false, precision=10)
	private Long idUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ds_fim_vigencia_usuario")
	private Date dsFimVigenciaUsuario;

	@Column(name="ds_senha", nullable=false, length=30)
	private String dsSenha;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_vigencia")
	private Date dtFimVigencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_vigencia")
	private Date dtInicioVigencia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_ultimo_acesso")
	private Date dtUltimoAcesso;

	@Column(name="nm_username", length=45)
	private String nmUsername;

	@Column(name="qtd_acesso_negado", precision=10)
	private BigDecimal qtdAcessoNegado;

	@Column(name="st_ativo", length=1)
	private String stAtivo;

	@Column(name="st_troca_senha", length=1)
	private String stTrocaSenha;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="usuariosSistema1")
	private List<Aluno> alunos1;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="usuariosSistema2")
	private List<Aluno> alunos2;

	//bi-directional many-to-one association to AtividadesAluno
	@OneToMany(mappedBy="usuariosSistema1")
	private List<AtividadesAluno> atividadesAlunos1;

	//bi-directional many-to-one association to AtividadesAluno
	@OneToMany(mappedBy="usuariosSistema2")
	private List<AtividadesAluno> atividadesAlunos2;

	//bi-directional many-to-one association to CadastroReservaAtividade
	@OneToMany(mappedBy="usuariosSistema1")
	private List<CadastroReservaAtividade> cadastroReservaAtividades1;

	//bi-directional many-to-one association to CadastroReservaAtividade
	@OneToMany(mappedBy="usuariosSistema2")
	private List<CadastroReservaAtividade> cadastroReservaAtividades2;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica", nullable=false)
	private PessoasFisica pessoasFisica;

	//bi-directional many-to-one association to UsuariosGrupo
	@OneToMany(mappedBy="usuariosSistema")
	private List<UsuariosGrupo> usuariosGrupos;

	public UsuariosSistema() {
	}

	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getDsFimVigenciaUsuario() {
		return this.dsFimVigenciaUsuario;
	}

	public void setDsFimVigenciaUsuario(Date dsFimVigenciaUsuario) {
		this.dsFimVigenciaUsuario = dsFimVigenciaUsuario;
	}

	public String getDsSenha() {
		return this.dsSenha;
	}

	public void setDsSenha(String dsSenha) {
		this.dsSenha = dsSenha;
	}

	public Date getDtFimVigencia() {
		return this.dtFimVigencia;
	}

	public void setDtFimVigencia(Date dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

	public Date getDtInicioVigencia() {
		return this.dtInicioVigencia;
	}

	public void setDtInicioVigencia(Date dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}

	public Date getDtUltimoAcesso() {
		return this.dtUltimoAcesso;
	}

	public void setDtUltimoAcesso(Date dtUltimoAcesso) {
		this.dtUltimoAcesso = dtUltimoAcesso;
	}

	public String getNmUsername() {
		return this.nmUsername;
	}

	public void setNmUsername(String nmUsername) {
		this.nmUsername = nmUsername;
	}

	public BigDecimal getQtdAcessoNegado() {
		return this.qtdAcessoNegado;
	}

	public void setQtdAcessoNegado(BigDecimal qtdAcessoNegado) {
		this.qtdAcessoNegado = qtdAcessoNegado;
	}

	public String getStAtivo() {
		return this.stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public String getStTrocaSenha() {
		return this.stTrocaSenha;
	}

	public void setStTrocaSenha(String stTrocaSenha) {
		this.stTrocaSenha = stTrocaSenha;
	}

	public List<Aluno> getAlunos1() {
		return this.alunos1;
	}

	public void setAlunos1(List<Aluno> alunos1) {
		this.alunos1 = alunos1;
	}

	public Aluno addAlunos1(Aluno alunos1) {
		getAlunos1().add(alunos1);
		alunos1.setUsuariosSistema1(this);

		return alunos1;
	}

	public Aluno removeAlunos1(Aluno alunos1) {
		getAlunos1().remove(alunos1);
		alunos1.setUsuariosSistema1(null);

		return alunos1;
	}

	public List<Aluno> getAlunos2() {
		return this.alunos2;
	}

	public void setAlunos2(List<Aluno> alunos2) {
		this.alunos2 = alunos2;
	}

	public Aluno addAlunos2(Aluno alunos2) {
		getAlunos2().add(alunos2);
		alunos2.setUsuariosSistema2(this);

		return alunos2;
	}

	public Aluno removeAlunos2(Aluno alunos2) {
		getAlunos2().remove(alunos2);
		alunos2.setUsuariosSistema2(null);

		return alunos2;
	}

	public List<AtividadesAluno> getAtividadesAlunos1() {
		return this.atividadesAlunos1;
	}

	public void setAtividadesAlunos1(List<AtividadesAluno> atividadesAlunos1) {
		this.atividadesAlunos1 = atividadesAlunos1;
	}

	public AtividadesAluno addAtividadesAlunos1(AtividadesAluno atividadesAlunos1) {
		getAtividadesAlunos1().add(atividadesAlunos1);
		atividadesAlunos1.setUsuariosSistema1(this);

		return atividadesAlunos1;
	}

	public AtividadesAluno removeAtividadesAlunos1(AtividadesAluno atividadesAlunos1) {
		getAtividadesAlunos1().remove(atividadesAlunos1);
		atividadesAlunos1.setUsuariosSistema1(null);

		return atividadesAlunos1;
	}

	public List<AtividadesAluno> getAtividadesAlunos2() {
		return this.atividadesAlunos2;
	}

	public void setAtividadesAlunos2(List<AtividadesAluno> atividadesAlunos2) {
		this.atividadesAlunos2 = atividadesAlunos2;
	}

	public AtividadesAluno addAtividadesAlunos2(AtividadesAluno atividadesAlunos2) {
		getAtividadesAlunos2().add(atividadesAlunos2);
		atividadesAlunos2.setUsuariosSistema2(this);

		return atividadesAlunos2;
	}

	public AtividadesAluno removeAtividadesAlunos2(AtividadesAluno atividadesAlunos2) {
		getAtividadesAlunos2().remove(atividadesAlunos2);
		atividadesAlunos2.setUsuariosSistema2(null);

		return atividadesAlunos2;
	}

	public List<CadastroReservaAtividade> getCadastroReservaAtividades1() {
		return this.cadastroReservaAtividades1;
	}

	public void setCadastroReservaAtividades1(List<CadastroReservaAtividade> cadastroReservaAtividades1) {
		this.cadastroReservaAtividades1 = cadastroReservaAtividades1;
	}

	public CadastroReservaAtividade addCadastroReservaAtividades1(CadastroReservaAtividade cadastroReservaAtividades1) {
		getCadastroReservaAtividades1().add(cadastroReservaAtividades1);
		cadastroReservaAtividades1.setUsuariosSistema1(this);

		return cadastroReservaAtividades1;
	}

	public CadastroReservaAtividade removeCadastroReservaAtividades1(CadastroReservaAtividade cadastroReservaAtividades1) {
		getCadastroReservaAtividades1().remove(cadastroReservaAtividades1);
		cadastroReservaAtividades1.setUsuariosSistema1(null);

		return cadastroReservaAtividades1;
	}

	public List<CadastroReservaAtividade> getCadastroReservaAtividades2() {
		return this.cadastroReservaAtividades2;
	}

	public void setCadastroReservaAtividades2(List<CadastroReservaAtividade> cadastroReservaAtividades2) {
		this.cadastroReservaAtividades2 = cadastroReservaAtividades2;
	}

	public CadastroReservaAtividade addCadastroReservaAtividades2(CadastroReservaAtividade cadastroReservaAtividades2) {
		getCadastroReservaAtividades2().add(cadastroReservaAtividades2);
		cadastroReservaAtividades2.setUsuariosSistema2(this);

		return cadastroReservaAtividades2;
	}

	public CadastroReservaAtividade removeCadastroReservaAtividades2(CadastroReservaAtividade cadastroReservaAtividades2) {
		getCadastroReservaAtividades2().remove(cadastroReservaAtividades2);
		cadastroReservaAtividades2.setUsuariosSistema2(null);

		return cadastroReservaAtividades2;
	}

	public PessoasFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoasFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public List<UsuariosGrupo> getUsuariosGrupos() {
		return this.usuariosGrupos;
	}

	public void setUsuariosGrupos(List<UsuariosGrupo> usuariosGrupos) {
		this.usuariosGrupos = usuariosGrupos;
	}

	public UsuariosGrupo addUsuariosGrupo(UsuariosGrupo usuariosGrupo) {
		getUsuariosGrupos().add(usuariosGrupo);
		usuariosGrupo.setUsuariosSistema(this);

		return usuariosGrupo;
	}

	public UsuariosGrupo removeUsuariosGrupo(UsuariosGrupo usuariosGrupo) {
		getUsuariosGrupos().remove(usuariosGrupo);
		usuariosGrupo.setUsuariosSistema(null);

		return usuariosGrupo;
	}

}