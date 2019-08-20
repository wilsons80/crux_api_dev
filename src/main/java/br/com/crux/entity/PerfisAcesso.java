package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.crux.infra.constantes.Constantes;

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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_perfil_acesso")
	@SequenceGenerator(name = "sq_id_perfil_acesso", sequenceName = "sq_id_perfil_acesso", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_perfil_acesso")
	private Long idPerfilAcesso;

	@Column(name="cs_altera")
	private String csAltera;

	@Column(name="cs_consulta")
	private String csConsulta;

	@Column(name="cs_deleta")
	private String csDeleta;

	@Column(name="cs_insere")
	private String csInsere;

	@Column(name="nm_perfil_acesso")
	private String nmPerfilAcesso;

	//bi-directional many-to-one association to GruposModulo
	@OneToMany(mappedBy="perfisAcesso")
	private List<GruposModulo> gruposModulos;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}