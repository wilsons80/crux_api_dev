package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the colaboradores_atividades database table.
 * 
 */
@Entity
@Table(name="colaboradores_atividades")
@NamedQuery(name="ColaboradoresAtividade.findAll", query="SELECT c FROM ColaboradoresAtividade c")
public class ColaboradoresAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_colaborador_atividade")
	private Long idColaboradorAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_entrada_atividade")
	private Date dtEntradaAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_saida_atividade")
	private Date dtSaidaAtividade;

	//bi-directional many-to-one association to Atividade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade")
	private Atividades atividade;

	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cargo")
	private Cargo cargo;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario")
	private Funcionario funcionario;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public Atividades getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividades atividade) {
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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}