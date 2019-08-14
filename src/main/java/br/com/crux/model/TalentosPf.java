package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the talentos_pf database table.
 * 
 */
@Entity
@Table(name="talentos_pf")
public class TalentosPf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_talento_pf", unique=true, nullable=false, precision=10)
	private Long idTalentoPf;

	@Column(name="ds_resposta_talento", nullable=false, length=200)
	private String dsRespostaTalento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_resposta_talento")
	private Date dtRespostaTalento;

	@Column(name="nr_nota_competencia")
	private Timestamp nrNotaCompetencia;

	@Column(name="tx_observacao", length=1000)
	private String txObservacao;

	//bi-directional many-to-one association to AcoesCompetencia
	@OneToMany(mappedBy="talentosPf")
	private List<AcoesCompetencia> acoesCompetencias;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario", nullable=false)
	private Funcionario funcionario;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica", nullable=false)
	private PessoasFisica pessoasFisica;

	//bi-directional many-to-one association to Questionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="questionarios_id_quetionario", nullable=false)
	private Questionario questionario;

	public TalentosPf() {
	}

	public Long getIdTalentoPf() {
		return this.idTalentoPf;
	}

	public void setIdTalentoPf(Long idTalentoPf) {
		this.idTalentoPf = idTalentoPf;
	}

	public String getDsRespostaTalento() {
		return this.dsRespostaTalento;
	}

	public void setDsRespostaTalento(String dsRespostaTalento) {
		this.dsRespostaTalento = dsRespostaTalento;
	}

	public Date getDtRespostaTalento() {
		return this.dtRespostaTalento;
	}

	public void setDtRespostaTalento(Date dtRespostaTalento) {
		this.dtRespostaTalento = dtRespostaTalento;
	}

	public Timestamp getNrNotaCompetencia() {
		return this.nrNotaCompetencia;
	}

	public void setNrNotaCompetencia(Timestamp nrNotaCompetencia) {
		this.nrNotaCompetencia = nrNotaCompetencia;
	}

	public String getTxObservacao() {
		return this.txObservacao;
	}

	public void setTxObservacao(String txObservacao) {
		this.txObservacao = txObservacao;
	}

	public List<AcoesCompetencia> getAcoesCompetencias() {
		return this.acoesCompetencias;
	}

	public void setAcoesCompetencias(List<AcoesCompetencia> acoesCompetencias) {
		this.acoesCompetencias = acoesCompetencias;
	}

	public AcoesCompetencia addAcoesCompetencia(AcoesCompetencia acoesCompetencia) {
		getAcoesCompetencias().add(acoesCompetencia);
		acoesCompetencia.setTalentosPf(this);

		return acoesCompetencia;
	}

	public AcoesCompetencia removeAcoesCompetencia(AcoesCompetencia acoesCompetencia) {
		getAcoesCompetencias().remove(acoesCompetencia);
		acoesCompetencia.setTalentosPf(null);

		return acoesCompetencia;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public PessoasFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoasFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public Questionario getQuestionario() {
		return this.questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

}