package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.crux.infra.constantes.Constantes;

import java.util.List;


/**
 * The persistent class for the modulos database table.
 * 
 */
@Entity
@Table(name="modulos")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_modulo")
	@SequenceGenerator(name = "sq_id_modulo", sequenceName = "sq_id_modulo", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_modulo")
	private Long idModulo;

	@Column(name="ds_modulo")
	private String dsModulo;

	@Column(name="nm_modulo")
	private String nmModulo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="modulo_pai")
	private Modulo moduloPai;

	//bi-directional many-to-one association to GruposModulo
	@OneToMany(mappedBy="modulo")
	private List<GruposModulo> gruposModulos;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public Modulo() {
	}

	public Long getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getDsModulo() {
		return this.dsModulo;
	}

	public void setDsModulo(String dsModulo) {
		this.dsModulo = dsModulo;
	}

	public String getNmModulo() {
		return this.nmModulo;
	}

	public void setNmModulo(String nmModulo) {
		this.nmModulo = nmModulo;
	}

	public List<GruposModulo> getGruposModulos() {
		return this.gruposModulos;
	}

	public void setGruposModulos(List<GruposModulo> gruposModulos) {
		this.gruposModulos = gruposModulos;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

	public Modulo getModuloPai() {
		return moduloPai;
	}

	public void setModuloPai(Modulo moduloPai) {
		this.moduloPai = moduloPai;
	}

}