package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the entidades database table.
 * 
 */
@Entity
@Table(name="entidades")
public class Entidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_entidade", unique=true, nullable=false, precision=10)
	private Long idEntidade;

	@Column(name="cd_entidade", nullable=false, length=20)
	private String cdEntidade;

	@Column(name="ds_missao", nullable=false, length=1000)
	private String dsMissao;

	@Column(name="ds_visao", nullable=false, length=1000)
	private String dsVisao;

	@Column(name="nm_entidade", nullable=false, length=200)
	private String nmEntidade;

	//bi-directional many-to-one association to Arquivo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_arquivo_logomarca")
	private Arquivo arquivo;

	//bi-directional many-to-one association to Perspectiva
	@OneToMany(mappedBy="entidade")
	private List<Perspectiva> perspectivas;

	//bi-directional many-to-one association to Unidade
	@OneToMany(mappedBy="entidade")
	private List<Unidade> unidades;

	public Entidade() {
	}

	public Long getIdEntidade() {
		return this.idEntidade;
	}

	public void setIdEntidade(Long idEntidade) {
		this.idEntidade = idEntidade;
	}

	public String getCdEntidade() {
		return this.cdEntidade;
	}

	public void setCdEntidade(String cdEntidade) {
		this.cdEntidade = cdEntidade;
	}

	public String getDsMissao() {
		return this.dsMissao;
	}

	public void setDsMissao(String dsMissao) {
		this.dsMissao = dsMissao;
	}

	public String getDsVisao() {
		return this.dsVisao;
	}

	public void setDsVisao(String dsVisao) {
		this.dsVisao = dsVisao;
	}

	public String getNmEntidade() {
		return this.nmEntidade;
	}

	public void setNmEntidade(String nmEntidade) {
		this.nmEntidade = nmEntidade;
	}

	public Arquivo getArquivo() {
		return this.arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public List<Perspectiva> getPerspectivas() {
		return this.perspectivas;
	}

	public void setPerspectivas(List<Perspectiva> perspectivas) {
		this.perspectivas = perspectivas;
	}

	public Perspectiva addPerspectiva(Perspectiva perspectiva) {
		getPerspectivas().add(perspectiva);
		perspectiva.setEntidade(this);

		return perspectiva;
	}

	public Perspectiva removePerspectiva(Perspectiva perspectiva) {
		getPerspectivas().remove(perspectiva);
		perspectiva.setEntidade(null);

		return perspectiva;
	}

	public List<Unidade> getUnidades() {
		return this.unidades;
	}

	public void setUnidades(List<Unidade> unidades) {
		this.unidades = unidades;
	}

	public Unidade addUnidade(Unidade unidade) {
		getUnidades().add(unidade);
		unidade.setEntidade(this);

		return unidade;
	}

	public Unidade removeUnidade(Unidade unidade) {
		getUnidades().remove(unidade);
		unidade.setEntidade(null);

		return unidade;
	}

}