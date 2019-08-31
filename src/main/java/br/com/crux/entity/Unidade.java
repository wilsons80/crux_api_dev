package br.com.crux.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import br.com.crux.enums.ClassificadorSituacaoImovel;
import br.com.crux.infra.constantes.Constantes;

@Entity
@Table(name = "unidades")
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_unidade")
	@SequenceGenerator(name = "sq_id_unidade", sequenceName = "sq_id_unidade", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name = "id_unidade")
	private Long idUnidade;

	@Column(name = "cd_unidade")
	private String siglaUnidade;

	@Column(name = "nm_unidade")
	private String nomeUnidade;

	@Column(name = "ds_endereco")
	private String endereco;

	@Column(name = "nr_telefone")
	private String telefone;


	@Column(name = "ds_situacao_imovel")
	private String descricaoSituacaoImovel;

	@Column(name = "ds_estrutura_fisica_imovel")
	private String descricaoEstruturaFisicaImovel;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_arquivo_logomarca")
	private Arquivo arquivo;

	@Column(name = "id_usuario_apl")
	private Long usuarioAlteracao;

	@Column(name = "ds_visao")
	private String visao;

	@Column(name = "ds_missao")
	private String missao;

	@Column(name = "ds_email")
	private String email;

	@Column(name = "nr_cep")
	private Long cep;

	@Column(name = "ds_bairro")
	private String bairro;

	@Column(name = "sg_uf_endereco")
	private String uf;

	@Column(name = "nr_fone_celular")
	private String celular;

	//Classificador da Unidade (M = MATRIZ ou F = FILIAL)
	@Column(name = "cs_tipo_unidade") 
	private String tipoUnidade;

	//Classificação da situação do imóvel da unidade (P = PRÓPRIO; C = CONCESSÃO; L = LICENÇA PARA FUNCIONAMENTO; O = OUTRO)
	//@Column(name = "cs_situacao_imovel") 
	@Column(name = "cs_situacao_imovel") 
	@Type(type = "br.com.crux.infra.dao.GenericEnumUserType", parameters = {
			@Parameter(name = "enumClass", value = "br.com.crux.enums.ClassificadorSituacaoImovel") }) 
	private ClassificadorSituacaoImovel classificacaoSituacaoImovel;
	
	
	@Column(name = "nm_fantasia")
	private String nomeFantasia;
	
	@Column(name = "nr_cnpj")
	private String cnpj;
	
	@Column(name = "nr_inscricao_estadual")
	private String inscricaoEstadual;
	
	@Column(name = "nr_inscricao_municipal")
	private String inscricaoMunicipal;
	
	@Column(name = "ds_home_page")
	private String homePage;
	
	@Column(name = "nm_cidade")
	private String cidade;
	
	
	public Unidade() {
	}

	public Long getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(Long idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getSiglaUnidade() {
		return siglaUnidade;
	}

	public void setSiglaUnidade(String cdUnidade) {
		this.siglaUnidade = cdUnidade;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nmUnidade) {
		this.nomeUnidade = nmUnidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String dsEndereco) {
		this.endereco = dsEndereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String nrTelefone) {
		this.telefone = nrTelefone;
	}

	public ClassificadorSituacaoImovel getClassificacaoSituacaoImovel() {
		return classificacaoSituacaoImovel;
	}

	public void setClassificacaoSituacaoImovel(ClassificadorSituacaoImovel csSituacaoImovel) {
		this.classificacaoSituacaoImovel = csSituacaoImovel;
	}

	public String getDescricaoSituacaoImovel() {
		return descricaoSituacaoImovel;
	}

	public void setDescricaoSituacaoImovel(String dsSituacaoImovel) {
		this.descricaoSituacaoImovel = dsSituacaoImovel;
	}

	public String getDescricaoEstruturaFisicaImovel() {
		return descricaoEstruturaFisicaImovel;
	}

	public void setDescricaoEstruturaFisicaImovel(String dsEstruturaFisicaImovel) {
		this.descricaoEstruturaFisicaImovel = dsEstruturaFisicaImovel;
	}

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public String getVisao() {
		return visao;
	}

	public void setVisao(String dsVisao) {
		this.visao = dsVisao;
	}

	public String getMissao() {
		return missao;
	}

	public void setMissao(String dsMissao) {
		this.missao = dsMissao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String dsEmail) {
		this.email = dsEmail;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long nrCep) {
		this.cep = nrCep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String dsBairro) {
		this.bairro = dsBairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String sgUfEndereco) {
		this.uf = sgUfEndereco;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String nrFoneCelular) {
		this.celular = nrFoneCelular;
	}

	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



}