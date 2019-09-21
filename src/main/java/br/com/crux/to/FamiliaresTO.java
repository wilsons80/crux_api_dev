package br.com.crux.to;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.crux.enums.SituacaoParentesco;
import br.com.crux.infra.adapter.LocalDateTimeAdapter;


/**
 * The persistent class for the familiares database table.
 * 
 */
public class FamiliaresTO {

	private Long               id;
	private String             descGrauParentesco;
	private SituacaoParentesco situacaoParentesco;
	private String             descOutrasInformacoes;
	private String             descDesligamento;
	private PessoaFisicaTO     pessoasFisica;
	private AlunoTO            aluno;
	private Long               usuariosSistema;
	
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime      dataCadastro;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime      dataDesligamento;


	public FamiliaresTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescGrauParentesco() {
		return descGrauParentesco;
	}

	public void setDescGrauParentesco(String descGrauParentesco) {
		this.descGrauParentesco = descGrauParentesco;
	}

	public SituacaoParentesco getSituacaoParentesco() {
		return situacaoParentesco;
	}

	public void setSituacaoParentesco(SituacaoParentesco situacaoParentesco) {
		this.situacaoParentesco = situacaoParentesco;
	}

	public String getDescOutrasInformacoes() {
		return descOutrasInformacoes;
	}

	public void setDescOutrasInformacoes(String descOutrasInformacoes) {
		this.descOutrasInformacoes = descOutrasInformacoes;
	}

	public String getDescDesligamento() {
		return descDesligamento;
	}

	public void setDescDesligamento(String descDesligamento) {
		this.descDesligamento = descDesligamento;
	}

	public LocalDateTime getDataDesligamento() {
		return dataDesligamento;
	}

	public void setDataDesligamento(LocalDateTime dataDesligamento) {
		this.dataDesligamento = dataDesligamento;
	}

	public PessoaFisicaTO getPessoasFisica() {
		return pessoasFisica;
	}

	public void setPessoasFisica(PessoaFisicaTO pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public AlunoTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoTO aluno) {
		this.aluno = aluno;
	}

	public Long getUsuariosSistema() {
		return usuariosSistema;
	}

	public void setUsuariosSistema(Long usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}
	
}