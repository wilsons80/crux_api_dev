package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.QuestionariosTOBuilder;
import br.com.crux.dao.repository.QuestionariosRepository;
import br.com.crux.entity.Questionario;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.QuestionariosTO;

@Component
public class GetQuestionariosCmd {

	@Autowired private QuestionariosRepository repository;
	@Autowired private QuestionariosTOBuilder toBuilder;
	
	
	
	public List<QuestionariosTO> getAll() {
		return toBuilder.buildAll(repository.findAll());
	}
	
	public QuestionariosTO getById(Long id) {
		Optional<Questionario> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Questionario não encontrado");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
