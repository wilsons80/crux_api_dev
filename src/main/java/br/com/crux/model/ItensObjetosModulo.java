package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the itens_objetos_modulos database table.
 * 
 */
@Entity
@Table(name="itens_objetos_modulos")
public class ItensObjetosModulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item_objeto_modulo", unique=true, nullable=false, precision=10)
	private Long idItemObjetoModulo;

	@Column(name="ds_codigo")
	private byte[] dsCodigo;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_alteracao")
	private Date dtAlteracao;

	@Column(name="nm_item", nullable=false, length=200)
	private String nmItem;

	@Column(name="tx_observacao", length=4000)
	private String txObservacao;

	//bi-directional many-to-one association to ObjetosModulo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_objeto_modulo", nullable=false)
	private ObjetosModulo objetosModulo;

	public ItensObjetosModulo() {
	}

	public Long getIdItemObjetoModulo() {
		return this.idItemObjetoModulo;
	}

	public void setIdItemObjetoModulo(Long idItemObjetoModulo) {
		this.idItemObjetoModulo = idItemObjetoModulo;
	}

	public byte[] getDsCodigo() {
		return this.dsCodigo;
	}

	public void setDsCodigo(byte[] dsCodigo) {
		this.dsCodigo = dsCodigo;
	}

	public Date getDtAlteracao() {
		return this.dtAlteracao;
	}

	public void setDtAlteracao(Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public String getNmItem() {
		return this.nmItem;
	}

	public void setNmItem(String nmItem) {
		this.nmItem = nmItem;
	}

	public String getTxObservacao() {
		return this.txObservacao;
	}

	public void setTxObservacao(String txObservacao) {
		this.txObservacao = txObservacao;
	}

	public ObjetosModulo getObjetosModulo() {
		return this.objetosModulo;
	}

	public void setObjetosModulo(ObjetosModulo objetosModulo) {
		this.objetosModulo = objetosModulo;
	}

}