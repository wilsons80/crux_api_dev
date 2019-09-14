package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AcoesCompetenciaTOBuilder;
import br.com.crux.dao.repository.AcoesCompetenciaRepository;
import br.com.crux.entity.AcoesCompetencia;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AcoesCompetenciaTO;

@Component
public class GetAcoesCompetenciaCmd {

	@Autowired private AcoesCompetenciaRepository repository;
	@Autowired private AcoesCompetenciaTOBuilder toBuilder;
	
	
	public List<AcoesCompetenciaTO> getAllPorUnidadeLogada() {
		List<AcoesCompetenciaTO> lista = toBuilder.buildAll(repository.findAll());
		
		if(lista == null || lista.isEmpty()) {
			return new ArrayList<AcoesCompetenciaTO>();
		}
		
		return lista;
	}
	
	public AcoesCompetenciaTO getById(Long id) {
		Optional<AcoesCompetencia> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Ações das competências do talento do Funcionario não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
