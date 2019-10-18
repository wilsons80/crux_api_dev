package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.cmd.GetIndicadoresCmd;
import br.com.crux.entity.Indicadores;
import br.com.crux.entity.Metas;
import br.com.crux.to.MetasTO;

@Component
public class MetasTOBuilder {

	@Autowired private IndicadoresTOBuilder indicadorTOBuilder;
	@Autowired private GetIndicadoresCmd getIndicadoresCmd;

	public Metas build(MetasTO param) {
		Metas retorno = new Metas();

		retorno.setIdMeta(param.getId());
		retorno.setDataInicio(param.getDataInicio());
		retorno.setDataFim(param.getDataFim());
		retorno.setDescricao(param.getNome());

		Optional.ofNullable(param.getIndicadores()).ifPresent(i -> {
			Indicadores indicadores = getIndicadoresCmd.getById(i.getIdIndicador());
			retorno.setIndicadores(indicadores);
		});

		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());

		return retorno;
	}

	public MetasTO buildTO(Metas param) {
		MetasTO retorno = new MetasTO();
		
		if(Objects.isNull(param)) {
			return retorno;
		}

		retorno.setId(param.getIdMeta());
		retorno.setDataInicio(param.getDataInicio());
		retorno.setDataFim(param.getDataFim());
		retorno.setNome(param.getDescricao());
		retorno.setIndicadores(indicadorTOBuilder.buildTO(param.getIndicadores()));
		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());

		return retorno;
	}

	public List<MetasTO> buildAll(List<Metas> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
