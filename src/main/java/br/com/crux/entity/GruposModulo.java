package br.com.crux.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.crux.infra.constantes.Constantes;


/**
 * The persistent class for the grupos_modulos database table.
 * 
 */
@Entity
@Table(name="grupos_modulos")
public class GruposModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_grupo_modulo")
	@SequenceGenerator(name = "sq_id_grupo_modulo", sequenceName = "sq_id_grupo_modulo", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_grupo_modulo")
	private Long idGrupoModulo;

	@Column(name="nm_grupo")
	private String nmGrupo;

	@Column(name="tx_descricao_grupo")
	private String txDescricaoGrupo;

	//bi-directional many-to-one association to Modulo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_modulo")
	private Modulo modulo;

	//bi-directional many-to-one association to PerfisAcesso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_perfil_acesso")
	private PerfisAcesso perfisAcesso;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade")
	private Unidade unidade;

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

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	

}