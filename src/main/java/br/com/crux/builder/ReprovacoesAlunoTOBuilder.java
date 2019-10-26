package br.com.crux.builder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.cmd.GetAlunoCmd;
import br.com.crux.entity.Aluno;
import br.com.crux.entity.ReprovacoesAluno;
import br.com.crux.to.ReprovacoesAlunoTO;

@Component
public class ReprovacoesAlunoTOBuilder {

	@Autowired private AlunoTOBuilder alunoBuilder;
	@Autowired private GetAlunoCmd getAlunoCmd;

	public ReprovacoesAluno build(ReprovacoesAlunoTO p) {
		ReprovacoesAluno retorno = new ReprovacoesAluno();

		retorno.setId(p.getId());
		retorno.setDataReprovacao(p.getDataReprovacao());
		retorno.setDescricaoMotivo(p.getDescricaoMotivo());
		retorno.setSerieReprovacao(p.getSerieReprovacao());
		retorno.setQtdReprovacao(p.getQtdReprovacao());
		
		Optional.ofNullable(p.getAluno()).ifPresent(a -> {
			Aluno aluno = getAlunoCmd.getById(a.getId());
			retorno.setAluno(aluno);
		});
		
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());

		return retorno;
	}

	public ReprovacoesAlunoTO buildTO(ReprovacoesAluno p) {
		ReprovacoesAlunoTO retorno = new ReprovacoesAlunoTO();
		
		retorno.setId(p.getId());
		retorno.setDataReprovacao(p.getDataReprovacao());
		retorno.setDescricaoMotivo(p.getDescricaoMotivo());
		retorno.setSerieReprovacao(p.getSerieReprovacao());
		retorno.setQtdReprovacao(p.getQtdReprovacao());
		retorno.setAluno(alunoBuilder.buildTO(p.getAluno()));
		retorno.setUsuarioAlteracao(p.getUsuarioAlteracao());


		return retorno;
	}

	public List<ReprovacoesAlunoTO> buildAll(List<ReprovacoesAluno> dtos) {
		return dtos.stream().map(dto -> buildTO(dto)).collect(Collectors.toList());
	}

}
