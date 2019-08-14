package br.com.crux.entity;

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

	@Column(name="ds_senha", nullable=false, length=100)
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
	private String userName;

	@Column(name="qtd_acesso_negado", precision=10)
	private BigDecimal qtdAcessoNegado;

	@Column(name="st_ativo", length=1)
	private String stAtivo;

	@Column(name="st_troca_senha", length=1)
	private String stTrocaSenha;

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

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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