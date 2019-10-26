package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;

	public List<AtividadesAlunoTO> getAll() {
		List<AtividadesAlunoTO> entitys = toBuilder.buildAll(repository.findAll());
		if (entitys == null || entitys.isEmpty()) {
			return new ArrayList<AtividadesAlunoTO>();
		}
		return entitys;
	}

	public AtividadesAlunoTO getTOById(Long id) {
		AtividadesAluno entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Atividade de Aluno não encontrada."));
		return toBuilder.buildTO(entity);
	}

	public AtividadesAluno getById(Long id) {
		return repository.findById(id).orElseGet(null);
	}

	public List<AtividadesAlunoTO> getByAluno(Long id) {

		Optional<List<AtividadesAluno>> entitys = repository.getByAluno(id, getUnidadeLogadaCmd.get().getId());

		if (!entitys.isPresent()) {
			return Collections.emptyList();
		}

		return toBuilder.buildAll(entitys.get());
	}

	public List<AtividadesAlunoTO> getByAtividade(Long id) {
		Optional<List<AtividadesAluno>> entitys = repository.getByAtividade(id, getUnidadeLogadaCmd.get().getId());

		if (!entitys.isPresent()) {
			return Collections.emptyList();
		}

		return toBuilder.buildAll(entitys.get());

	}

	public List<AtividadesAlunoTO> getByAlunoEAtividade(Long idAluno, Long idAtividade) {
		Optional<List<AtividadesAluno>> entitys = repository.getByAlunoEAtividade(idAluno,idAtividade,getUnidadeLogadaCmd.get().getId());
		
		if (!entitys.isPresent()) {
			return Collections.emptyList();
		}

		return toBuilder.buildAll(entitys.get());
	}

}
