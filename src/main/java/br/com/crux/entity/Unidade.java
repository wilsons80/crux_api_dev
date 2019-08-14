package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unidades database table.
 * 
 */
@Entity
@Table(name="unidades")
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_unidade", unique=true, nullable=false, precision=10)
	private Long idUnidade;

	@Column(name="cd_unidade", nullable=false, length=6)
	private String cdUnidade;

	@Column(name="cs_situacao_imovel", nullable=false, length=1)
	private String csSituacaoImovel;

	@Column(name="ds_endereco", nullable=false, length=200)
	private String dsEndereco;

	@Column(name="ds_estrutura_fisica_imovel", length=200)
	private String dsEstruturaFisicaImovel;

	@Column(name="ds_situacao_imovel", length=200)
	private String dsSituacaoImovel;

	@Column(name="nm_unidade", nullable=false, length=100)
	private String nmUnidade;

	@Column(name="nr_telefone", nullable=false, length=15)
	private String nrTelefone;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="unidade")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to Atividade
	@OneToMany(mappedBy="unidade")
	private List<Atividade> atividades;

	//bi-directional many-to-one association to ContasBancaria
	@OneToMany(mappedBy="unidade")
	private List<ContasBancaria> contasBancarias;

	//bi-directional many-to-one association to DepartamentosUnidade
	@OneToMany(mappedBy="unidade")
	private List<DepartamentosUnidade> departamentosUnidades;

	//bi-directional many-to-one association to Estoque
	@OneToMany(mappedBy="unidade")
	private List<Estoque> estoques;

	//bi-directional many-to-one association to Fatura
	@OneToMany(mappedBy="unidade")
	private List<Fatura> faturas;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="unidade")
	private List<Funcionario> funcionarios;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="unidade")
	private List<Pedido> pedidos;

	//bi-directional many-to-one association to Arquivo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_arquivo")
	private Arquivo arquivo;

	//bi-directional many-to-one association to Entidade
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_entidade", nullable=false)
	private Entidade entidade;

	public Unidade() {
	}

	public Long getIdUnidade() {
		return this.idUnidade;
	}

	public void setIdUnidade(Long idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getCdUnidade() {
		return this.cdUnidade;
	}

	public void setCdUnidade(String cdUnidade) {
		this.cdUnidade = cdUnidade;
	}

	public String getCsSituacaoImovel() {
		return this.csSituacaoImovel;
	}

	public void setCsSituacaoImovel(String csSituacaoImovel) {
		this.csSituacaoImovel = csSituacaoImovel;
	}

	public String getDsEndereco() {
		return this.dsEndereco;
	}

	public void setDsEndereco(String dsEndereco) {
		this.dsEndereco = dsEndereco;
	}

	public String getDsEstruturaFisicaImovel() {
		return this.dsEstruturaFisicaImovel;
	}

	public void setDsEstruturaFisicaImovel(String dsEstruturaFisicaImovel) {
		this.dsEstruturaFisicaImovel = dsEstruturaFisicaImovel;
	}

	public String getDsSituacaoImovel() {
		return this.dsSituacaoImovel;
	}

	public void setDsSituacaoImovel(String dsSituacaoImovel) {
		this.dsSituacaoImovel = dsSituacaoImovel;
	}

	public String getNmUnidade() {
		return this.nmUnidade;
	}

	public void setNmUnidade(String nmUnidade) {
		this.nmUnidade = nmUnidade;
	}

	public String getNrTelefone() {
		return this.nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setUnidade(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setUnidade(null);

		return aluno;
	}

	public List<Atividade> getAtividades() {
		return this.atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Atividade addAtividade(Atividade atividade) {
		getAtividades().add(atividade);
		atividade.setUnidade(this);

		return atividade;
	}

	public Atividade removeAtividade(Atividade atividade) {
		getAtividades().remove(atividade);
		atividade.setUnidade(null);

		return atividade;
	}

	public List<ContasBancaria> getContasBancarias() {
		return this.contasBancarias;
	}

	public void setContasBancarias(List<ContasBancaria> contasBancarias) {
		this.contasBancarias = contasBancarias;
	}

	public ContasBancaria addContasBancaria(ContasBancaria contasBancaria) {
		getContasBancarias().add(contasBancaria);
		contasBancaria.setUnidade(this);

		return contasBancaria;
	}

	public ContasBancaria removeContasBancaria(ContasBancaria contasBancaria) {
		getContasBancarias().remove(contasBancaria);
		contasBancaria.setUnidade(null);

		return contasBancaria;
	}

	public List<DepartamentosUnidade> getDepartamentosUnidades() {
		return this.departamentosUnidades;
	}

	public void setDepartamentosUnidades(List<DepartamentosUnidade> departamentosUnidades) {
		this.departamentosUnidades = departamentosUnidades;
	}

	public DepartamentosUnidade addDepartamentosUnidade(DepartamentosUnidade departamentosUnidade) {
		getDepartamentosUnidades().add(departamentosUnidade);
		departamentosUnidade.setUnidade(this);

		return departamentosUnidade;
	}

	public DepartamentosUnidade removeDepartamentosUnidade(DepartamentosUnidade departamentosUnidade) {
		getDepartamentosUnidades().remove(departamentosUnidade);
		departamentosUnidade.setUnidade(null);

		return departamentosUnidade;
	}

	public List<Estoque> getEstoques() {
		return this.estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

	public Estoque addEstoque(Estoque estoque) {
		getEstoques().add(estoque);
		estoque.setUnidade(this);

		return estoque;
	}

	public Estoque removeEstoque(Estoque estoque) {
		getEstoques().remove(estoque);
		estoque.setUnidade(null);

		return estoque;
	}

	public List<Fatura> getFaturas() {
		return this.faturas;
	}

	public void setFaturas(List<Fatura> faturas) {
		this.faturas = faturas;
	}

	public Fatura addFatura(Fatura fatura) {
		getFaturas().add(fatura);
		fatura.setUnidade(this);

		return fatura;
	}

	public Fatura removeFatura(Fatura fatura) {
		getFaturas().remove(fatura);
		fatura.setUnidade(null);

		return fatura;
	}

	public List<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Funcionario addFuncionario(Funcionario funcionario) {
		getFuncionarios().add(funcionario);
		funcionario.setUnidade(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setUnidade(null);

		return funcionario;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setUnidade(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setUnidade(null);

		return pedido;
	}

	public Arquivo getArquivo() {
		return this.arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public Entidade getEntidade() {
		return this.entidade;
	}

	public void setEntidade(Entidade entidade) {
		this.entidade = entidade;
	}

}