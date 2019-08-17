package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the uniformes_aluno database table.
 * 
 */
@Entity
@Table(name="uniformes_aluno")
@NamedQuery(name="UniformesAluno.findAll", query="SELECT u FROM UniformesAluno u")
public class UniformesAluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_uniforme_aluno")
	private Long idUniformeAluno;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_uniforme_entregue")
	private Date dtUniformeEntregue;

	@Column(name="nm_uniforme")
	private String nmUniforme;

	@Column(name="qt_uniforme_entregue")
	private BigDecimal qtUniformeEntregue;

	//bi-directional many-to-one association to AtividadesAluno
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_atividade_aluno")
	private AtividadesAluno atividadesAluno;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public UniformesAluno() {
	}

	public Long getIdUniformeAluno() {
		return this.idUniformeAluno;
	}

	public void setIdUniformeAluno(Long idUniformeAluno) {
		this.idUniformeAluno = idUniformeAluno;
	}

	public Date getDtUniformeEntregue() {
		return this.dtUniformeEntregue;
	}

	public void setDtUniformeEntregue(Date dtUniformeEntregue) {
		this.dtUniformeEntregue = dtUniformeEntregue;
	}

	public String getNmUniforme() {
		return this.nmUniforme;
	}

	public void setNmUniforme(String nmUniforme) {
		this.nmUniforme = nmUniforme;
	}

	public BigDecimal getQtUniformeEntregue() {
		return this.qtUniformeEntregue;
	}

	public void setQtUniformeEntregue(BigDecimal qtUniformeEntregue) {
		this.qtUniformeEntregue = qtUniformeEntregue;
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