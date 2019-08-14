package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the colaboradores_programas database table.
 * 
 */
@Entity
@Table(name="colaboradores_programas")
public class ColaboradoresPrograma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_colaborador_prgrama", unique=true, nullable=false, precision=10)
	private Long idColaboradorPrgrama;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_entrada_programa", nullable=false)
	private Date dtEntradaPrograma;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_saida_programa")
	private Date dtSaidaPrograma;

	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cargo", nullable=false)
	private Cargo cargo;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario", nullable=false)
	private Funcionario funcionario;

	//bi-directional many-to-one association to Programa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_programa", nullable=false)
	private Programa programa;

	public ColaboradoresPrograma() {
	}

	public Long getIdColaboradorPrgrama() {
		return this.idColaboradorPrgrama;
	}

	public void setIdColaboradorPrgrama(Long idColaboradorPrgrama) {
		this.idColaboradorPrgrama = idColaboradorPrgrama;
	}

	public Date getDtEntradaPrograma() {
		return this.dtEntradaPrograma;
	}

	public void setDtEntradaPrograma(Date dtEntradaPrograma) {
		this.dtEntradaPrograma = dtEntradaPrograma;
	}

	public Date getDtSaidaPrograma() {
		return this.dtSaidaPrograma;
	}

	public void setDtSaidaPrograma(Date dtSaidaPrograma) {
		this.dtSaidaPrograma = dtSaidaPrograma;
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

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

}