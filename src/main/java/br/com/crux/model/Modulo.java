package br.com.crux.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the modulos database table.
 * 
 */
@Entity
@Table(name="modulos")
public class Modulo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_modulo", unique=true, nullable=false, precision=10)
	private Long idModulo;

	@Column(name="nm_modulo", length=200)
	private String nmModulo;

	//bi-directional many-to-one association to GruposModulo
	@OneToMany(mappedBy="modulo")
	private List<GruposModulo> gruposModulos;

	//bi-directional many-to-one association to PerfisUsuario
	@OneToMany(mappedBy="modulo")
	private List<PerfisUsuario> perfisUsuarios;

	public Modulo() {
	}

	public Long getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
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

	public List<PerfisUsuario> getPerfisUsuarios() {
		return this.perfisUsuarios;
	}

	public void setPerfisUsuarios(List<PerfisUsuario> perfisUsuarios) {
		this.perfisUsuarios = perfisUsuarios;
	}

	public PerfisUsuario addPerfisUsuario(PerfisUsuario perfisUsuario) {
		getPerfisUsuarios().add(perfisUsuario);
		perfisUsuario.setModulo(this);

		return perfisUsuario;
	}

	public PerfisUsuario removePerfisUsuario(PerfisUsuario perfisUsuario) {
		getPerfisUsuarios().remove(perfisUsuario);
		perfisUsuario.setModulo(null);

		return perfisUsuario;
	}

}