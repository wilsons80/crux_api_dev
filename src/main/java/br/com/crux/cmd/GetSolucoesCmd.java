package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.SolucoesTOBuilder;
import br.com.crux.dao.repository.SolucoesRepository;
import br.com.crux.entity.Solucoes;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.SolucoesTO;

@Component
public class GetSolucoesCmd {

	@Autowired private SolucoesRepository repository;
	@Autowired private SolucoesTOBuilder toBuilder;
	
	public List<SolucoesTO> getAll() {
		return toBuilder.buildAll(repository.findAll());
	}
	
	public SolucoesTO getById(Long id) {
		Optional<Solucoes> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Solução não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
