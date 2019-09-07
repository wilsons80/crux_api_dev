package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Atividade;
import br.com.crux.to.AtividadeTO;

@Component
public class AtividadeTOBuilder {

	@Autowired
	private UnidadeBuilder unidadeBuilder;
	@Autowired
	private ProjetoTOBuilder projetoBuilder;
	@Autowired
	private PlanosAcaoTOBuilder planosAcaoBuilder;

	public Atividade build(AtividadeTO p) {
		Atividade retorno = new Atividade();

		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setDescricaoLocalExecucao(p.getDescricaoLocalExecucao());
		retorno.setDataFim(p.getDataFim());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataPrevisaoInicio(p.getDataPrevisaoInicio());
		retorno.setDataPrevisaoTermino(p.getDataPrevisaoTermino());
		retorno.setHoraFim(p.getHoraFim());
		retorno.setHoraInicio(p.getHoraInicio());
		retorno.setNumeroAulas(p.getNumeroAulas());
		retorno.setCargaHoraria(p.getCargaHoraria());
		retorno.setMaximoParticipantes(p.getMaximoParticipantes());
		retorno.setPeriodoAtividade(p.getPeriodoAtividade());
		retorno.setHorarioFixo(p.getHorarioFixo());
		retorno.setLocalExecucao(p.getLocalExecucao());
		retorno.setSegunda(p.getSegunda());
		retorno.setTerca(p.getTerca());
		retorno.setQuarta(p.getQuarta());
		retorno.setQuinta(p.getQuinta());
		retorno.setSexta(p.getSexta());
		retorno.setSabado(p.getSabado());
		retorno.setDomingo(p.getDomingo());
		retorno.setObservacoes(p.getObservacoes());
		retorno.setValorCustoAtividade(p.getValorCustoAtividade());
		retorno.setUnidade(unidadeBuilder.build(p.getUnidade()));
		retorno.setProjeto(projetoBuilder.build(p.getProjeto()));
		retorno.setPlanosAcao(planosAcaoBuilder.build(p.getPlanosAcao()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public AtividadeTO buildTO(Atividade p) {
		AtividadeTO retorno = new AtividadeTO();
		
		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setDescricaoLocalExecucao(p.getDescricaoLocalExecucao());
		retorno.setDataFim(p.getDataFim());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataPrevisaoInicio(p.getDataPrevisaoInicio());
		retorno.setDataPrevisaoTermino(p.getDataPrevisaoTermino());
		retorno.setHoraFim(p.getHoraFim());
		retorno.setHoraInicio(p.getHoraInicio());
		retorno.setNumeroAulas(p.getNumeroAulas());
		retorno.setCargaHoraria(p.getCargaHoraria());
		retorno.setMaximoParticipantes(p.getMaximoParticipantes());
		retorno.setPeriodoAtividade(p.getPeriodoAtividade());
		retorno.setHorarioFixo(p.getHorarioFixo());
		retorno.setLocalExecucao(p.getLocalExecucao());
		retorno.setSegunda(p.getSegunda());
		retorno.setTerca(p.getTerca());
		retorno.setQuarta(p.getQuarta());
		retorno.setQuinta(p.getQuinta());
		retorno.setSexta(p.getSexta());
		retorno.setSabado(p.getSabado());
		retorno.setDomingo(p.getDomingo());
		retorno.setObservacoes(p.getObservacoes());
		retorno.setValorCustoAtividade(p.getValorCustoAtividade());
		retorno.setUnidade(unidadeBuilder.buildTO(p.getUnidade()));
		retorno.setProjeto(projetoBuilder.buildTO(p.getProjeto()));
		retorno.setPlanosAcao(planosAcaoBuilder.buildTO(p.getPlanosAcao()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<AtividadeTO> buildAll(List<Atividade> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
