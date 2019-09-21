package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.VulnerabilidadesFamiliarTOBuilder;
import br.com.crux.dao.repository.VulnerabilidadesFamiliarRepository;
import br.com.crux.entity.VulnerabilidadesFamiliar;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.VulnerabilidadesFamiliarTO;

@Component
public class GetVulnerabilidadesFamiliarCmd {

	@Autowired private VulnerabilidadesFamiliarRepository repository;
	@Autowired private VulnerabilidadesFamiliarTOBuilder toBuilder;
	
	public List<VulnerabilidadesFamiliarTO> getAll() {
		return toBuilder.buildAll(repository.findAll());
	}
	
	public VulnerabilidadesFamiliarTO getById(Long id) {
		Optional<VulnerabilidadesFamiliar> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Vulnerabilidades  da Familia não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
