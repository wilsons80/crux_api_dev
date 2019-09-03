package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.to.ColaboradoresProjetoTO;


@Component
public class ColaboradoresProjetoTOBuilder {
	
	@Autowired private ProjetoTOBuilder toBuilder;
	
	@Autowired private CargosTOBuilder cargoTOBuilder;
	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;

	public ColaboradoresProjeto build(ColaboradoresProjetoTO p) {
		ColaboradoresProjeto retorno = new ColaboradoresProjeto();
		
		retorno.setId(p.getId());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		
		retorno.setProjeto(toBuilder.build(p.getProjeto()));
		retorno.setCargo(cargoTOBuilder.build(p.getCargo()));
		retorno.setFuncionario(funcionarioTOBuilder.build(p.getFuncionario()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());
		
		return retorno;
	}

	
	public ColaboradoresProjetoTO buildTO(ColaboradoresProjeto p) {
		ColaboradoresProjetoTO retorno = new ColaboradoresProjetoTO();
		
		retorno.setId(p.getId());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		
		retorno.setProjeto(toBuilder.buildTO(p.getProjeto()));
		retorno.setCargo(cargoTOBuilder.buildTO(p.getCargo()));
		retorno.setFuncionario(funcionarioTOBuilder.buildTO(p.getFuncionario()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		
		return retorno;
	}
	
	
	
	public List<ColaboradoresProjetoTO> buildAll(List<ColaboradoresProjeto> dtos){
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
