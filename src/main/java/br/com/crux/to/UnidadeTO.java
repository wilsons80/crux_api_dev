package br.com.crux.to;

import br.com.crux.enums.ClassificadorSituacaoImovel;
import br.com.crux.enums.TipoUnidade;

public class UnidadeTO {

	private Long idUnidade;
	private String codigoUnidade;
	private String nomeUnidade;
	private String endereco;
	private String telefone;
	private String descricaoSituacaoImovel;
	private String descricaoEstruturaFisicaImovel;
	private Long arquivo;
	private Long usuarioAlteracao;
	private String visao;
	private String missao;
	private String email;
	private Long cep;
	private String bairro;
	private String uf;
	private String celular;
	private TipoUnidade tipoUnidade;
	private ClassificadorSituacaoImovel classificacaoSituacaoImovel;

	public UnidadeTO() {
	}

	public Long getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(Long idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getCodigoUnidade() {
		return codigoUnidade;
	}

	public void setCodigoUnidade(String codigoUnidade) {
		this.codigoUnidade = codigoUnidade;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricaoSituacaoImovel() {
		return descricaoSituacaoImovel;
	}

	public void setDescricaoSituacaoImovel(String descricaoSituacaoImovel) {
		this.descricaoSituacaoImovel = descricaoSituacaoImovel;
	}

	public String getDescricaoEstruturaFisicaImovel() {
		return descricaoEstruturaFisicaImovel;
	}

	public void setDescricaoEstruturaFisicaImovel(String descricaoEstruturaFisicaImovel) {
		this.descricaoEstruturaFisicaImovel = descricaoEstruturaFisicaImovel;
	}

	public Long getArquivo() {
		return arquivo;
	}

	public void setArquivo(Long arquivo) {
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

	public void setVisao(String visao) {
		this.visao = visao;
	}

	public String getMissao() {
		return missao;
	}

	public void setMissao(String missao) {
		this.missao = missao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public TipoUnidade getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(TipoUnidade tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public ClassificadorSituacaoImovel getClassificacaoSituacaoImovel() {
		return classificacaoSituacaoImovel;
	}

	public void setClassificacaoSituacaoImovel(ClassificadorSituacaoImovel classificacaoSituacaoImovel) {
		this.classificacaoSituacaoImovel = classificacaoSituacaoImovel;
	}

}
