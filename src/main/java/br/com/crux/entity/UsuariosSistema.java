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
	@Column(name="id_usuario")
	private Long idUsuario;

	@Column(name="nm_username")
	private String username;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ds_fim_vigencia_usuario")
	private Date dsFimVigenciaUsuario;

	@Column(name="ds_senha")
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



	@Column(name="qtd_acesso_negado")
	private BigDecimal qtdAcessoNegado;

	@Column(name="st_ativo")
	private String stAtivo;

	@Column(name="st_troca_senha")
	private String stTrocaSenha;


	//bi-directional many-to-one association to UsuariosGrupo
	@OneToMany(mappedBy="usuariosSistema")
	private List<UsuariosGrupo> usuariosGrupos;


	//bi-directional many-to-one association to UsuariosUnidade
	@OneToMany(mappedBy="usuariosSistema")
	private List<UsuariosUnidade> usuariosUnidades;
	
	
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String nmUsername) {
		this.username = nmUsername;
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

	public List<UsuariosGrupo> getUsuariosGrupos() {
		return usuariosGrupos;
	}

	public void setUsuariosGrupos(List<UsuariosGrupo> usuariosGrupos) {
		this.usuariosGrupos = usuariosGrupos;
	}

	public List<UsuariosUnidade> getUsuariosUnidades() {
		return usuariosUnidades;
	}

	public void setUsuariosUnidades(List<UsuariosUnidade> usuariosUnidades) {
		this.usuariosUnidades = usuariosUnidades;
	}

	

}