package br.com.crux.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the produtos database table.
 * 
 */
@Entity
@Table(name="produtos")
public class Produto  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produto", unique=true, nullable=false, precision=10)
	private Long idProduto;

	@Column(name="cd_unidade_medida", length=20)
	private String cdUnidadeMedida;

	@Column(name="ds_unidade_medida", length=200)
	private String dsUnidadeMedida;

	@Column(name="nm_produto", length=200)
	private String nmProduto;

	@Column(name="nm_produto_nf", length=200)
	private String nmProdutoNf;

	//bi-directional many-to-one association to Estoque
	@OneToMany(mappedBy="produto")
	private List<Estoque> estoques;

	//bi-directional many-to-one association to ItensFatura
	@OneToMany(mappedBy="produto")
	private List<ItensFatura> itensFaturas;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="produto")
	private List<Pedido> pedidos;

	//bi-directional many-to-one association to ProdutosAtividade
	@OneToMany(mappedBy="produto")
	private List<ProdutosAtividade> produtosAtividades;

	public Produto() {
	}

	public Long getIdProduto() {
		return this.idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getCdUnidadeMedida() {
		return this.cdUnidadeMedida;
	}

	public void setCdUnidadeMedida(String cdUnidadeMedida) {
		this.cdUnidadeMedida = cdUnidadeMedida;
	}

	public String getDsUnidadeMedida() {
		return this.dsUnidadeMedida;
	}

	public void setDsUnidadeMedida(String dsUnidadeMedida) {
		this.dsUnidadeMedida = dsUnidadeMedida;
	}

	public String getNmProduto() {
		return this.nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public String getNmProdutoNf() {
		return this.nmProdutoNf;
	}

	public void setNmProdutoNf(String nmProdutoNf) {
		this.nmProdutoNf = nmProdutoNf;
	}

	public List<Estoque> getEstoques() {
		return this.estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque addEstoque(Estoque estoque) {
		getEstoques().add(estoque);
		estoque.setProduto(this);

		return estoque;
	}

	public Estoque removeEstoque(Estoque estoque) {
		getEstoques().remove(estoque);
		estoque.setProduto(null);

		return estoque;
	}

	public List<ItensFatura> getItensFaturas() {
		return this.itensFaturas;
	}

	public void setItensFaturas(List<ItensFatura> itensFaturas) {
		this.itensFaturas = itensFaturas;
	}

	public ItensFatura addItensFatura(ItensFatura itensFatura) {
		getItensFaturas().add(itensFatura);
		itensFatura.setProduto(this);

		return itensFatura;
	}

	public ItensFatura removeItensFatura(ItensFatura itensFatura) {
		getItensFaturas().remove(itensFatura);
		itensFatura.setProduto(null);

		return itensFatura;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setProduto(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setProduto(null);

		return pedido;
	}

	public List<ProdutosAtividade> getProdutosAtividades() {
		return this.produtosAtividades;
	}

	public void setProdutosAtividades(List<ProdutosAtividade> produtosAtividades) {
		this.produtosAtividades = produtosAtividades;
	}

	public ProdutosAtividade addProdutosAtividade(ProdutosAtividade produtosAtividade) {
		getProdutosAtividades().add(produtosAtividade);
		produtosAtividade.setProduto(this);

		return produtosAtividade;
	}

	public ProdutosAtividade removeProdutosAtividade(ProdutosAtividade produtosAtividade) {
		getProdutosAtividades().remove(produtosAtividade);
		produtosAtividade.setProduto(null);

		return produtosAtividade;
	}

}