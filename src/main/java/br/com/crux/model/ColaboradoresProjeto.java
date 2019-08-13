package br.com.crux.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the colaboradores_projetos database table.
 * 
 */
@Entity
@Table(name="colaboradores_projetos")
public class ColaboradoresProjeto  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_colaborador_projeto", unique=true, nullable=false, precision=10)
	private Long idColaboradorProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_entrada_projeto", nullable=false)
	private Date dtEntradaProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_saida_projeto")
	private Date dtSaidaProjeto;

	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cargo", nullable=false)
	private Cargo cargo;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario", nullable=false)
	private Funcionario funcionario;

	//bi-directional many-to-one association to Projeto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_projeto", nullable=false)
	private Projeto projeto;

	public ColaboradoresProjeto() {
	}

	public Long getIdColaboradorProjeto() {
		return this.idColaboradorProjeto;
	}

	public void setIdColaboradorProjeto(Long idColaboradorProjeto) {
		this.idColaboradorProjeto = idColaboradorProjeto;
	}

	public Date getDtEntradaProjeto() {
		return this.dtEntradaProjeto;
	}

	public void setDtEntradaProjeto(Date dtEntradaProjeto) {
		this.dtEntradaProjeto = dtEntradaProjeto;
	}

	public Date getDtSaidaProjeto() {
		return this.dtSaidaProjeto;
	}

	public void setDtSaidaProjeto(Date dtSaidaProjeto) {
		this.dtSaidaProjeto = dtSaidaProjeto;
	}

	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

}