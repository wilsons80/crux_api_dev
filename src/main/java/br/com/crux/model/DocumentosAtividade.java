package br.com.crux.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the documentos_atividades database table.
 * 
 */
@Entity
@Table(name="documentos_atividades")
public class DocumentosAtividade  {

	@Column(name="ds_documento_atividade", nullable=false, length=200)
	private String dsDocumentoAtividade;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_documento_atividade", nullable=false, precision=10)
	private Long idDocumentoAtividade;

	@Column(name="tx_documento_atividade", length=200)
	private String txDocumentoAtividade;

	//bi-directional many-to-one association to Atividade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade", nullable=false)
	private Atividade atividade;

	public DocumentosAtividade() {
	}

	public String getDsDocumentoAtividade() {
		return this.dsDocumentoAtividade;
	}

	public void setDsDocumentoAtividade(String dsDocumentoAtividade) {
		this.dsDocumentoAtividade = dsDocumentoAtividade;
	}

	public Long getIdDocumentoAtividade() {
		return this.idDocumentoAtividade;
	}

	public void setIdDocumentoAtividade(Long idDocumentoAtividade) {
		this.idDocumentoAtividade = idDocumentoAtividade;
	}

	public String getTxDocumentoAtividade() {
		return this.txDocumentoAtividade;
	}

	public void setTxDocumentoAtividade(String txDocumentoAtividade) {
		this.txDocumentoAtividade = txDocumentoAtividade;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

}