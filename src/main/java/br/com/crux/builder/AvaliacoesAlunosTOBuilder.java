package br.com.crux.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.entity.AvaliacoesAlunos;
import br.com.crux.to.AvaliacoesAlunosTO;

@Component
public class AvaliacoesAlunosTOBuilder {

	@Autowired private AvaliacoesTOBuilder avaliacoesBuilder;
	@Autowired private AtividadesAlunoTOBuilder atividadesBuilder;

	public AvaliacoesAlunos build(AvaliacoesAlunosTO p) {
		AvaliacoesAlunos retorno = new AvaliacoesAlunos();

		retorno.setId(p.getId());
		retorno.setDescriaoAvaliacao(p.getDescriaoAvaliacao());
		retorno.setDataAvaliacao(p.getDataAvaliacao());
		retorno.setAtividadesAluno(atividadesBuilder.build(p.getAtividadesAluno()));
		retorno.setAvaliacoes(avaliacoesBuilder.build(p.getAvaliacoes()));
		retorno.setNotaAvaliacao(p.getNotaAvaliacao());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public AvaliacoesAlunosTO buildTO(AvaliacoesAlunos p) {
		AvaliacoesAlunosTO retorno = new AvaliacoesAlunosTO();
		
		retorno.setId(p.getId());
		retorno.setDescriaoAvaliacao(p.getDescriaoAvaliacao());
		retorno.setDataAvaliacao(p.getDataAvaliacao());
		retorno.setAtividadesAluno(atividadesBuilder.buildTO(p.getAtividadesAluno()));
		retorno.setAvaliacoes(avaliacoesBuilder.buildTO(p.getAvaliacoes()));
		retorno.setNotaAvaliacao(p.getNotaAvaliacao());
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public List<AvaliacoesAlunosTO> buildAll(List<AvaliacoesAlunos> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
