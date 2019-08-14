package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the cadastro_reserva_atividades database table.
 * 
 */
@Entity
@Table(name="cadastro_reserva_atividades")
public class CadastroReservaAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cadastro_reserva", unique=true, nullable=false, precision=10)
	private Long idCadastroReserva;

	@Column(name="ds_cadastro_reserva")
	private Timestamp dsCadastroReserva;

	@Column(name="ds_cancelamento_cadastro", length=200)
	private String dsCancelamentoCadastro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_alteracao_atividade")
	private Date dtAlteracaoAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro_atividade")
	private Date dtCadastroAtividade;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cadastro_reserva")
	private Date dtCadastroReserva;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_cancelamento_cadastro")
	private Date dtCancelamentoCadastro;

	//bi-directional many-to-one association to Atividade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade", nullable=false)
	private Atividade atividade;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pf_id_pessoa_fisica", nullable=false)
	private PessoasFisica pessoasFisica;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="us_alteraca_id_usuario", nullable=false)
	private UsuariosSistema usuariosSistema1;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="us_cadastro_id_usuario", nullable=false)
	private UsuariosSistema usuariosSistema2;

	public CadastroReservaAtividade() {
	}

	public Long getIdCadastroReserva() {
		return this.idCadastroReserva;
	}

	public void setIdCadastroReserva(Long idCadastroReserva) {
		this.idCadastroReserva = idCadastroReserva;
	}

	public Timestamp getDsCadastroReserva() {
		return this.dsCadastroReserva;
	}

	public void setDsCadastroReserva(Timestamp dsCadastroReserva) {
		this.dsCadastroReserva = dsCadastroReserva;
	}

	public String getDsCancelamentoCadastro() {
		return this.dsCancelamentoCadastro;
	}

	public void setDsCancelamentoCadastro(String dsCancelamentoCadastro) {
		this.dsCancelamentoCadastro = dsCancelamentoCadastro;
	}

	public Date getDtAlteracaoAtividade() {
		return this.dtAlteracaoAtividade;
	}

	public void setDtAlteracaoAtividade(Date dtAlteracaoAtividade) {
		this.dtAlteracaoAtividade = dtAlteracaoAtividade;
	}

	public Date getDtCadastroAtividade() {
		return this.dtCadastroAtividade;
	}

	public void setDtCadastroAtividade(Date dtCadastroAtividade) {
		this.dtCadastroAtividade = dtCadastroAtividade;
	}

	public Date getDtCadastroReserva() {
		return this.dtCadastroReserva;
	}

	public void setDtCadastroReserva(Date dtCadastroReserva) {
		this.dtCadastroReserva = dtCadastroReserva;
	}

	public Date getDtCancelamentoCadastro() {
		return this.dtCancelamentoCadastro;
	}

	public void setDtCancelamentoCadastro(Date dtCancelamentoCadastro) {
		this.dtCancelamentoCadastro = dtCancelamentoCadastro;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public PessoasFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoasFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public UsuariosSistema getUsuariosSistema1() {
		return this.usuariosSistema1;
	}

	public void setUsuariosSistema1(UsuariosSistema usuariosSistema1) {
		this.usuariosSistema1 = usuariosSistema1;
	}

	public UsuariosSistema getUsuariosSistema2() {
		return this.usuariosSistema2;
	}

	public void setUsuariosSistema2(UsuariosSistema usuariosSistema2) {
		this.usuariosSistema2 = usuariosSistema2;
	}

}