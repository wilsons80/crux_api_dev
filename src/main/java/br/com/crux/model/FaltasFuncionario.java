package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the faltas_funcionarios database table.
 * 
 */
@Entity
@Table(name="faltas_funcionarios")
public class FaltasFuncionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_falta_funcionario", unique=true, nullable=false, precision=10)
	private Long idFaltaFuncionario;

	@Column(name="ds_falta_funcionario", nullable=false, length=200)
	private String dsFaltaFuncionario;

	@Column(name="ds_jutifi_falta", length=200)
	private String dsJutifiFalta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro")
	private Date dtCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_falta_funcionario")
	private Date dtFaltaFuncionario;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario_falta", nullable=false)
	private Funcionario funcionario1;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario_cadastro", nullable=false)
	private Funcionario funcionario2;

	public FaltasFuncionario() {
	}

	public Long getIdFaltaFuncionario() {
		return this.idFaltaFuncionario;
	}

	public void setIdFaltaFuncionario(Long idFaltaFuncionario) {
		this.idFaltaFuncionario = idFaltaFuncionario;
	}

	public String getDsFaltaFuncionario() {
		return this.dsFaltaFuncionario;
	}

	public void setDsFaltaFuncionario(String dsFaltaFuncionario) {
		this.dsFaltaFuncionario = dsFaltaFuncionario;
	}

	public String getDsJutifiFalta() {
		return this.dsJutifiFalta;
	}

	public void setDsJutifiFalta(String dsJutifiFalta) {
		this.dsJutifiFalta = dsJutifiFalta;
	}

	public Date getDtCadastro() {
		return this.dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Date getDtFaltaFuncionario() {
		return this.dtFaltaFuncionario;
	}

	public void setDtFaltaFuncionario(Date dtFaltaFuncionario) {
		this.dtFaltaFuncionario = dtFaltaFuncionario;
	}

	public Funcionario getFuncionario1() {
		return this.funcionario1;
	}

	public void setFuncionario1(Funcionario funcionario1) {
		this.funcionario1 = funcionario1;
	}

	public Funcionario getFuncionario2() {
		return this.funcionario2;
	}

	public void setFuncionario2(Funcionario funcionario2) {
		this.funcionario2 = funcionario2;
	}

}