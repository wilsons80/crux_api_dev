package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.DepartamentoTOBuilder;
import br.com.crux.dao.repository.DepartamentoRepository;
import br.com.crux.entity.Departamentos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.DepartamentoTO;

@Component
public class GetDepartamentoCmd {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	@Autowired
	private DepartamentoTOBuilder departamentoTOBuilder;
	
	
	
	public List<DepartamentoTO> getAll(Long idUnidade) {
		return departamentoTOBuilder.buildAll(departamentoRepository.findByIdUnidade(idUnidade));
	}
	
	public DepartamentoTO getDepartamentoById(Long idDepartamento) {
		Optional<Departamentos> departamentoOptional = departamentoRepository.findById(idDepartamento);
		if(!departamentoOptional.isPresent()) {
			throw new NotFoundException("Departamento não encontrado");
		}
		return departamentoTOBuilder.buildTO(departamentoOptional.get());
	}
			
}
