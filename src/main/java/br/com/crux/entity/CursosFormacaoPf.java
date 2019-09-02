package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cursos_formacao_pf database table.
 * 
 */
@Entity
@Table(name="cursos_formacao_pf")
@NamedQuery(name="CursosFormacaoPf.findAll", query="SELECT c FROM CursosFormacaoPf c")
public class CursosFormacaoPf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_curso")
	private Long idCurso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_curso")
	private Date dtFimCurso;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_curso")
	private Date dtInicioCurso;

	@Column(name="nm_curso")
	private String nmCurso;

	@Column(name="nm_instuicao")
	private String nmInstuicao;

	//bi-directional many-to-one association to PessoasFisica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pessoa_fisica")
	private PessoaFisica pessoasFisica;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public CursosFormacaoPf() {
	}

	public Long getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Date getDtFimCurso() {
		return this.dtFimCurso;
	}

	public void setDtFimCurso(Date dtFimCurso) {
		this.dtFimCurso = dtFimCurso;
	}

	public Date getDtInicioCurso() {
		return this.dtInicioCurso;
	}

	public void setDtInicioCurso(Date dtInicioCurso) {
		this.dtInicioCurso = dtInicioCurso;
	}

	public String getNmCurso() {
		return this.nmCurso;
	}

	public void setNmCurso(String nmCurso) {
		this.nmCurso = nmCurso;
	}

	public String getNmInstuicao() {
		return this.nmInstuicao;
	}

	public void setNmInstuicao(String nmInstuicao) {
		this.nmInstuicao = nmInstuicao;
	}

	public PessoaFisica getPessoasFisica() {
		return this.pessoasFisica;
	}

	public void setPessoasFisica(PessoaFisica pessoasFisica) {
		this.pessoasFisica = pessoasFisica;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}