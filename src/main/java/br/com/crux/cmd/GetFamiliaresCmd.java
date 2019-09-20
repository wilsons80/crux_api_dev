package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FamiliaresTOBuilder;
import br.com.crux.dao.repository.FamiliaresRepository;
import br.com.crux.entity.Familiares;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.FamiliaresTO;

@Component
public class GetFamiliaresCmd {

	@Autowired private FamiliaresRepository repository;
	@Autowired private FamiliaresTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<FamiliaresTO> getAll() {
		Optional<Familiares> unidade = repository.findById(getUnidadeLogadaCmd.get().getId());
		
		return toBuilder.buildAll(repository.findByUnidade(unidade.get().getId()).get());
	}
	
	public FamiliaresTO getById(Long id) {
		Optional<Familiares> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Familiar não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
