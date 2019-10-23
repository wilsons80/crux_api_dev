package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.VulnerabilidadesAluno;
import br.com.crux.to.AlunoTO;
import br.com.crux.to.VulnerabilidadesAlunoTO;

@Component
public class VulnerabilidadesAlunoTOBuilder {

	@Autowired private AlunoTOBuilder alunoBuilder;
	@Autowired private SituacoesVulnerabilidadeTOBuilder situacaoVulnerabilidadeBuilder;
	@Autowired private SolucoesTOBuilder solucaoBuilder;

	public VulnerabilidadesAluno build(VulnerabilidadesAlunoTO p, AlunoTO alunoTO) {
		VulnerabilidadesAluno retorno = new VulnerabilidadesAluno();

		retorno.setId(p.getId());
		retorno.setDataIdentificacao(p.getDataIdentificacao());
		retorno.setDataSolucao(p.getDataSolucao());
		
		retorno.setAluno(alunoBuilder.build(alunoTO));
		retorno.setSolucoes(solucaoBuilder.build(p.getSolucoes()));
		retorno.setSituacoesVulnerabilidade(situacaoVulnerabilidadeBuilder.build(p.getSituacoesVulnerabilidade()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public VulnerabilidadesAlunoTO buildTO(VulnerabilidadesAluno p) {
		VulnerabilidadesAlunoTO retorno = new VulnerabilidadesAlunoTO();
		
		retorno.setId(p.getId());
		retorno.setDataIdentificacao(p.getDataIdentificacao());
		retorno.setDataSolucao(p.getDataSolucao());
		
		retorno.setAluno(alunoBuilder.buildTO(p.getAluno()));
		retorno.setSolucoes(solucaoBuilder.buildTO(p.getSolucoes()));
		retorno.setSituacoesVulnerabilidade(situacaoVulnerabilidadeBuilder.buildTO(p.getSituacoesVulnerabilidade()));
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<VulnerabilidadesAlunoTO> buildAll(List<VulnerabilidadesAluno> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
