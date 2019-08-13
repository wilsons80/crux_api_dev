package br.com.crux.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the perfis_usuarios database table.
 * 
 */
@Entity
@Table(name="perfis_usuarios")
public class PerfisUsuario  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil_usuario", unique=true, nullable=false, precision=10)
	private Long idPerfilUsuario;

	//bi-directional many-to-one association to Modulo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_modulo", nullable=false)
	private Modulo modulo;

	//bi-directional many-to-one association to PerfisAcesso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_perfil_acesso", nullable=false)
	private PerfisAcesso perfisAcesso;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario", nullable=false)
	private UsuariosSistema usuariosSistema;

	public PerfisUsuario() {
	}

	public Long getIdPerfilUsuario() {
		return this.idPerfilUsuario;
	}

	public void setIdPerfilUsuario(Long idPerfilUsuario) {
		this.idPerfilUsuario = idPerfilUsuario;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public PerfisAcesso getPerfisAcesso() {
		return this.perfisAcesso;
	}

	public void setPerfisAcesso(PerfisAcesso perfisAcesso) {
		this.perfisAcesso = perfisAcesso;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}