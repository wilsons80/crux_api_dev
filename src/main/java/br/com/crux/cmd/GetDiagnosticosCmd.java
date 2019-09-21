package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.DiagnosticosTOBuilder;
import br.com.crux.dao.repository.DiagnosticosRepository;
import br.com.crux.entity.Diagnosticos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.DiagnosticosTO;

@Component
public class GetDiagnosticosCmd {

	@Autowired private DiagnosticosRepository repository;
	@Autowired private DiagnosticosTOBuilder toBuilder;
	
	public List<DiagnosticosTO> getAll() {
		List<DiagnosticosTO> entitys = toBuilder.buildAll(repository.findAll());
		if(entitys == null || entitys.isEmpty()) {
			return new ArrayList<DiagnosticosTO>();
		}
		return entitys;
	}
	
	public DiagnosticosTO getById(Long id) {
		Optional<Diagnosticos> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Diagnostico não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
