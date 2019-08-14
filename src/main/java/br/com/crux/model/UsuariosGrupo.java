package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios_grupos database table.
 * 
 */
@Entity
@Table(name="usuarios_grupos")
public class UsuariosGrupo implements Serializable {
	private static final long serialVersionUID = 1L;

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