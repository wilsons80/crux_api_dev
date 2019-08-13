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
 * The persistent class for the colaboradores_atividades database table.
 * 
 */
@Entity
@Table(name="colaboradores_atividades")
public class ColaboradoresAtividade  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_colaborador_atividade", unique=true, nullable=false, precision=10)
	private Long idColaboradorAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_entrada_atividade", nullable=false)
	private Date dtEntradaAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_saida_atividade")
	private Date dtSaidaAtividade;

	//bi-directional many-to-one association to Atividade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade", nullable=false)
	private Atividade atividade;

	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cargo", nullable=false)
	private Cargo cargo;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario", nullable=false)
	private Funcionario funcionario;

	public ColaboradoresAtividade() {
	}

	public Long getIdColaboradorAtividade() {
		return this.idColaboradorAtividade;
	}

	public void setIdColaboradorAtividade(Long idColaboradorAtividade) {
		this.idColaboradorAtividade = idColaboradorAtividade;
	}

	public Date getDtEntradaAtividade() {
		return this.dtEntradaAtividade;
	}

	public void setDtEntradaAtividade(Date dtEntradaAtividade) {
		this.dtEntradaAtividade = dtEntradaAtividade;
	}

	public Date getDtSaidaAtividade() {
		return this.dtSaidaAtividade;
	}

	public void setDtSaidaAtividade(Date dtSaidaAtividade) {
		this.dtSaidaAtividade = dtSaidaAtividade;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
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

}