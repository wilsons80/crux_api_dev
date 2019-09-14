package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.TalentosPFTOBuilder;
import br.com.crux.dao.repository.TalentosPFRepository;
import br.com.crux.entity.TalentosPf;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.TalentosPfTO;

@Component
public class GetTalentosPFCmd {

	@Autowired private TalentosPFRepository repository;
	@Autowired private TalentosPFTOBuilder toBuilder;
	
	
	public List<TalentosPfTO> getAllPorUnidadeLogada() {
		List<TalentosPfTO> lista = toBuilder.buildAll(repository.findAll());
		
		if(lista == null || lista.isEmpty()) {
			return new ArrayList<TalentosPfTO>();
		}
		
		return lista;
	}
	
	public TalentosPfTO getById(Long id) {
		Optional<TalentosPf> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Talentos do Funcionario não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
