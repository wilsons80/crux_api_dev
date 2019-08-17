package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documentos_atividades database table.
 * 
 */
@Entity
@Table(name="documentos_atividades")
@NamedQuery(name="DocumentosAtividade.findAll", query="SELECT d FROM DocumentosAtividade d")
public class DocumentosAtividade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ds_documento_atividade")
	private String dsDocumentoAtividade;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_documento_atividade")
	private Long idDocumentoAtividade;

	@Column(name="tx_documento_atividade")
	private String txDocumentoAtividade;

	//bi-directional many-to-one association to Atividade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade")
	private Atividade atividade;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

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

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}