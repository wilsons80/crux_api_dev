package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.to.ColaboradoresProgramaTO;


@Component
public class ColaboradoresProgramaTOBuilder {
	
	@Autowired private ProgramaTOBuilder programaTOBuilder;
	@Autowired private CargosTOBuilder cargoTOBuilder;
	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;

	public ColaboradoresPrograma build(ColaboradoresProgramaTO p) {
		ColaboradoresPrograma retorno = new ColaboradoresPrograma();
		
		retorno.setId(p.getId());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setPrograma(programaTOBuilder.build(p.getPrograma()));
		retorno.setCargo(cargoTOBuilder.build(p.getCargo()));
		retorno.setFuncionario(funcionarioTOBuilder.build(p.getFuncionario()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		return retorno;
	}

	
	public ColaboradoresProgramaTO buildTO(ColaboradoresPrograma p) {
		ColaboradoresProgramaTO retorno = new ColaboradoresProgramaTO();
		
		retorno.setId(p.getId());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setPrograma(programaTOBuilder.buildTO(p.getPrograma()));
		
		retorno.setCargo(cargoTOBuilder.buildTO(p.getCargo()));
		retorno.setFuncionario(funcionarioTOBuilder.buildTO(p.getFuncionario()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		
		return retorno;
	}
	
	
	
	public List<ColaboradoresProgramaTO> buildAll(List<ColaboradoresPrograma> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
