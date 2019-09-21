package br.com.crux.to;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.crux.infra.adapter.LocalDateTimeAdapter;


public class EncaminhaAlunosTO  {

	private Long id;
	private String descricao;
	
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataEncaminhaAluno;
	
	private AlunoTO aluno;
	private EntidadesSociaisTO entidadesSociai;
	private Long usuarioAlteracao;

	public EncaminhaAlunosTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDataEncaminhaAluno() {
		return dataEncaminhaAluno;
	}

	public void setDataEncaminhaAluno(LocalDateTime dataEncaminhaAluno) {
		this.dataEncaminhaAluno = dataEncaminhaAluno;
	}

	public AlunoTO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoTO aluno) {
		this.aluno = aluno;
	}

	public EntidadesSociaisTO getEntidadesSociai() {
		return entidadesSociai;
	}

	public void setEntidadesSociai(EntidadesSociaisTO entidadesSociai) {
		this.entidadesSociai = entidadesSociai;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}


}