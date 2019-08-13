package br.com.crux.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the grupos_modulos database table.
 * 
 */
@Entity
@Table(name="grupos_modulos")
public class GruposModulo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_grupo_modulo", unique=true, nullable=false, precision=10)
	private Long idGrupoModulo;

	@Column(name="nm_grupo_modulo", length=50)
	private String nmGrupoModulo;

	@Column(name="tx_grupo_modulo", length=200)
	private String txGrupoModulo;

	//bi-directional many-to-one association to Modulo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_modulo")
	private Modulo modulo;

	//bi-directional many-to-one association to PerfisAcesso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_perfil_acesso")
	private PerfisAcesso perfisAcesso;

	//bi-directional many-to-one association to UsuariosGrupo
	@OneToMany(mappedBy="gruposModulo")
	private List<UsuariosGrupo> usuariosGrupos;

	public GruposModulo() {
	}

	public Long getIdGrupoModulo() {
		return this.idGrupoModulo;
	}

	public void setIdGrupoModulo(Long idGrupoModulo) {
		this.idGrupoModulo = idGrupoModulo;
	}

	public String getNmGrupoModulo() {
		return this.nmGrupoModulo;
	}

	public void setNmGrupoModulo(String nmGrupoModulo) {
		this.nmGrupoModulo = nmGrupoModulo;
	}

	public String getTxGrupoModulo() {
		return this.txGrupoModulo;
	}

	public void setTxGrupoModulo(String txGrupoModulo) {
		this.txGrupoModulo = txGrupoModulo;
	}

	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public PerfisAcesso getPerfisAcesso() {
		return this.perfisAcesso;
	}

	public void setPerfisAcesso(PerfisAcesso perfisAcesso) {
		this.perfisAcesso = perfisAcesso;
	}

	public List<UsuariosGrupo> getUsuariosGrupos() {
		return this.usuariosGrupos;
	}

	public void setUsuariosGrupos(List<UsuariosGrupo> usuariosGrupos) {
		this.usuariosGrupos = usuariosGrupos;
	}

	public UsuariosGrupo addUsuariosGrupo(UsuariosGrupo usuariosGrupo) {
		getUsuariosGrupos().add(usuariosGrupo);
		usuariosGrupo.setGruposModulo(this);

		return usuariosGrupo;
	}

	public UsuariosGrupo removeUsuariosGrupo(UsuariosGrupo usuariosGrupo) {
		getUsuariosGrupos().remove(usuariosGrupo);
		usuariosGrupo.setGruposModulo(null);

		return usuariosGrupo;
	}

}