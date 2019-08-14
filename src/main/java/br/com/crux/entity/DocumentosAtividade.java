package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documentos_atividades database table.
 * 
 */
@Entity
@Table(name="documentos_atividades")
public class DocumentosAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

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