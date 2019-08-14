package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the perfis_acessos database table.
 * 
 */
@Entity
@Table(name="perfis_acessos")
public class PerfisAcesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_perfil_acesso", unique=true, nullable=false, precision=10)
	private Long idPerfilAcesso;

	@Column(name="cs_altera", length=1)
	private String csAltera;

	@Column(name="cs_consulta", length=1)
	private String csConsulta;

	@Column(name="cs_deleta", length=1)
	private String csDeleta;

	@Column(name="cs_insere", length=1)
	private String csInsere;

	@Column(name="nm_perfil_acesso", length=200)
	private String nmPerfilAcesso;

	//bi-directional many-to-one association to GruposModulo
	@OneToMany(mappedBy="perfisAcesso")
	private List<GruposModulo> gruposModulos;

	public PerfisAcesso() {
	}

	public Long getIdPerfilAcesso() {
		return this.idPerfilAcesso;
	}

	public void setIdPerfilAcesso(Long idPerfilAcesso) {
		this.idPerfilAcesso = idPerfilAcesso;
	}

	public String getCsAltera() {
		return this.csAltera;
	}

	public void setCsAltera(String csAltera) {
		this.csAltera = csAltera;
	}

	public String getCsConsulta() {
		return this.csConsulta;
	}

	public void setCsConsulta(String csConsulta) {
		this.csConsulta = csConsulta;
	}

	public String getCsDeleta() {
		return this.csDeleta;
	}

	public void setCsDeleta(String csDeleta) {
		this.csDeleta = csDeleta;
	}

	public String getCsInsere() {
		return this.csInsere;
	}

	public void setCsInsere(String csInsere) {
		this.csInsere = csInsere;
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

}