package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.VulnerabilidadesAlunoTOBuilder;
import br.com.crux.dao.repository.VulnerabilidadesAlunoRepository;
import br.com.crux.entity.VulnerabilidadesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.VulnerabilidadesAlunoTO;

@Component
public class GetVulnerabilidadesAlunoCmd {

	@Autowired private VulnerabilidadesAlunoRepository repository;
	@Autowired private VulnerabilidadesAlunoTOBuilder toBuilder;
	
	public List<VulnerabilidadesAlunoTO> getAll() {
		return toBuilder.buildAll(repository.findAll());
	}
	
	public VulnerabilidadesAlunoTO getById(Long id) {
		Optional<VulnerabilidadesAluno> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Vulnerabilidades  do aluno não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
