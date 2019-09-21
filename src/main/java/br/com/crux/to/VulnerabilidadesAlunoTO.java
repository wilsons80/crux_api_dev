package br.com.crux.to;

import java.time.LocalDateTime;

public class VulnerabilidadesAlunoTO {

	private Long id;
	private LocalDateTime dataIdentificacao;
	private LocalDateTime dataSolucao;
	private AlunoTO aluno;
	private SituacoesVulnerabilidadeTO situacoesVulnerabilidade;
	private SolucoesTO solucoe;
	private Long usuarioAlteracao;

	public VulnerabilidadesAlunoTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataIdentificacao() {
		return dataIdentificacao;
	}

	public void setDataIdentificacao(LocalDateTime dataIdentificacao) {
		this.dataIdentificacao = dataIdentificacao;
	}

	public LocalDateTime getDataSolucao() {
		return dataSolucao;
	}

	public void setDataSolucao(LocalDateTime dataSolucao) {
		this.dataSolucao = dataSolucao;
	}

	public AlunoTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoTO aluno) {
		this.aluno = aluno;
	}

	public SituacoesVulnerabilidadeTO getSituacoesVulnerabilidade() {
		return situacoesVulnerabilidade;
	}

	public void setSituacoesVulnerabilidade(SituacoesVulnerabilidadeTO situacoesVulnerabilidade) {
		this.situacoesVulnerabilidade = situacoesVulnerabilidade;
	}

	public SolucoesTO getSolucoe() {
		return solucoe;
	}

	public void setSolucoe(SolucoesTO solucoe) {
		this.solucoe = solucoe;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}


}