package br.com.crux.builder;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.cmd.GetCargosCmd;
import br.com.crux.cmd.GetFuncionarioCmd;
import br.com.crux.cmd.GetProgramaCmd;
import br.com.crux.entity.Cargo;
import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.entity.Funcionario;
import br.com.crux.entity.Programa;
import br.com.crux.to.ColaboradoresProgramaTO;

@Component
public class ColaboradoresProgramaTOBuilder {

	@Autowired private ProgramaTOBuilder programaTOBuilder;
	@Autowired private CargosTOBuilder cargoTOBuilder;
	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;
	@Autowired private GetProgramaCmd getProgramaCmd;
	@Autowired private GetCargosCmd getCargosCmd;
	@Autowired private GetFuncionarioCmd getFuncionarioCmd;

	public ColaboradoresPrograma build(ColaboradoresProgramaTO p) {
		ColaboradoresPrograma retorno = new ColaboradoresPrograma();

		retorno.setId(p.getId());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());

		Optional.ofNullable(p.getPrograma()).ifPresent(prog -> {
			Programa programa = getProgramaCmd.getById(prog.getId());
			retorno.setPrograma(programa);
		});

		Optional.ofNullable(p.getCargo()).ifPresent(c -> {
			Cargo cargo = getCargosCmd.getById(c.getId());
			retorno.setCargo(cargo);
		});

		Optional.ofNullable(p.getFuncionario()).ifPresent(c -> {
			Funcionario funcionario = getFuncionarioCmd.getById(c.getId());
			retorno.setFuncionario(funcionario);
		});

		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public ColaboradoresProgramaTO buildTO(ColaboradoresPrograma p) {
		ColaboradoresProgramaTO retorno = new ColaboradoresProgramaTO();

		if (Objects.isNull(p)) {
			return retorno;
		}

		retorno.setId(p.getId());
		retorno.setDataInicio(p.getDataInicio());
		retorno.setDataFim(p.getDataFim());
		retorno.setPrograma(programaTOBuilder.buildTO(p.getPrograma()));

		retorno.setCargo(cargoTOBuilder.buildTO(p.getCargo()));
		retorno.setFuncionario(funcionarioTOBuilder.buildTO(p.getFuncionario()));

		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<ColaboradoresProgramaTO> buildAll(List<ColaboradoresPrograma> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
