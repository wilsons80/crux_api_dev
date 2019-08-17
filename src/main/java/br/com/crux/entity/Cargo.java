package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cargos database table.
 * 
 */
@Entity
@Table(name="cargos")
@NamedQuery(name="Cargo.findAll", query="SELECT c FROM Cargo c")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cargo")
	private Long idCargo;

	@Column(name="cd_cargo")
	private String cdCargo;

	@Column(name="nm_cargo")
	private String nmCargo;

	@Column(name="st_tipo_cargo")
	private String stTipoCargo;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
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