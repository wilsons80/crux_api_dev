package br.com.crux.cmd;

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
	
	public ResponsaveisAlunoTO getById(Long id) {
		ResponsaveisAluno entityOptional = repository.findById(id).orElseThrow(() -> new NotFoundException("Responsaveis do Aluno não encontrado."));
		return toBuilder.buildTO(entityOptional);
	}
			
}
