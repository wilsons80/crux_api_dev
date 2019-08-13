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
 * The persistent class for the perfis_acesso database table.
 * 
 */
@Entity
@Table(name="perfis_acesso")
public class PerfisAcesso  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil_acesso", unique=true, nullable=false, precision=10)
	private Long idPerfilAcesso;

	@Column(name="cs_perfil_altera", length=1)
	private String csPerfilAltera;

	@Column(name="cs_perfil_consulta", length=1)
	private String csPerfilConsulta;

	@Column(name="cs_perfil_deleta", length=1)
	private String csPerfilDeleta;

	@Column(name="cs_perfil_insere", length=1)
	private String csPerfilInsere;

	@Column(name="nm_perfil_acesso", length=200)
	private String nmPerfilAcesso;

	//bi-directional many-to-one association to GruposModulo
	@OneToMany(mappedBy="perfisAcesso")
	private List<GruposModulo> gruposModulos;

	//bi-directional many-to-one association to PerfisUsuario
	@OneToMany(mappedBy="perfisAcesso")
	private List<PerfisUsuario> perfisUsuarios;

	public PerfisAcesso() {
	}

	public Long getIdPerfilAcesso() {
		return this.idPerfilAcesso;
	}

	public void setIdPerfilAcesso(Long idPerfilAcesso) {
		this.idPerfilAcesso = idPerfilAcesso;
	}

	public String getCsPerfilAltera() {
		return this.csPerfilAltera;
	}

	public void setCsPerfilAltera(String csPerfilAltera) {
		this.csPerfilAltera = csPerfilAltera;
	}

	public String getCsPerfilConsulta() {
		return this.csPerfilConsulta;
	}

	public void setCsPerfilConsulta(String csPerfilConsulta) {
		this.csPerfilConsulta = csPerfilConsulta;
	}

	public String getCsPerfilDeleta() {
		return this.csPerfilDeleta;
	}

	public void setCsPerfilDeleta(String csPerfilDeleta) {
		this.csPerfilDeleta = csPerfilDeleta;
	}

	public String getCsPerfilInsere() {
		return this.csPerfilInsere;
	}

	public void setCsPerfilInsere(String csPerfilInsere) {
		this.csPerfilInsere = csPerfilInsere;
	}

	public String getNmPerfilAcesso() {
		return this.nmPerfilAcesso;
	}

	public void setNmPerfilAcesso(String nmPerfilAcesso) {
		this.nmPerfilAcesso = nmPerfilAcesso;
	}

	public List<GruposModulo> getGruposModulos() {
		return this.gruposModulos;
	}

	public void setGruposModulos(List<GruposModulo> gruposModulos) {
		this.gruposModulos = gruposModulos;
	}

	public GruposModulo addGruposModulo(GruposModulo gruposModulo) {
		getGruposModulos().add(gruposModulo);
		gruposModulo.setPerfisAcesso(this);

		return gruposModulo;
	}

	public GruposModulo removeGruposModulo(GruposModulo gruposModulo) {
		getGruposModulos().remove(gruposModulo);
		gruposModulo.setPerfisAcesso(null);

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
		perfisUsuario.setPerfisAcesso(this);

		return perfisUsuario;
	}

	public PerfisUsuario removePerfisUsuario(PerfisUsuario perfisUsuario) {
		getPerfisUsuarios().remove(perfisUsuario);
		perfisUsuario.setPerfisAcesso(null);

		return perfisUsuario;
	}

}