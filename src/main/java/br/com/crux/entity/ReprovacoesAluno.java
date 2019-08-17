package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the reprovacoes_aluno database table.
 * 
 */
@Entity
@Table(name="reprovacoes_aluno")
@NamedQuery(name="ReprovacoesAluno.findAll", query="SELECT r FROM ReprovacoesAluno r")
public class ReprovacoesAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_reprovacao_aluno")
	private Long idReprovacaoAluno;

	@Column(name="ds_reprovacao_aluno")
	private String dsReprovacaoAluno;

	@Column(name="ds_serie_reprovacao")
	private String dsSerieReprovacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_reprovacao_aluno")
	private Date dtReprovacaoAluno;

	@Column(name="qtd_reprovacao")
	private BigDecimal qtdReprovacao;

	//bi-directional many-to-one association to Aluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aluno")
	private Aluno aluno;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public ReprovacoesAluno() {
	}

	public Long getIdReprovacaoAluno() {
		return this.idReprovacaoAluno;
	}

	public void setIdReprovacaoAluno(Long idReprovacaoAluno) {
		this.idReprovacaoAluno = idReprovacaoAluno;
	}

	public String getDsReprovacaoAluno() {
		return this.dsReprovacaoAluno;
	}

	public void setDsReprovacaoAluno(String dsReprovacaoAluno) {
		this.dsReprovacaoAluno = dsReprovacaoAluno;
	}

	public String getDsSerieReprovacao() {
		return this.dsSerieReprovacao;
	}

	public void setDsSerieReprovacao(String dsSerieReprovacao) {
		this.dsSerieReprovacao = dsSerieReprovacao;
	}

	public Date getDtReprovacaoAluno() {
		return this.dtReprovacaoAluno;
	}

	public void setDtReprovacaoAluno(Date dtReprovacaoAluno) {
		this.dtReprovacaoAluno = dtReprovacaoAluno;
	}

	public BigDecimal getQtdReprovacao() {
		return this.qtdReprovacao;
	}

	public void setQtdReprovacao(BigDecimal qtdReprovacao) {
		this.qtdReprovacao = qtdReprovacao;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}