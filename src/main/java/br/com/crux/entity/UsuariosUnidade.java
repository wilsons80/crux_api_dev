package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.crux.infra.constantes.Constantes;


/**
 * The persistent class for the usuarios_unidades database table.
 * 
 */
@Entity
@Table(name="usuarios_unidades")
public class UsuariosUnidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_usuario_unidade")
	@SequenceGenerator(name = "sq_id_usuario_unidade", sequenceName = "sq_id_usuario_unidade", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_usuario_unidade")
	private Long idUsuarioUnidade;

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

	public Long getIdUsuarioUnidade() {
		return this.idUsuarioUnidade;
	}

	public void setIdUsuarioUnidade(Long idUsuarioUnidade) {
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