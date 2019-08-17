package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the frequencias_alunos database table.
 * 
 */
@Entity
@Table(name="frequencias_alunos")
@NamedQuery(name="FrequenciasAluno.findAll", query="SELECT f FROM FrequenciasAluno f")
public class FrequenciasAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_frequencia_aluno")
	private Long idFrequenciaAluno;

	@Column(name="ds_justificativa")
	private String dsJustificativa;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_frequencia")
	private Date dtFrequencia;

	//bi-directional many-to-one association to AtividadesAluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade_aluno")
	private AtividadesAluno atividadesAluno;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public FrequenciasAluno() {
	}

	public Long getIdFrequenciaAluno() {
		return this.idFrequenciaAluno;
	}

	public void setIdFrequenciaAluno(Long idFrequenciaAluno) {
		this.idFrequenciaAluno = idFrequenciaAluno;
	}

	public String getDsJustificativa() {
		return this.dsJustificativa;
	}

	public void setDsJustificativa(String dsJustificativa) {
		this.dsJustificativa = dsJustificativa;
	}

	public Date getDtFrequencia() {
		return this.dtFrequencia;
	}

	public void setDtFrequencia(Date dtFrequencia) {
		this.dtFrequencia = dtFrequencia;
	}

	public AtividadesAluno getAtividadesAluno() {
		return this.atividadesAluno;
	}

	public void setAtividadesAluno(AtividadesAluno atividadesAluno) {
		this.atividadesAluno = atividadesAluno;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}