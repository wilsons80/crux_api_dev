package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ResponsaveisAlunoTOBuilder;
import br.com.crux.dao.repository.ResponsaveisAlunoRepository;
import br.com.crux.entity.ResponsaveisAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.ResponsaveisAlunoTO;

@Component
public class GetResponsaveisAlunoCmd {

	@Autowired private ResponsaveisAlunoRepository repository;
	@Autowired private ResponsaveisAlunoTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<ResponsaveisAlunoTO> getAll() {
		Optional<ResponsaveisAluno> unidade = repository.findById(getUnidadeLogadaCmd.get().getId());
		
		return toBuilder.buildAll(repository.findByUnidade(unidade.get().getId()).get());
	}
	
	public ResponsaveisAlunoTO getById(Long id) {
		Optional<ResponsaveisAluno> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Responsaveis do Aluno não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
