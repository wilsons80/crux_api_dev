package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.PlanosAcao;
import br.com.crux.to.PlanosAcaoTO;


@Component
public class PlanosAcaoTOBuilder {
	
	@Autowired
	private IniciativaTOBuilder iniciativaTOBuilder;
	

	public PlanosAcao build(PlanosAcaoTO param) {
		PlanosAcao retorno = new PlanosAcao();
		
		retorno.setId(param.getId());
		retorno.setDataInicio(param.getDataInicio());
		retorno.setDataFim(param.getDataFim());
		retorno.setNome(param.getNome());
		retorno.setIniciativa(iniciativaTOBuilder.build(param.getIniciativa()));
		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());
		
		return retorno;
	}

	
	public PlanosAcaoTO buildTO(PlanosAcao param) {
		PlanosAcaoTO retorno = new PlanosAcaoTO();
		
		retorno.setId(param.getId());
		retorno.setDataInicio(param.getDataInicio());
		retorno.setDataFim(param.getDataFim());
		retorno.setNome(param.getNome());
		retorno.setIniciativa(iniciativaTOBuilder.buildTO(param.getIniciativa()));
		retorno.setUsuarioAlteracao(param.getUsuarioAlteracao());

		
		return retorno;
	}
	
	
	
	public List<PlanosAcaoTO> buildAll(List<PlanosAcao> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
