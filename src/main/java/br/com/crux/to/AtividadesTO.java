package br.com.crux.to;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import br.com.crux.infra.adapter.LocalDateTimeAdapter;

public class AtividadesTO {

	private Long id;
	private String descricao;
	private String descricaoLocalExecucao;
	
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataFim;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataInicio;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataPrevisaoInicio;
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime dataPrevisaoTermino;

	private Long horaFim;
	private Long horaInicio;
	private Long numeroAulas;
	private Long cargaHoraria;
	private Long maximoParticipantes;
	private Long periodoAtividade;
	private String domingo;
	private String horarioFixo;
	private String localExecucao;
	private String quarta;
	private String quinta;
	private String sabado;
	private String segunda;
	private String sexta;
	private String terca;
	private String observacoes;
	private Long valorCustoAtividade;
	
	private PlanosAcaoTO planosAcao;
	private ProjetoTO projeto;
	private UnidadeTO unidade;
	
	private Long usuarioAlteracao;

	public AtividadesTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoLocalExecucao() {
		return descricaoLocalExecucao;
	}

	public void setDescricaoLocalExecucao(String descricaoLocalExecucao) {
		this.descricaoLocalExecucao = descricaoLocalExecucao;
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

	public LocalDateTime getDataPrevisaoInicio() {
		return dataPrevisaoInicio;
	}

	public void setDataPrevisaoInicio(LocalDateTime dataPrevisaoInicio) {
		this.dataPrevisaoInicio = dataPrevisaoInicio;
	}

	public LocalDateTime getDataPrevisaoTermino() {
		return dataPrevisaoTermino;
	}

	public void setDataPrevisaoTermino(LocalDateTime dataPrevisaoTermino) {
		this.dataPrevisaoTermino = dataPrevisaoTermino;
	}

	public Long getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Long horaFim) {
		this.horaFim = horaFim;
	}

	public Long getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Long horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Long getNumeroAulas() {
		return numeroAulas;
	}

	public void setNumeroAulas(Long numeroAulas) {
		this.numeroAulas = numeroAulas;
	}

	public Long getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Long cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Long getMaximoParticipantes() {
		return maximoParticipantes;
	}

	public void setMaximoParticipantes(Long maximoParticipantes) {
		this.maximoParticipantes = maximoParticipantes;
	}

	public Long getPeriodoAtividade() {
		return periodoAtividade;
	}

	public void setPeriodoAtividade(Long periodoAtividade) {
		this.periodoAtividade = periodoAtividade;
	}

	public String getDomingo() {
		return domingo;
	}

	public void setDomingo(String domingo) {
		this.domingo = domingo;
	}

	public String getHorarioFixo() {
		return horarioFixo;
	}

	public void setHorarioFixo(String horarioFixo) {
		this.horarioFixo = horarioFixo;
	}

	public String getLocalExecucao() {
		return localExecucao;
	}

	public void setLocalExecucao(String localExecucao) {
		this.localExecucao = localExecucao;
	}

	public String getQuarta() {
		return quarta;
	}

	public void setQuarta(String quarta) {
		this.quarta = quarta;
	}

	public String getQuinta() {
		return quinta;
	}

	public void setQuinta(String quinta) {
		this.quinta = quinta;
	}

	public String getSabado() {
		return sabado;
	}

	public void setSabado(String sabado) {
		this.sabado = sabado;
	}

	public String getSegunda() {
		return segunda;
	}

	public void setSegunda(String segunda) {
		this.segunda = segunda;
	}

	public String getSexta() {
		return sexta;
	}

	public void setSexta(String sexta) {
		this.sexta = sexta;
	}

	public String getTerca() {
		return terca;
	}

	public void setTerca(String terca) {
		this.terca = terca;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Long getValorCustoAtividade() {
		return valorCustoAtividade;
	}

	public void setValorCustoAtividade(Long valorCustoAtividade) {
		this.valorCustoAtividade = valorCustoAtividade;
	}

	public PlanosAcaoTO getPlanosAcao() {
		return planosAcao;
	}

	public void setPlanosAcao(PlanosAcaoTO planosAcao) {
		this.planosAcao = planosAcao;
	}

	public ProjetoTO getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoTO projeto) {
		this.projeto = projeto;
	}

	public UnidadeTO getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeTO unidade) {
		this.unidade = unidade;
	}

	public Long getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(Long usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

}
