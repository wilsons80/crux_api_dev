package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.Atendimentos;
import br.com.crux.to.AtendimentosTO;

@Component
public class AtendimentosTOBuilder {

	@Autowired private AlunoTOBuilder alunoBuilder;
	@Autowired private SolucoesTOBuilder solucoesBuilder;
	@Autowired private DiagnosticosTOBuilder diagnosticoBuilder;

	public Atendimentos build(AtendimentosTO p) {
		Atendimentos retorno = new Atendimentos();

		retorno.setId(p.getId());
		retorno.setDescDiagnostico(p.getDescDiagnostico());
		retorno.setDescSolucao(p.getDescSolucao());
		retorno.setDataAtendimento(p.getDataAtendimento());
		retorno.setAluno(alunoBuilder.build(p.getAluno()));
		retorno.setDiagnostico(diagnosticoBuilder.build(p.getDiagnostico()));
		retorno.setSolucoe(solucoesBuilder.build(p.getSolucoes()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public AtendimentosTO buildTO(Atendimentos p) {
		AtendimentosTO retorno = new AtendimentosTO();
		
		retorno.setId(p.getId());
		retorno.setDescDiagnostico(p.getDescDiagnostico());
		retorno.setDescSolucao(p.getDescSolucao());
		retorno.setDataAtendimento(p.getDataAtendimento());
		retorno.setAluno(alunoBuilder.buildTO(p.getAluno()));
		retorno.setDiagnostico(diagnosticoBuilder.buildTO(p.getDiagnostico()));
		retorno.setSolucoes(solucoesBuilder.buildTO(p.getSolucoe()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<AtendimentosTO> buildAll(List<Atendimentos> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
