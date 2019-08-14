package br.com.crux.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the estoques database table.
 * 
 */
@Entity
@Table(name="estoques")
public class Estoque implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_estoque", unique=true, nullable=false, precision=10)
	private Long idEstoque;

	@Column(name="cs_tipo_mov_estoque", length=1)
	private String csTipoMovEstoque;

	@Column(name="ds_mov_estoque", length=200)
	private String dsMovEstoque;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_atz_estoque")
	private Date dtAtzEstoque;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_mov_estoque")
	private Date dtMovEstoque;

	@Column(name="qt_estoque", precision=10, scale=2)
	private BigDecimal qtEstoque;

	@Column(name="qt_mov_estoque", precision=10, scale=2)
	private BigDecimal qtMovEstoque;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_funcionario", nullable=false)
	private Funcionario funcionario;

	//bi-directional many-to-one association to Produto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_produto", nullable=false)
	private Produto produto;

	//bi-directional many-to-one association to Unidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_unidade", nullable=false)
	private Unidade unidade;

	public Estoque() {
	}

	public Long getIdEstoque() {
		return this.idEstoque;
	}

	public void setIdEstoque(Long idEstoque) {
		this.idEstoque = idEstoque;
	}

	public String getCsTipoMovEstoque() {
		return this.csTipoMovEstoque;
	}

	public void setCsTipoMovEstoque(String csTipoMovEstoque) {
		this.csTipoMovEstoque = csTipoMovEstoque;
	}

	public String getDsMovEstoque() {
		return this.dsMovEstoque;
	}

	public void setDsMovEstoque(String dsMovEstoque) {
		this.dsMovEstoque = dsMovEstoque;
	}

	public Date getDtAtzEstoque() {
		return this.dtAtzEstoque;
	}

	public void setDtAtzEstoque(Date dtAtzEstoque) {
		this.dtAtzEstoque = dtAtzEstoque;
	}

	public Date getDtMovEstoque() {
		return this.dtMovEstoque;
	}

	public void setDtMovEstoque(Date dtMovEstoque) {
		this.dtMovEstoque = dtMovEstoque;
	}

	public BigDecimal getQtEstoque() {
		return this.qtEstoque;
	}

	public void setQtEstoque(BigDecimal qtEstoque) {
		this.qtEstoque = qtEstoque;
	}

	public BigDecimal getQtMovEstoque() {
		return this.qtMovEstoque;
	}

	public void setQtMovEstoque(BigDecimal qtMovEstoque) {
		this.qtMovEstoque = qtMovEstoque;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Unidade getUnidade() {
		return this.unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

}