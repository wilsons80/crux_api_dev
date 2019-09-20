package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.dao.repository.AlunoRepository;
import br.com.crux.entity.Aluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AlunoTO;

@Component
public class GetAlunoCmd {

	@Autowired private AlunoRepository repository;
	@Autowired private AlunoTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<AlunoTO> getAll() {
		Optional<Aluno> unidade = repository.findById(getUnidadeLogadaCmd.get().getId());
		return toBuilder.buildAll(repository.findByUnidade(unidade.get().getId()).get());
	}
	
	public AlunoTO getById(Long id) {
		Optional<Aluno> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Aluno não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
