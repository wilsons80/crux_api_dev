package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.CargosTOBuilder;
import br.com.crux.dao.repository.CargoRepository;
import br.com.crux.entity.Cargo;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.CargoTO;

@Component
public class GetCargosCmd {

	@Autowired private CargoRepository repository;
	@Autowired private CargosTOBuilder toBuilder;
	
	
	
	public List<CargoTO> getAll() {
		List<CargoTO> entitys = toBuilder.buildAll(repository.findAll());
		if(entitys == null || entitys.isEmpty()) {
			return new ArrayList<CargoTO>();
		}
		return entitys;
	}
	
	public CargoTO getById(Long id) {
		Optional<Cargo> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Cargo não encontrado");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
