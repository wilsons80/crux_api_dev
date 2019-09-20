package br.com.crux.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the familiares database table.
 * 
 */
@Entity
@Table(name="familiares")
public class Familiare {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_familiar")
	private Long id;
	
	@Column(name="data_cadastro")
	private Date dataCadastro;

	@Column(name="desc_grau_parentesco")
	private String descGrauParentesco;

	//Classificador da situação do grau de parentesco (E = ESTREMECIDO; I = INTERROMPIDO; X = INEXISTENTE)
	@Column(name="st_situacao_parentesco")
	private String situacaoParentesco;
	
	@Column(name="desc_outras_informacoes")
	private String descOutrasInformacoes;
	
	@Column(name="desc_desligamento")
	private String descDesligamento;

	@Column(name="data_desligamento")
	private Date dataDesligamento;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica")
	private PessoaFisica pessoasFisica;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_aluno")
	private Aluno aluno;

	@Column(name="id_usuario_apl")
	private Long usuariosSistema;


	public Familiare() {
	}

}