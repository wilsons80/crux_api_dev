package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Programa;
import br.com.crux.to.ProgramaTO;


@Component
public class ProgramaTOBuilder {
	
	@Autowired private IniciativaTOBuilder iniciativaTOBuilder;
	@Autowired private ObjetivoTOBuilder objetivoTOBuilder;

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
		
		retorno.setObjetivo(objetivoTOBuilder.build(param.getObjetivo()));
		retorno.setIniciativa(iniciativaTOBuilder.build(param.getIniciativa()));
		
		return retorno;
	}

	
	public ProgramaTO buildTO(Programa param) {
		ProgramaTO retorno = new ProgramaTO();
		
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
		retorno.setIniciativa(iniciativaTOBuilder.buildTO(param.getIniciativa()));
		
		return retorno;
	}
	
	
	
	public List<ProgramaTO> buildAll(List<Programa> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
