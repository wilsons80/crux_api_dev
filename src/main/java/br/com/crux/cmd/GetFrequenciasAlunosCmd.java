package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FrequenciasAlunosTOBuilder;
import br.com.crux.dao.repository.FrequenciasAlunosRepository;
import br.com.crux.entity.FrequenciasAlunos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.FrequenciasAlunosTO;

@Component
public class GetFrequenciasAlunosCmd {

	@Autowired private FrequenciasAlunosRepository repository;
	@Autowired private FrequenciasAlunosTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<FrequenciasAlunosTO> getAll() {
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		Optional<List<FrequenciasAlunos>> entitys = repository.findByUnidade(idUnidade);
		if(entitys.isPresent()) {
			return toBuilder.buildAll(entitys.get());
		}
		return new ArrayList<FrequenciasAlunosTO>();
	}
	
	public FrequenciasAlunosTO getById(Long id) {
		Optional<FrequenciasAlunos> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Frequencia do aluno não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
