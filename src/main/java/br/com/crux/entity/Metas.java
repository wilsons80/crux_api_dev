package br.com.crux.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.crux.infra.constantes.Constantes;


@Entity
@Table(name="metas")
public class Metas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_id_meta")
	@SequenceGenerator(name = "sq_id_meta", sequenceName = "sq_id_meta", schema = Constantes.SCHEMA_PUBLIC, initialValue = 1, allocationSize = 1)
	@Column(name="id_meta")
	private Long idMeta;

	@Column(name="ds_meta")
	private String descricao;

	@Column(name="dt_fim_meta")
	private LocalDateTime dataFim;

	@Column(name="dt_inicio_meta")
	private LocalDateTime dataInicio;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="indicadores_id_indicador")
	private Indicadores indicadores;

	@Column(name="id_usuario_apl")
	private Long usuarioAlteracao;

	public Metas() {
	}

	public Long getIdMeta() {
		return this.idMeta;
	}

	public void setIdMeta(Long idMeta) {
		this.idMeta = idMeta;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String dsMeta) {
		this.descricao = dsMeta;
	}

	public LocalDateTime getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(LocalDateTime dtFimMeta) {
		this.dataFim = dtFimMeta;
	}

	public LocalDateTime getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(LocalDateTime dtInicioMeta) {
		this.dataInicio = dtInicioMeta;
	}

	public Indicadores getIndicadores() {
		return this.indicadores;
	}

	public void setIndicadores(Indicadores indicadore) {
		this.indicadores = indicadore;
	}

	public Long getUsuarioAlteracao() {
		return this.usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuariosSistema) {
		this.usuarioAlteracao = usuariosSistema;
	}

}