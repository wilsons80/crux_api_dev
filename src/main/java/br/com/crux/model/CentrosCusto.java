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
 * The persistent class for the centros_custo database table.
 * 
 */
@Entity
@Table(name="centros_custo")
public class CentrosCusto  {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_centro_custo", unique=true, nullable=false, precision=10)
	private Long idCentroCusto;

	@Column(name="nm_centro_custo", length=200)
	private String nmCentroCusto;

	@Column(name="nr_centro_custo", length=20)
	private String nrCentroCusto;

	//bi-directional many-to-one association to ItensFatura
	@OneToMany(mappedBy="centrosCusto")
	private List<ItensFatura> itensFaturas;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="centrosCusto")
	private List<Pedido> pedidos;

	public CentrosCusto() {
	}

	public Long getIdCentroCusto() {
		return this.idCentroCusto;
	}

	public void setIdCentroCusto(Long idCentroCusto) {
		this.idCentroCusto = idCentroCusto;
	}

	public String getNmCentroCusto() {
		return this.nmCentroCusto;
	}

	public void setNmCentroCusto(String nmCentroCusto) {
		this.nmCentroCusto = nmCentroCusto;
	}

	public String getNrCentroCusto() {
		return this.nrCentroCusto;
	}

	public void setNrCentroCusto(String nrCentroCusto) {
		this.nrCentroCusto = nrCentroCusto;
	}

	public List<ItensFatura> getItensFaturas() {
		return this.itensFaturas;
	}

	public void setItensFaturas(List<ItensFatura> itensFaturas) {
		this.itensFaturas = itensFaturas;
	}

	public ItensFatura addItensFatura(ItensFatura itensFatura) {
		getItensFaturas().add(itensFatura);
		itensFatura.setCentrosCusto(this);

		return itensFatura;
	}

	public ItensFatura removeItensFatura(ItensFatura itensFatura) {
		getItensFaturas().remove(itensFatura);
		itensFatura.setCentrosCusto(null);

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
		pedido.setCentrosCusto(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setCentrosCusto(null);

		return pedido;
	}

}