package br.com.crux.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.crux.infra.constantes.Constantes;
import br.com.crux.infra.dao.SimNaoConverter;

@Entity
@Table(name = "instituicoes")
public class Instituicao {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_instituicao")
	@SequenceGenerator(name = "sq_instituicao", sequenceName = "sq_instituicao", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name = "id_instituicao")
	private Long id;

	@Column(name = "nm_instituicao")
	private String nome;

	@Column(name = "id_arquivo_logomarca")
	private Long idArquivo;

	@Column(name = "id_usuario_apl")
	private Long usuarioAlteracao;
	
	@Column(name = "st_mostra_lista")
	@Convert(converter = SimNaoConverter.class)
	private Boolean mostraLista;

	public Instituicao() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdArquivo() {
		return idArquivo;
	}

	public void setIdArquivo(Long idArquivo) {
		this.idArquivo = idArquivo;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public Boolean getMostraLista() {
		return mostraLista;
	}

	public void setMostraLista(Boolean mostraLista) {
		this.mostraLista = mostraLista;
	}
	
	

}