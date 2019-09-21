package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesAlunoTOBuilder;
import br.com.crux.dao.repository.AtividadesAlunoRepository;
import br.com.crux.entity.AtividadesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AtividadesAlunoTO;

@Component
public class GetAtividadesAlunoCmd {

	@Autowired private AtividadesAlunoRepository repository;
	@Autowired private AtividadesAlunoTOBuilder toBuilder;
	
	public List<AtividadesAlunoTO> getAll() {
		List<AtividadesAlunoTO> entitys = toBuilder.buildAll(repository.findAll());
		if(entitys == null || entitys.isEmpty()) {
			return new ArrayList<AtividadesAlunoTO>();
		}
		return entitys;
	}
	
	public AtividadesAlunoTO getById(Long id) {
		Optional<AtividadesAluno> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Atividade de Aluno não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
