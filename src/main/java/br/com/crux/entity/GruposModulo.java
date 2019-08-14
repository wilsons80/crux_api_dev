package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the grupos_modulos database table.
 * 
 */
@Entity
@Table(name="grupos_modulos")
public class GruposModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_grupo_modulo", unique=true, nullable=false, precision=10)
	private Long idGrupoModulo;

	@Column(name="nm_grupo", nullable=false, length=100)
	private String nmGrupo;

	@Column(name="tx_descricao_grupo", nullable=false, length=200)
	private String txDescricaoGrupo;

	//bi-directional many-to-one association to Modulo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_modulo", nullable=false)
	private Modulo modulo;

	//bi-directional many-to-one association to PerfisAcesso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_perfil_acesso", nullable=false)
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

	public String getNmGrupo() {
		return this.nmGrupo;
	}

	public void setNmGrupo(String nmGrupo) {
		this.nmGrupo = nmGrupo;
	}

	public String getTxDescricaoGrupo() {
		return this.txDescricaoGrupo;
	}

	public void setTxDescricaoGrupo(String txDescricaoGrupo) {
		this.txDescricaoGrupo = txDescricaoGrupo;
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