package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.GrausInstrucaoTOBuilder;
import br.com.crux.dao.repository.GrausInstrucaoRepository;
import br.com.crux.entity.GrausInstrucao;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.GrausInstrucaoTO;

@Component
public class GetGrausInstrucaoCmd {

	@Autowired private GrausInstrucaoRepository repository;
	@Autowired private GrausInstrucaoTOBuilder toBuilder;
	
	
	
	public List<GrausInstrucaoTO> getAll() {
		return toBuilder.buildAll(repository.findAll());
	}
	
	public GrausInstrucaoTO getById(Long id) {
		Optional<GrausInstrucao> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Graus de Instrução não encontrado");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
