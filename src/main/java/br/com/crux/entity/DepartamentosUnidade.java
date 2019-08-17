package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the departamentos_unidades database table.
 * 
 */
@Entity
@Table(name="departamentos_unidades")
@NamedQuery(name="DepartamentosUnidade.findAll", query="SELECT d FROM DepartamentosUnidade d")
public class DepartamentosUnidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_departamento")
	private Long idDepartamento;

	@Column(name="cd_unidade_departamento")
	private String cdUnidadeDepartamento;

	@Column(name="ds_endereco_departamento")
	private String dsEnderecoDepartamento;

	@Column(name="nm_departamento")
	private String nmDepartamento;

	@Column(name="nr_telefone_departamento")
	private String nrTelefoneDepartamento;

	//bi-directional many-to-one association to DepartamentosUnidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_departamento_1")
	private DepartamentosUnidade departamentosUnidade;

	//bi-directional many-to-one association to DepartamentosUnidade
	@OneToMany(mappedBy="departamentosUnidade")
	private List<DepartamentosUnidade> departamentosUnidades;

	//bi-directional many-to-one association to Unidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade")
	private Unidade unidade;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public DepartamentosUnidade() {
	}

	public Long getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getCdUnidadeDepartamento() {
		return this.cdUnidadeDepartamento;
	}

	public void setCdUnidadeDepartamento(String cdUnidadeDepartamento) {
		this.cdUnidadeDepartamento = cdUnidadeDepartamento;
	}

	public String getDsEnderecoDepartamento() {
		return this.dsEnderecoDepartamento;
	}

	public void setDsEnderecoDepartamento(String dsEnderecoDepartamento) {
		this.dsEnderecoDepartamento = dsEnderecoDepartamento;
	}

	public String getNmDepartamento() {
		return this.nmDepartamento;
	}

	public void setNmDepartamento(String nmDepartamento) {
		this.nmDepartamento = nmDepartamento;
	}

	public String getNrTelefoneDepartamento() {
		return this.nrTelefoneDepartamento;
	}

	public void setNrTelefoneDepartamento(String nrTelefoneDepartamento) {
		this.nrTelefoneDepartamento = nrTelefoneDepartamento;
	}

	public DepartamentosUnidade getDepartamentosUnidade() {
		return this.departamentosUnidade;
	}

	public void setDepartamentosUnidade(DepartamentosUnidade departamentosUnidade) {
		this.departamentosUnidade = departamentosUnidade;
	}

	public List<DepartamentosUnidade> getDepartamentosUnidades() {
		return this.departamentosUnidades;
	}

	public void setDepartamentosUnidades(List<DepartamentosUnidade> departamentosUnidades) {
		this.departamentosUnidades = departamentosUnidades;
	}

	public DepartamentosUnidade addDepartamentosUnidade(DepartamentosUnidade departamentosUnidade) {
		getDepartamentosUnidades().add(departamentosUnidade);
		departamentosUnidade.setDepartamentosUnidade(this);

		return departamentosUnidade;
	}

	public DepartamentosUnidade removeDepartamentosUnidade(DepartamentosUnidade departamentosUnidade) {
		getDepartamentosUnidades().remove(departamentosUnidade);
		departamentosUnidade.setDepartamentosUnidade(null);

		return departamentosUnidade;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}