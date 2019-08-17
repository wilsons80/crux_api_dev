package br.com.crux.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the programas database table.
 * 
 */
@Entity
@Table(name="programas")
@NamedQuery(name="Programa.findAll", query="SELECT p FROM Programa p")
public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_programa")
	private Long idPrograma;

	@Column(name="ds_programa")
	private String dsPrograma;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_implantacao")
	private Date dtImplantacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_termino")
	private Date dtTermino;

	@Column(name="id_coordenador")
	private BigDecimal idCoordenador;

	@Column(name="id_objetivo")
	private BigDecimal idObjetivo;

	@Column(name="nm_programa")
	private String nmPrograma;

	@Column(name="nr_faixa_etaria_fim")
	private BigDecimal nrFaixaEtariaFim;

	@Column(name="nr_faixa_etaria_ini")
	private BigDecimal nrFaixaEtariaIni;

	//bi-directional many-to-one association to ColaboradoresPrograma
	@OneToMany(mappedBy="programa")
	private List<ColaboradoresPrograma> colaboradoresProgramas;

	//bi-directional many-to-one association to Iniciativa
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="iniciativas_id_iniciativa")
	private Iniciativa iniciativa;

	//bi-directional many-to-one association to UsuariosSistema
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usuario_apl")
	private UsuariosSistema usuariosSistema;

	//bi-directional many-to-one association to Projeto
	@OneToMany(mappedBy="programa")
	private List<Projeto> projetos;

	public Programa() {
	}

	public Long getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getDsPrograma() {
		return this.dsPrograma;
	}

	public void setDsPrograma(String dsPrograma) {
		this.dsPrograma = dsPrograma;
	}

	public Date getDtImplantacao() {
		return this.dtImplantacao;
	}

	public void setDtImplantacao(Date dtImplantacao) {
		this.dtImplantacao = dtImplantacao;
	}

	public Date getDtTermino() {
		return this.dtTermino;
	}

	public void setDtTermino(Date dtTermino) {
		this.dtTermino = dtTermino;
	}

	public BigDecimal getIdCoordenador() {
		return this.idCoordenador;
	}

	public void setIdCoordenador(BigDecimal idCoordenador) {
		this.idCoordenador = idCoordenador;
	}

	public BigDecimal getIdObjetivo() {
		return this.idObjetivo;
	}

	public void setIdObjetivo(BigDecimal idObjetivo) {
		this.idObjetivo = idObjetivo;
	}

	public String getNmPrograma() {
		return this.nmPrograma;
	}

	public void setNmPrograma(String nmPrograma) {
		this.nmPrograma = nmPrograma;
	}

	public BigDecimal getNrFaixaEtariaFim() {
		return this.nrFaixaEtariaFim;
	}

	public void setNrFaixaEtariaFim(BigDecimal nrFaixaEtariaFim) {
		this.nrFaixaEtariaFim = nrFaixaEtariaFim;
	}

	public BigDecimal getNrFaixaEtariaIni() {
		return this.nrFaixaEtariaIni;
	}

	public void setNrFaixaEtariaIni(BigDecimal nrFaixaEtariaIni) {
		this.nrFaixaEtariaIni = nrFaixaEtariaIni;
	}

	public List<ColaboradoresPrograma> getColaboradoresProgramas() {
		return this.colaboradoresProgramas;
	}

	public void setColaboradoresProgramas(List<ColaboradoresPrograma> colaboradoresProgramas) {
		this.colaboradoresProgramas = colaboradoresProgramas;
	}

	public ColaboradoresPrograma addColaboradoresPrograma(ColaboradoresPrograma colaboradoresPrograma) {
		getColaboradoresProgramas().add(colaboradoresPrograma);
		colaboradoresPrograma.setPrograma(this);

		return colaboradoresPrograma;
	}

	public ColaboradoresPrograma removeColaboradoresPrograma(ColaboradoresPrograma colaboradoresPrograma) {
		getColaboradoresProgramas().remove(colaboradoresPrograma);
		colaboradoresPrograma.setPrograma(null);

		return colaboradoresPrograma;
	}

	public Iniciativa getIniciativa() {
		return this.iniciativa;
	}

	public void setIniciativa(Iniciativa iniciativa) {
		this.iniciativa = iniciativa;
	}

	public UsuariosSistema getUsuariosSistema() {
		return this.usuariosSistema;
	}

	public void setUsuariosSistema(UsuariosSistema usuariosSistema) {
		this.usuariosSistema = usuariosSistema;
	}

	public List<Projeto> getProjetos() {
		return this.projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Projeto addProjeto(Projeto projeto) {
		getProjetos().add(projeto);
		projeto.setPrograma(this);

		return projeto;
	}

	public Projeto removeProjeto(Projeto projeto) {
		getProjetos().remove(projeto);
		projeto.setPrograma(null);

		return projeto;
	}

}