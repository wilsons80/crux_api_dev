package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the empresas database table.
 * 
 */
@Entity
@Table(name="empresas")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_empresa")
	private Long idEmpresa;

	@Column(name="cd_empresa")
	private String cdEmpresa;

	@Column(name="cs_categoria_empresa")
	private String csCategoriaEmpresa;

	@Column(name="cs_tipo_empresa")
	private String csTipoEmpresa;

	@Column(name="ds_bairro")
	private String dsBairro;

	@Column(name="ds_categoria_empresa")
	private String dsCategoriaEmpresa;

	@Column(name="ds_email")
	private String dsEmail;

	@Column(name="ds_endereco")
	private String dsEndereco;

	@Column(name="ds_home_page")
	private String dsHomePage;

	@Column(name="ds_tipo_empresa")
	private String dsTipoEmpresa;

	@Column(name="nm_cidade")
	private String nmCidade;

	@Column(name="nm_fantasia")
	private String nmFantasia;

	@Column(name="nm_razao_social")
	private String nmRazaoSocial;

	@Column(name="nr_cep")
	private BigDecimal nrCep;

	@Column(name="nr_cnpj")
	private String nrCnpj;

	@Column(name="nr_inscricao_estadual")
	private String nrInscricaoEstadual;

	@Column(name="nr_inscricao_municipal")
	private String nrInscricaoMunicipal;

	@Column(name="nr_telefone")
	private String nrTelefone;

	@Column(name="st_ativa")
	private String stAtiva;

	@Column(name="st_autoriza_email")
	private String stAutorizaEmail;

	@Column(name="uf_empresa")
	private String ufEmpresa;

	@Column(name="vl_icms")
	private BigDecimal vlIcms;

	//bi-directional many-to-one association to ContatosEmpresa
	@OneToMany(mappedBy="empresa")
	private List<ContatosEmpresa> contatosEmpresas;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	//bi-directional many-to-one association to EntidadesSociai
	@OneToMany(mappedBy="empresa")
	private List<EntidadesSociai> entidadesSociais;

	//bi-directional many-to-one association to Fatura
	@OneToMany(mappedBy="empresa")
	private List<Fatura> faturas;

	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="empresa")
	private List<Funcionario> funcionarios;

	public Empresa() {
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getCdEmpresa() {
		return this.cdEmpresa;
	}

	public void setCdEmpresa(String cdEmpresa) {
		this.cdEmpresa = cdEmpresa;
	}

	public String getCsCategoriaEmpresa() {
		return this.csCategoriaEmpresa;
	}

	public void setCsCategoriaEmpresa(String csCategoriaEmpresa) {
		this.csCategoriaEmpresa = csCategoriaEmpresa;
	}

	public String getCsTipoEmpresa() {
		return this.csTipoEmpresa;
	}

	public void setCsTipoEmpresa(String csTipoEmpresa) {
		this.csTipoEmpresa = csTipoEmpresa;
	}

	public String getDsBairro() {
		return this.dsBairro;
	}

	public void setDsBairro(String dsBairro) {
		this.dsBairro = dsBairro;
	}

	public String getDsCategoriaEmpresa() {
		return this.dsCategoriaEmpresa;
	}

	public void setDsCategoriaEmpresa(String dsCategoriaEmpresa) {
		this.dsCategoriaEmpresa = dsCategoriaEmpresa;
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

	public String getDsHomePage() {
		return this.dsHomePage;
	}

	public void setDsHomePage(String dsHomePage) {
		this.dsHomePage = dsHomePage;
	}

	public String getDsTipoEmpresa() {
		return this.dsTipoEmpresa;
	}

	public void setDsTipoEmpresa(String dsTipoEmpresa) {
		this.dsTipoEmpresa = dsTipoEmpresa;
	}

	public String getNmCidade() {
		return this.nmCidade;
	}

	public void setNmCidade(String nmCidade) {
		this.nmCidade = nmCidade;
	}

	public String getNmFantasia() {
		return this.nmFantasia;
	}

	public void setNmFantasia(String nmFantasia) {
		this.nmFantasia = nmFantasia;
	}

	public String getNmRazaoSocial() {
		return this.nmRazaoSocial;
	}

	public void setNmRazaoSocial(String nmRazaoSocial) {
		this.nmRazaoSocial = nmRazaoSocial;
	}

	public BigDecimal getNrCep() {
		return this.nrCep;
	}

	public void setNrCep(BigDecimal nrCep) {
		this.nrCep = nrCep;
	}

	public String getNrCnpj() {
		return this.nrCnpj;
	}

	public void setNrCnpj(String nrCnpj) {
		this.nrCnpj = nrCnpj;
	}

	public String getNrInscricaoEstadual() {
		return this.nrInscricaoEstadual;
	}

	public void setNrInscricaoEstadual(String nrInscricaoEstadual) {
		this.nrInscricaoEstadual = nrInscricaoEstadual;
	}

	public String getNrInscricaoMunicipal() {
		return this.nrInscricaoMunicipal;
	}

	public void setNrInscricaoMunicipal(String nrInscricaoMunicipal) {
		this.nrInscricaoMunicipal = nrInscricaoMunicipal;
	}

	public String getNrTelefone() {
		return this.nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getStAtiva() {
		return this.stAtiva;
	}

	public void setStAtiva(String stAtiva) {
		this.stAtiva = stAtiva;
	}

	public String getStAutorizaEmail() {
		return this.stAutorizaEmail;
	}

	public void setStAutorizaEmail(String stAutorizaEmail) {
		this.stAutorizaEmail = stAutorizaEmail;
	}

	public String getUfEmpresa() {
		return this.ufEmpresa;
	}

	public void setUfEmpresa(String ufEmpresa) {
		this.ufEmpresa = ufEmpresa;
	}

	public BigDecimal getVlIcms() {
		return this.vlIcms;
	}

	public void setVlIcms(BigDecimal vlIcms) {
		this.vlIcms = vlIcms;
	}

	public List<ContatosEmpresa> getContatosEmpresas() {
		return this.contatosEmpresas;
	}

	public void setContatosEmpresas(List<ContatosEmpresa> contatosEmpresas) {
		this.contatosEmpresas = contatosEmpresas;
	}

	public ContatosEmpresa addContatosEmpresa(ContatosEmpresa contatosEmpresa) {
		getContatosEmpresas().add(contatosEmpresa);
		contatosEmpresa.setEmpresa(this);

		return contatosEmpresa;
	}

	public ContatosEmpresa removeContatosEmpresa(ContatosEmpresa contatosEmpresa) {
		getContatosEmpresas().remove(contatosEmpresa);
		contatosEmpresa.setEmpresa(null);

		return contatosEmpresa;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

	public List<EntidadesSociai> getEntidadesSociais() {
		return this.entidadesSociais;
	}

	public void setEntidadesSociais(List<EntidadesSociai> entidadesSociais) {
		this.entidadesSociais = entidadesSociais;
	}

	public EntidadesSociai addEntidadesSociai(EntidadesSociai entidadesSociai) {
		getEntidadesSociais().add(entidadesSociai);
		entidadesSociai.setEmpresa(this);

		return entidadesSociai;
	}

	public EntidadesSociai removeEntidadesSociai(EntidadesSociai entidadesSociai) {
		getEntidadesSociais().remove(entidadesSociai);
		entidadesSociai.setEmpresa(null);

		return entidadesSociai;
	}

	public List<Fatura> getFaturas() {
		return this.faturas;
	}

	public void setFaturas(List<Fatura> faturas) {
		this.faturas = faturas;
	}

	public Fatura addFatura(Fatura fatura) {
		getFaturas().add(fatura);
		fatura.setEmpresa(this);

		return fatura;
	}

	public Fatura removeFatura(Fatura fatura) {
		getFaturas().remove(fatura);
		fatura.setEmpresa(null);

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
		funcionario.setEmpresa(this);

		return funcionario;
	}

	public Funcionario removeFuncionario(Funcionario funcionario) {
		getFuncionarios().remove(funcionario);
		funcionario.setEmpresa(null);

		return funcionario;
	}

}