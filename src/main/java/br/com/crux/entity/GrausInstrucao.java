package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the graus_instrucao database table.
 * 
 */
@Entity
@Table(name="graus_instrucao")
@NamedQuery(name="GrausInstrucao.findAll", query="SELECT g FROM GrausInstrucao g")
public class GrausInstrucao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_grau_instrucao")
	private Long idGrauInstrucao;

	@Column(name="ds_grau_instrucao")
	private String dsGrauInstrucao;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	//bi-directional many-to-one association to PessoasFisica
	@OneToMany(mappedBy="grausInstrucao")
	private List<PessoaFisica> pessoasFisicas;

	public GrausInstrucao() {
	}

	public Long getIdGrauInstrucao() {
		return this.idGrauInstrucao;
	}

	public void setIdGrauInstrucao(Long idGrauInstrucao) {
		this.idGrauInstrucao = idGrauInstrucao;
	}

	public String getDsGrauInstrucao() {
		return this.dsGrauInstrucao;
	}

	public void setDsGrauInstrucao(String dsGrauInstrucao) {
		this.dsGrauInstrucao = dsGrauInstrucao;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

	public List<PessoaFisica> getPessoasFisicas() {
		return this.pessoasFisicas;
	}

	public void setPessoasFisicas(List<PessoaFisica> pessoasFisicas) {
		this.pessoasFisicas = pessoasFisicas;
	}


}