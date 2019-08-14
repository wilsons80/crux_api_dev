package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modulo", unique=true, nullable=false, precision=10)
	private Long idModulo;

	@Column(name="cd_modulo", nullable=false, length=100)
	private String cdModulo;

	@Column(name="nm_modulo", length=200)
	private String nmModulo;

	//bi-directional many-to-one association to GruposModulo
	@OneToMany(mappedBy="modulo")
	private List<GruposModulo> gruposModulos;

	public Modulo() {
	}

	public Long getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getCdModulo() {
		return this.cdModulo;
	}

	public void setCdModulo(String cdModulo) {
		this.cdModulo = cdModulo;
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

	public GruposModulo addGruposModulo(GruposModulo gruposModulo) {
		getGruposModulos().add(gruposModulo);
		gruposModulo.setModulo(this);

		return gruposModulo;
	}

	public GruposModulo removeGruposModulo(GruposModulo gruposModulo) {
		getGruposModulos().remove(gruposModulo);
		gruposModulo.setModulo(null);

		return gruposModulo;
	}

}