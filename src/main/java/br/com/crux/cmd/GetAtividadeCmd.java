package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadeTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.entity.Atividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AtividadeTO;

@Component
public class GetAtividadeCmd {

	@Autowired private AtividadeRepository repository;
	@Autowired private AtividadeTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<AtividadeTO> getAll() {
		Optional<Atividade> unidade = repository.findById(getUnidadeLogadaCmd.get().getId());
		
		return toBuilder.buildAll(repository.findByUnidade(unidade.get().getId()).get());
	}
	
	public AtividadeTO getById(Long id) {
		Optional<Atividade> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Atividade não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
