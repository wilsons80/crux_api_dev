package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AvaliacoesAlunosTOBuilder;
import br.com.crux.dao.repository.AvaliacoesAlunosRepository;
import br.com.crux.entity.AvaliacoesAlunos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AvaliacoesAlunosTO;

@Component
public class GetAvaliacoesAlunosCmd {

	@Autowired private AvaliacoesAlunosRepository repository;
	@Autowired private AvaliacoesAlunosTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<AvaliacoesAlunosTO> getAll() {
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		Optional<List<AvaliacoesAlunos>> entitys = repository.findByUnidade(idUnidade);
		if(entitys.isPresent()) {
			return toBuilder.buildAll(entitys.get());
		}
		return new ArrayList<AvaliacoesAlunosTO>();
	}
	
	public AvaliacoesAlunosTO getById(Long id) {
		Optional<AvaliacoesAlunos> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Avaliação do aluno não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
