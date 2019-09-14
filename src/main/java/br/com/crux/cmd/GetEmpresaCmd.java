package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.EmpresaTOBuilder;
import br.com.crux.dao.repository.EmpresaRepository;
import br.com.crux.entity.Empresa;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.EmpresaTO;

@Component
public class GetEmpresaCmd {

	@Autowired private EmpresaRepository repository;
	@Autowired private EmpresaTOBuilder toBuilder;
	
	
	
	public List<EmpresaTO> getAll() {
		return toBuilder.buildAll(repository.findAll());
	}
	
	public EmpresaTO getById(Long id) {
		Optional<Empresa> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Empresa não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
