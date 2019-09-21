package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.EncaminhaAlunosTOBuilder;
import br.com.crux.dao.repository.EncaminhaAlunosRepository;
import br.com.crux.entity.EncaminhaAlunos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.EncaminhaAlunosTO;

@Component
public class GetEncaminhaAlunosCmd {

	@Autowired private EncaminhaAlunosRepository repository;
	@Autowired private EncaminhaAlunosTOBuilder toBuilder;
	
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<EncaminhaAlunosTO> getAll() {
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		Optional<List<EncaminhaAlunos>> entitys = repository.findByUnidade(idUnidade);
		if(entitys.isPresent()) {
			return toBuilder.buildAll(entitys.get());
		}
		return new ArrayList<EncaminhaAlunosTO>();
	}
	
	public EncaminhaAlunosTO getById(Long id) {
		Optional<EncaminhaAlunos> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Encaminhamento do aluno não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
