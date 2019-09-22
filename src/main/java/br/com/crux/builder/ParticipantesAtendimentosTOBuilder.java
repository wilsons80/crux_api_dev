package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.ParticipantesAtendimentos;
import br.com.crux.to.ParticipantesAtendimentosTO;

@Component
public class ParticipantesAtendimentosTOBuilder {

	@Autowired private AtendimentosTOBuilder atendimentosBuilder;
	@Autowired private FamiliaresTOBuilder familiarBuilder;
	@Autowired private FuncionarioTOBuilder funcionarioBuilder;

	public ParticipantesAtendimentos build(ParticipantesAtendimentosTO p) {
		ParticipantesAtendimentos retorno = new ParticipantesAtendimentos();

		retorno.setId(p.getId());
		retorno.setFamiliar(familiarBuilder.build(p.getFamiliar()));
		retorno.setFuncionario(funcionarioBuilder.build(p.getFuncionario()));
		retorno.setAtendimento(atendimentosBuilder.build(p.getAtendimento()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public ParticipantesAtendimentosTO buildTO(ParticipantesAtendimentos p) {
		ParticipantesAtendimentosTO retorno = new ParticipantesAtendimentosTO();
		
		retorno.setId(p.getId());
		retorno.setFamiliar(familiarBuilder.buildTO(p.getFamiliar()));
		retorno.setFuncionario(funcionarioBuilder.buildTO(p.getFuncionario()));
		retorno.setAtendimento(atendimentosBuilder.buildTO(p.getAtendimento()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<ParticipantesAtendimentosTO> buildAll(List<ParticipantesAtendimentos> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
