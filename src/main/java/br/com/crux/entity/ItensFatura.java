package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the itens_faturas database table.
 * 
 */
@Entity
@Table(name="itens_faturas")
public class ItensFatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item_fatura", unique=true, nullable=false, precision=10)
	private Long idItemFatura;

	@Column(name="ds_item_fatura", length=200)
	private String dsItemFatura;

	@Column(name="qt_item_fatura", precision=131089)
	private BigDecimal qtItemFatura;

	@Column(name="vl_item_fatura", precision=10, scale=2)
	private BigDecimal vlItemFatura;

	//bi-directional many-to-one association to CentrosCusto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_centro_custo", nullable=false)
	private CentrosCusto centrosCusto;

	//bi-directional many-to-one association to Fatura
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_fatura", nullable=false)
	private Fatura fatura;

	//bi-directional many-to-one association to Pedido
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pedido")
	private Pedido pedido;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produto")
	private Produto produto;

	//bi-directional many-to-one association to Servico
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_servico")
	private Servico servico;

	public ItensFatura() {
	}

	public Long getIdItemFatura() {
		return this.idItemFatura;
	}

	public void setIdItemFatura(Long idItemFatura) {
		this.idItemFatura = idItemFatura;
	}

	public String getDsItemFatura() {
		return this.dsItemFatura;
	}

	public void setDsItemFatura(String dsItemFatura) {
		this.dsItemFatura = dsItemFatura;
	}

	public BigDecimal getQtItemFatura() {
		return this.qtItemFatura;
	}

	public void setQtItemFatura(BigDecimal qtItemFatura) {
		this.qtItemFatura = qtItemFatura;
	}

	public BigDecimal getVlItemFatura() {
		return this.vlItemFatura;
	}

	public void setVlItemFatura(BigDecimal vlItemFatura) {
		this.vlItemFatura = vlItemFatura;
	}

	public CentrosCusto getCentrosCusto() {
		return this.centrosCusto;
	}

	public void setCentrosCusto(CentrosCusto centrosCusto) {
		this.centrosCusto = centrosCusto;
	}

	public Fatura getFatura() {
		return this.fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Servico getServico() {
		return this.servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}