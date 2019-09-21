package br.com.crux.cmd;

import java.util.ArrayList;
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
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		Optional<List<ResponsaveisAluno>> entitys = repository.findByUnidade(idUnidade);
		if(entitys.isPresent()) {
			return toBuilder.buildAll(entitys.get());
		}
		return new ArrayList<ResponsaveisAlunoTO>();
	}
	
	public ResponsaveisAlunoTO getById(Long id) {
		Optional<ResponsaveisAluno> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Responsaveis do Aluno não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
