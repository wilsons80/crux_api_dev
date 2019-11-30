package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.AlocacoesFuncionario;
import br.com.crux.to.AlocacoesFuncionarioTO;

@Component
public class AlocacoesFuncionarioTOBuilder {

	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;
	@Autowired private ProgramaTOBuilder programaTOBuilder;
	@Autowired private ProjetoTOBuilder projetoTOBuilder;

	public AlocacoesFuncionario build(AlocacoesFuncionarioTO to) {

		AlocacoesFuncionario retorno = new AlocacoesFuncionario();

		retorno.setId(to.getId());
		retorno.setDataInicioVinculacao(to.getDataInicioVinculacao());
		retorno.setDataFimVinculacao(to.getDataFimVinculacao());
		retorno.setFuncionario(funcionarioTOBuilder.buildSemRelacionamentosCircular(to.getFuncionario()));
		retorno.setPrograma(programaTOBuilder.build(to.getPrograma()));
		retorno.setProjeto(projetoTOBuilder.build(to.getProjeto()));
		retorno.setUsuarioAlteracao(to.getUsuarioAlteracao());

		return retorno;
	}

	public AlocacoesFuncionarioTO buildTO(AlocacoesFuncionario p) {
		AlocacoesFuncionarioTO retorno = new AlocacoesFuncionarioTO();

		if (Objects.isNull(p)) {
			return retorno;
		}
		
		retorno.setId(p.getId());
		retorno.setDataInicioVinculacao(p.getDataInicioVinculacao());
		retorno.setDataFimVinculacao(p.getDataFimVinculacao());
		retorno.setFuncionario(funcionarioTOBuilder.buildTOSemRelacionamentosCircular(p.getFuncionario()));
		retorno.setPrograma(programaTOBuilder.buildTO(p.getPrograma()));
		retorno.setProjeto(projetoTOBuilder.buildTO(p.getProjeto()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());		

		return retorno;
	}

	public List<AlocacoesFuncionarioTO> buildAll(List<AlocacoesFuncionario> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}
	
	public List<AlocacoesFuncionario> buildTOAll(List<AlocacoesFuncionarioTO> dtos) {
		return dtos.stream().map(dto -> build(dto)).collect(Collectors.toList());
	}


}
