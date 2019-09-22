package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.AlunosTrabalhando;
import br.com.crux.to.AlunosTrabalhandoTO;

@Component
public class AlunosTrabalhandoTOBuilder {

	@Autowired
	private AlunoTOBuilder alunoBuilder;

	public AlunosTrabalhando build(AlunosTrabalhandoTO p) {
		AlunosTrabalhando retorno = new AlunosTrabalhando();

		retorno.setId(p.getId());
		retorno.setDescTipoEmpreendimento(p.getDescTipoEmpreendimento());
		retorno.setNomeEmpreendimento(p.getNomeEmpreendimento());
		retorno.setDataFimAlunoTrabalhando(p.getDataFimAlunoTrabalhando());
		retorno.setDataInicioAlunoTrabalhando(p.getDataInicioAlunoTrabalhando());
		retorno.setAluno(alunoBuilder.build(p.getAluno()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public AlunosTrabalhandoTO buildTO(AlunosTrabalhando p) {
		AlunosTrabalhandoTO retorno = new AlunosTrabalhandoTO();
		
		retorno.setId(p.getId());
		retorno.setDescTipoEmpreendimento(p.getDescTipoEmpreendimento());
		retorno.setNomeEmpreendimento(p.getNomeEmpreendimento());
		retorno.setDataFimAlunoTrabalhando(p.getDataFimAlunoTrabalhando());
		retorno.setDataInicioAlunoTrabalhando(p.getDataInicioAlunoTrabalhando());
		retorno.setAluno(alunoBuilder.buildTO(p.getAluno()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<AlunosTrabalhandoTO> buildAll(List<AlunosTrabalhando> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
