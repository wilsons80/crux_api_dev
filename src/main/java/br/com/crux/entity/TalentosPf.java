package br.com.crux.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.crux.infra.constantes.Constantes;


@Entity
@Table(name="talentos_pf")
public class TalentosPf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_talento_pf")
	@SequenceGenerator(name = "sq_id_talento_pf", sequenceName = "sq_id_talento_pf", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_talento_pf")
	private Long idTalentoPf;

	@Column(name="ds_resposta_talento")
	private String dsRespostaTalento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_resposta_talento")
	private Date dtRespostaTalento;

	@Column(name="nr_nota_competencia")
	private Timestamp nrNotaCompetencia;

	@Column(name="tx_observacao")
	private String txObservacao;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica")
	private PessoaFisica pessoasFisica;

	//bi-directional many-to-one association to Questionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="questionarios_id_quetionario")
	private Questionario questionario;

	@Column(name="id_usuario_apl")
	private Long usuariosAlteracao;

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


	public PessoaFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoaFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public Questionario getQuestionario() {
		return this.questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Long getUsuariosAlteracao() {
		return this.usuariosAlteracao;
	}

	public void setUsuariosSistema(Long usuariosAlteracao) {
		this.usuariosAlteracao = usuariosAlteracao;
	}

}