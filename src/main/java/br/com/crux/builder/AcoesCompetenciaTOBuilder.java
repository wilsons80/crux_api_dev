package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.AcoesCompetencia;
import br.com.crux.to.AcoesCompetenciaTO;

@Component
public class AcoesCompetenciaTOBuilder {

	@Autowired
	private TalentosPFTOBuilder talentosPFBuilder;

	public AcoesCompetencia build(AcoesCompetenciaTO p) {
		AcoesCompetencia retorno = new AcoesCompetencia();

		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setResultadoAcao(p.getResultadoAcao());
		retorno.setResultadoPrevAcao(p.getResultadoPrevAcao());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setTalentosPf(talentosPFBuilder.build(p.getTalentosPf()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public AcoesCompetenciaTO buildTO(AcoesCompetencia p) {
		AcoesCompetenciaTO retorno = new AcoesCompetenciaTO();
		
		retorno.setId(p.getId());
		retorno.setDescricao(p.getDescricao());
		retorno.setResultadoAcao(p.getResultadoAcao());
		retorno.setResultadoPrevAcao(p.getResultadoPrevAcao());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setTalentosPf(talentosPFBuilder.buildTO(p.getTalentosPf()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<AcoesCompetenciaTO> buildAll(List<AcoesCompetencia> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
