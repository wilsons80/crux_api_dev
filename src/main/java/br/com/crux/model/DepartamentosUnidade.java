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
 * The persistent class for the departamentos_unidades database table.
 * 
 */
@Entity
@Table(name="departamentos_unidades")
public class DepartamentosUnidade  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_departamento", unique=true, nullable=false, precision=10)
	private Long idDepartamento;

	@Column(name="cd_unidade_departamento", nullable=false, length=6)
	private String cdUnidadeDepartamento;

	@Column(name="ds_endereco_departamento", length=200)
	private String dsEnderecoDepartamento;

	@Column(name="nm_departamento", nullable=false, length=100)
	private String nmDepartamento;

	@Column(name="nr_telefone_departamento", length=15)
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
	@JoinColumn(name="id_unidade", nullable=false)
	private Unidade unidade;

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

}