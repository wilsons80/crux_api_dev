package br.com.crux.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the colaboradores_atividades database table.
 * 
 */
@Entity
@Table(name = "colaboradores_atividades")
@NamedQuery(name = "ColaboradoresAtividade.findAll", query = "SELECT c FROM ColaboradoresAtividade c")
public class ColaboradoresAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_colaborador_atividade") private Long idColaboradorAtividade;

	@Column(name = "dt_entrada_atividade") private LocalDateTime dtEntradaAtividade;

	@Column(name = "dt_saida_atividade") private LocalDateTime dtSaidaAtividade;

	//bi-directional many-to-one association to Atividade
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_atividade") 
	private Atividades atividade;

	//bi-directional many-to-one association to Cargo
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_cargo") 
	private Cargo cargo;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "id_funcionario") 
	private Funcionario funcionario;

	@JoinColumn(name = "id_usuario_apl")
	private Long usuariosSistema;

	public ColaboradoresAtividade() {
	}

	public Long getIdColaboradorAtividade() {
		return this.idColaboradorAtividade;
	}

	public void setIdColaboradorAtividade(Long idColaboradorAtividade) {
		this.idColaboradorAtividade = idColaboradorAtividade;
	}

	public LocalDateTime getDtEntradaAtividade() {
		return this.dtEntradaAtividade;
	}

	public void setDtEntradaAtividade(LocalDateTime dtEntradaAtividade) {
		this.dtEntradaAtividade = dtEntradaAtividade;
	}

	public LocalDateTime getDtSaidaAtividade() {
		return this.dtSaidaAtividade;
	}

	public void setDtSaidaAtividade(LocalDateTime dtSaidaAtividade) {
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

	public Long getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(Long usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}