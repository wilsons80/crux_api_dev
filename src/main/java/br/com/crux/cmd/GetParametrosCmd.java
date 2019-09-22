package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ParametrosTOBuilder;
import br.com.crux.dao.repository.ParametrosRepository;
import br.com.crux.entity.Parametros;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.ParametrosTO;

@Component
public class GetParametrosCmd {

	@Autowired private ParametrosRepository repository;
	@Autowired private ParametrosTOBuilder toBuilder;
	
	public List<ParametrosTO> getAll() {
		List<Parametros> entitys = repository.findAll();
		if(entitys == null || entitys.isEmpty()) {
			return new ArrayList<ParametrosTO>();
		}
		return toBuilder.buildAll(entitys);
	}
	
	public ParametrosTO getById(Long id) {
		Optional<Parametros> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Parametro não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}

	
	public ParametrosTO getByCodigo(String codigo) {
		Optional<Parametros> entityOptional = repository.findByCodigo(codigo);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Parametro não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}

}
