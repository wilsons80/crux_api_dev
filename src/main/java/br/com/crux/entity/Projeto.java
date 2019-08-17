package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the projetos database table.
 * 
 */
@Entity
@Table(name="projetos")
@NamedQuery(name="Projeto.findAll", query="SELECT p FROM Projeto p")
public class Projeto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_projeto")
	private Long idProjeto;

	@Column(name="ds_projeto")
	private String dsProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_fim_projeto")
	private Date dtFimProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_inicio_projeto")
	private Date dtInicioProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_prev_projeto")
	private Date dtPrevProjeto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_prev_termino")
	private Date dtPrevTermino;

	@Column(name="nm_projeto")
	private String nmProjeto;

	//bi-directional many-to-one association to Atividade
	@OneToMany(mappedBy="projeto")
	private List<Atividade> atividades;

	//bi-directional many-to-one association to ColaboradoresProjeto
	@OneToMany(mappedBy="projeto")
	private List<ColaboradoresProjeto> colaboradoresProjetos;

	//bi-directional many-to-one association to Iniciativa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iniciativas_id_iniciativa")
	private Iniciativa iniciativa;

	//bi-directional many-to-one association to Programa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="programas_id_programa")
	private Programa programa;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	public Projeto() {
	}

	public Long getIdProjeto() {
		return this.idProjeto;
	}

	public void setIdProjeto(Long idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getDsProjeto() {
		return this.dsProjeto;
	}

	public void setDsProjeto(String dsProjeto) {
		this.dsProjeto = dsProjeto;
	}

	public Date getDtFimProjeto() {
		return this.dtFimProjeto;
	}

	public void setDtFimProjeto(Date dtFimProjeto) {
		this.dtFimProjeto = dtFimProjeto;
	}

	public Date getDtInicioProjeto() {
		return this.dtInicioProjeto;
	}

	public void setDtInicioProjeto(Date dtInicioProjeto) {
		this.dtInicioProjeto = dtInicioProjeto;
	}

	public Date getDtPrevProjeto() {
		return this.dtPrevProjeto;
	}

	public void setDtPrevProjeto(Date dtPrevProjeto) {
		this.dtPrevProjeto = dtPrevProjeto;
	}

	public Date getDtPrevTermino() {
		return this.dtPrevTermino;
	}

	public void setDtPrevTermino(Date dtPrevTermino) {
		this.dtPrevTermino = dtPrevTermino;
	}

	public String getNmProjeto() {
		return this.nmProjeto;
	}

	public void setNmProjeto(String nmProjeto) {
		this.nmProjeto = nmProjeto;
	}

	public List<Atividade> getAtividades() {
		return this.atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Atividade addAtividade(Atividade atividade) {
		getAtividades().add(atividade);
		atividade.setProjeto(this);

		return atividade;
	}

	public Atividade removeAtividade(Atividade atividade) {
		getAtividades().remove(atividade);
		atividade.setProjeto(null);

		return atividade;
	}

	public List<ColaboradoresProjeto> getColaboradoresProjetos() {
		return this.colaboradoresProjetos;
	}

	public void setColaboradoresProjetos(List<ColaboradoresProjeto> colaboradoresProjetos) {
		this.colaboradoresProjetos = colaboradoresProjetos;
	}

	public ColaboradoresProjeto addColaboradoresProjeto(ColaboradoresProjeto colaboradoresProjeto) {
		getColaboradoresProjetos().add(colaboradoresProjeto);
		colaboradoresProjeto.setProjeto(this);

		return colaboradoresProjeto;
	}

	public ColaboradoresProjeto removeColaboradoresProjeto(ColaboradoresProjeto colaboradoresProjeto) {
		getColaboradoresProjetos().remove(colaboradoresProjeto);
		colaboradoresProjeto.setProjeto(null);

		return colaboradoresProjeto;
	}

	public Iniciativa getIniciativa() {
		return this.iniciativa;
	}

	public void setIniciativa(Iniciativa iniciativa) {
		this.iniciativa = iniciativa;
	}

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

}