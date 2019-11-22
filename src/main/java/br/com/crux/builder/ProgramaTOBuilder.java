package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.cmd.GetObjetivoCmd;
import br.com.crux.cmd.GetUnidadeCmd;
import br.com.crux.cmd.GetUnidadeLogadaCmd;
import br.com.crux.entity.Objetivo;
import br.com.crux.entity.Programa;
import br.com.crux.to.ProgramaTO;

@Component
public class ProgramaTOBuilder {

	@Autowired private ObjetivoTOBuilder objetivoTOBuilder;
	@Autowired private GetObjetivoCmd getObjetivoCmd;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	@Autowired private GetUnidadeCmd getUnidadeCmd;

	public Programa build(ProgramaTO param) {
		Programa retorno = new Programa();

		retorno.setId(param.getId());
		retorno.setNome(param.getNome());
		retorno.setIdCoordenador(param.getIdCoordenador());
		retorno.setDescricao(param.getDescricao());
		retorno.setFaixaEtariaInicio(param.getFaixaEtariaInicio());
		retorno.setFaixaEtariaFim(param.getFaixaEtariaFim());
		retorno.setDataInicio(param.getDataInicio());
		retorno.setDataFim(param.getDataFim());
		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());

		Optional.ofNullable(param.getObjetivo()).ifPresent(o -> {
			Objetivo obj = getObjetivoCmd.getById(o.getIdObjetivo());
			retorno.setObjetivo(obj);
		});

		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		
		retorno.setUnidade(getUnidadeCmd.getById(idUnidade));

		return retorno;
	}

	public ProgramaTO buildTO(Programa param) {
		ProgramaTO retorno = new ProgramaTO();

		if (Objects.isNull(param)) {
			return retorno;
		}

		retorno.setId(param.getId());
		retorno.setNome(param.getNome());
		retorno.setIdCoordenador(param.getIdCoordenador());
		retorno.setDescricao(param.getDescricao());
		retorno.setFaixaEtariaInicio(param.getFaixaEtariaInicio());
		retorno.setFaixaEtariaFim(param.getFaixaEtariaFim());
		retorno.setDataInicio(param.getDataInicio());
		retorno.setDataFim(param.getDataFim());
		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());
		retorno.setObjetivo(objetivoTOBuilder.buildTO(param.getObjetivo()));

		return retorno;
	}

	public List<ProgramaTO> buildAll(List<Programa> dtos) {
		return dtos.stream().map(this::buildTO).collect(Collectors.toList());
	}

}
