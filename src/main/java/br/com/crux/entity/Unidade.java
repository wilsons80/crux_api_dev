package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the unidades database table.
 * 
 */
@Entity
@Table(name="unidades")
@NamedQuery(name="Unidade.findAll", query="SELECT u FROM Unidade u")
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_unidade")
	private Long idUnidade;

	@Column(name="cd_unidade")
	private String cdUnidade;

	@Column(name="cs_situacao_imovel")
	private String csSituacaoImovel;

	@Column(name="cs_tipo_unidade")
	private String csTipoUnidade;

	@Column(name="ds_bairro")
	private String dsBairro;

	@Column(name="ds_email")
	private String dsEmail;

	@Column(name="ds_endereco")
	private String dsEndereco;

	@Column(name="ds_estrutura_fisica_imovel")
	private String dsEstruturaFisicaImovel;

	@Column(name="ds_missao")
	private String dsMissao;

	@Column(name="ds_situacao_imovel")
	private String dsSituacaoImovel;

	@Column(name="ds_visao")
	private String dsVisao;

	@Column(name="nm_unidade")
	private String nmUnidade;

	@Column(name="nr_cep")
	private BigDecimal nrCep;

	@Column(name="nr_fone_celular")
	private String nrFoneCelular;

	@Column(name="nr_telefone")
	private String nrTelefone;

	@Column(name="sg_uf_endereco")
	private String sgUfEndereco;

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

	//bi-directional many-to-one association to Perspectiva
	@OneToMany(mappedBy="unidade")
	private List<Perspectiva> perspectivas;

	//bi-directional many-to-one association to Arquivo
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_arquivo_logomarca")
	private Arquivo arquivo;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	//bi-directional many-to-one association to UsuariosUnidade
	@OneToMany(mappedBy="unidade")
	private List<UsuariosUnidade> usuariosUnidades;

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

	public String getCsTipoUnidade() {
		return this.csTipoUnidade;
	}

	public void setCsTipoUnidade(String csTipoUnidade) {
		this.csTipoUnidade = csTipoUnidade;
	}

	public String getDsBairro() {
		return this.dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public String getDsEmail() {
		return this.dsEmail;
	}

	public void setDsEmail(String dsEmail) {
		this.dsEmail = dsEmail;
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

	public String getDsMissao() {
		return this.dsMissao;
	}

	public void setDsMissao(String dsMissao) {
		this.dsMissao = dsMissao;
	}

	public String getDsSituacaoImovel() {
		return this.dsSituacaoImovel;
	}

	public void setDsSituacaoImovel(String dsSituacaoImovel) {
		this.dsSituacaoImovel = dsSituacaoImovel;
	}

	public String getDsVisao() {
		return this.dsVisao;
	}

	public void setDsVisao(String dsVisao) {
		this.dsVisao = dsVisao;
	}

	public String getNmUnidade() {
		return this.nmUnidade;
	}

	public void setNmUnidade(String nmUnidade) {
		this.nmUnidade = nmUnidade;
	}

	public BigDecimal getNrCep() {
		return this.nrCep;
	}

	public void setNrCep(BigDecimal nrCep) {
		this.nrCep = nrCep;
	}

	public String getNrFoneCelular() {
		return this.nrFoneCelular;
	}

	public void setNrFoneCelular(String nrFoneCelular) {
		this.nrFoneCelular = nrFoneCelular;
	}

	public String getNrTelefone() {
		return this.nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getSgUfEndereco() {
		return this.sgUfEndereco;
	}

	public void setSgUfEndereco(String sgUfEndereco) {
		this.sgUfEndereco = sgUfEndereco;
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

	public List<Perspectiva> getPerspectivas() {
		return this.perspectivas;
	}

	public void setPerspectivas(List<Perspectiva> perspectivas) {
		this.perspectivas = perspectivas;
	}

	public Perspectiva addPerspectiva(Perspectiva perspectiva) {
		getPerspectivas().add(perspectiva);
		perspectiva.setUnidade(this);

		return perspectiva;
	}

	public Perspectiva removePerspectiva(Perspectiva perspectiva) {
		getPerspectivas().remove(perspectiva);
		perspectiva.setUnidade(null);

		return perspectiva;
	}

	public Arquivo getArquivo() {
		return this.arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

	public List<UsuariosUnidade> getUsuariosUnidades() {
		return this.usuariosUnidades;
	}

	public void setUsuariosUnidades(List<UsuariosUnidade> usuariosUnidades) {
		this.usuariosUnidades = usuariosUnidades;
	}

	public UsuariosUnidade addUsuariosUnidade(UsuariosUnidade usuariosUnidade) {
		getUsuariosUnidades().add(usuariosUnidade);
		usuariosUnidade.setUnidade(this);

		return usuariosUnidade;
	}

	public UsuariosUnidade removeUsuariosUnidade(UsuariosUnidade usuariosUnidade) {
		getUsuariosUnidades().remove(usuariosUnidade);
		usuariosUnidade.setUnidade(null);

		return usuariosUnidade;
	}

}