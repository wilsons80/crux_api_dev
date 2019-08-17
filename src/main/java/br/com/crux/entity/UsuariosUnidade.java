package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the usuarios_unidades database table.
 * 
 */
@Entity
@Table(name="usuarios_unidades")
@NamedQuery(name="UsuariosUnidade.findAll", query="SELECT u FROM UsuariosUnidade u")
public class UsuariosUnidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario_unidade")
	private long idUsuarioUnidade;

	//bi-directional many-to-one association to Unidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade")
	private Unidade unidade;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario")
	private UsuariosSistema usuariosSistema;

	public UsuariosUnidade() {
	}

	public long getIdUsuarioUnidade() {
		return this.idUsuarioUnidade;
	}

	public void setIdUsuarioUnidade(long idUsuarioUnidade) {
		this.idUsuarioUnidade = idUsuarioUnidade;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}