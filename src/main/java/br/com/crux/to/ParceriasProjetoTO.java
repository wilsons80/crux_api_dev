package br.com.crux.to;

import java.time.LocalDateTime;

public class ParceriasProjetoTO {

	private Long id;

	private String descricaoTipoParceria;

	private LocalDateTime dataFim;

	private LocalDateTime dataInicio;

	private Integer idEmpresa;

	private Integer idProjeto;

	private Long usuarioAlteracao;

	private Double valorParceria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoTipoParceria() {
		return descricaoTipoParceria;
	}

	public void setDescricaoTipoParceria(String descricaoTipoParceria) {
		this.descricaoTipoParceria = descricaoTipoParceria;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

	public Double getValorParceria() {
		return valorParceria;
	}

	public void setValorParceria(Double valorParceria) {
		this.valorParceria = valorParceria;
	}
	
	

}
