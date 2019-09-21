package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ReprovacoesAlunoTOBuilder;
import br.com.crux.dao.repository.ReprovacoesAlunoRepository;
import br.com.crux.entity.ReprovacoesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.ReprovacoesAlunoTO;

@Component
public class GetReprovacoesAlunoCmd {

	@Autowired private ReprovacoesAlunoRepository repository;
	@Autowired private ReprovacoesAlunoTOBuilder toBuilder;
	
	public List<ReprovacoesAlunoTO> getAll() {
		List<ReprovacoesAlunoTO> entitys = toBuilder.buildAll(repository.findAll());
		if(entitys == null || entitys.isEmpty()) {
			return new ArrayList<ReprovacoesAlunoTO>();
		}
		return entitys;
	}
	
	public ReprovacoesAlunoTO getById(Long id) {
		Optional<ReprovacoesAluno> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Reprovacoes do Aluno não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
