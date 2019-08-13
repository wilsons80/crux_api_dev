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
 * The persistent class for the cargos database table.
 * 
 */
@Entity
@Table(name="cargos")
public class Cargo  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cargo", unique=true, nullable=false, precision=10)
	private Long idCargo;

	@Column(name="cd_cargo", nullable=false, length=15)
	private String cdCargo;

	@Column(name="nm_cargo", nullable=false, length=200)
	private String nmCargo;

	@Column(name="st_tipo_cargo", nullable=false, length=1)
	private String stTipoCargo;

	//bi-directional many-to-one association to ColaboradoresAtividade
	@OneToMany(mappedBy="cargo")
	private List<ColaboradoresAtividade> colaboradoresAtividades;

	//bi-directional many-to-one association to ColaboradoresPrograma
	@OneToMany(mappedBy="cargo")
	private List<ColaboradoresPrograma> colaboradoresProgramas;

	//bi-directional many-to-one association to ColaboradoresProjeto
	@OneToMany(mappedBy="cargo")
	private List<ColaboradoresProjeto> colaboradoresProjetos;

	//bi-directional many-to-one association to ContatosEmpresa
	@OneToMany(mappedBy="cargo")
	private List<ContatosEmpresa> contatosEmpresas;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="cargo")
	private List<Funcionario> funcionarios;

	public Cargo() {
	}

	public Long getIdCargo() {
		return this.idCargo;
	}

	public void setIdCargo(Long idCargo) {
		this.idCargo = idCargo;
	}

	public String getCdCargo() {
		return this.cdCargo;
	}

	public void setCdCargo(String cdCargo) {
		this.cdCargo = cdCargo;
	}

	public String getNmCargo() {
		return this.nmCargo;
	}

	public void setNmCargo(String nmCargo) {
		this.nmCargo = nmCargo;
	}

	public String getStTipoCargo() {
		return this.stTipoCargo;
	}

	public void setStTipoCargo(String stTipoCargo) {
		this.stTipoCargo = stTipoCargo;
	}

	public List<ColaboradoresAtividade> getColaboradoresAtividades() {
		return this.colaboradoresAtividades;
	}

	public void setColaboradoresAtividades(List<ColaboradoresAtividade> colaboradoresAtividades) {
		this.colaboradoresAtividades = colaboradoresAtividades;
	}

	public ColaboradoresAtividade addColaboradoresAtividade(ColaboradoresAtividade colaboradoresAtividade) {
		getColaboradoresAtividades().add(colaboradoresAtividade);
		colaboradoresAtividade.setCargo(this);

		return colaboradoresAtividade;
	}

	public ColaboradoresAtividade removeColaboradoresAtividade(ColaboradoresAtividade colaboradoresAtividade) {
		getColaboradoresAtividades().remove(colaboradoresAtividade);
		colaboradoresAtividade.setCargo(null);

		return colaboradoresAtividade;
	}

	public List<ColaboradoresPrograma> getColaboradoresProgramas() {
		return this.colaboradoresProgramas;
	}

	public void setColaboradoresProgramas(List<ColaboradoresPrograma> colaboradoresProgramas) {
		this.colaboradoresProgramas = colaboradoresProgramas;
	}

	public ColaboradoresPrograma addColaboradoresPrograma(ColaboradoresPrograma colaboradoresPrograma) {
		getColaboradoresProgramas().add(colaboradoresPrograma);
		colaboradoresPrograma.setCargo(this);

		return colaboradoresPrograma;
	}

	public ColaboradoresPrograma removeColaboradoresPrograma(ColaboradoresPrograma colaboradoresPrograma) {
		getColaboradoresProgramas().remove(colaboradoresPrograma);
		colaboradoresPrograma.setCargo(null);

		return colaboradoresPrograma;
	}

	public List<ColaboradoresProjeto> getColaboradoresProjetos() {
		return this.colaboradoresProjetos;
	}

	public void setColaboradoresProjetos(List<ColaboradoresProjeto> colaboradoresProjetos) {
		this.colaboradoresProjetos = colaboradoresProjetos;
	}

	public ColaboradoresProjeto addColaboradoresProjeto(ColaboradoresProjeto colaboradoresProjeto) {
		getColaboradoresProjetos().add(colaboradoresProjeto);
		colaboradoresProjeto.setCargo(this);

		return colaboradoresProjeto;
	}

	public ColaboradoresProjeto removeColaboradoresProjeto(ColaboradoresProjeto colaboradoresProjeto) {
		getColaboradoresProjetos().remove(colaboradoresProjeto);
		colaboradoresProjeto.setCargo(null);

		return colaboradoresProjeto;
	}

	public List<ContatosEmpresa> getContatosEmpresas() {
		return this.contatosEmpresas;
	}

	public void setContatosEmpresas(List<ContatosEmpresa> contatosEmpresas) {
		this.contatosEmpresas = contatosEmpresas;
	}

	public ContatosEmpresa addContatosEmpresa(ContatosEmpresa contatosEmpresa) {
		getContatosEmpresas().add(contatosEmpresa);
		contatosEmpresa.setCargo(this);

		return contatosEmpresa;
	}

	public ContatosEmpresa removeContatosEmpresa(ContatosEmpresa contatosEmpresa) {
		getContatosEmpresas().remove(contatosEmpresa);
		contatosEmpresa.setCargo(null);

		return contatosEmpresa;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario addFuncionario(Funcionario funcionario) {
		getFuncionarios().add(funcionario);
		funcionario.setCargo(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setCargo(null);

		return funcionario;
	}

}