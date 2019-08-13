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
 * The persistent class for the usuarios_grupo database table.
 * 
 */
@Entity
@Table(name="usuarios_grupo")
public class UsuariosGrupo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario_grupo", unique=true, nullable=false, precision=10)
	private Long idUsuarioGrupo;

	//bi-directional many-to-one association to GruposModulo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_grupo_modulo", nullable=false)
	private GruposModulo gruposModulo;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario", nullable=false)
	private UsuariosSistema usuariosSistema;

	public UsuariosGrupo() {
	}

	public Long getIdUsuarioGrupo() {
		return this.idUsuarioGrupo;
	}

	public void setIdUsuarioGrupo(Long idUsuarioGrupo) {
		this.idUsuarioGrupo = idUsuarioGrupo;
	}

	public GruposModulo getGruposModulo() {
		return this.gruposModulo;
	}

	public void setGruposModulo(GruposModulo gruposModulo) {
		this.gruposModulo = gruposModulo;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}