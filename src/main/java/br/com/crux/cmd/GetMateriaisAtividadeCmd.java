package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisAtividadeTOBuilder;
import br.com.crux.dao.repository.MateriaisAtividadeRepository;
import br.com.crux.entity.MateriaisAtividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.MateriaisAtividadeTO;

@Component
public class GetMateriaisAtividadeCmd {

	@Autowired private MateriaisAtividadeRepository repository;
	@Autowired private MateriaisAtividadeTOBuilder toBuilder;

	public List<MateriaisAtividadeTO> getAll() {
		List<MateriaisAtividadeTO> entitys = toBuilder.buildAll(repository.findAll());
		if (entitys == null || entitys.isEmpty()) {
			return new ArrayList<MateriaisAtividadeTO>();
		}
		return entitys;
	}

	public MateriaisAtividadeTO getTOById(Long id) {
		MateriaisAtividade entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Material da Atividade não encontrado."));
		return toBuilder.buildTO(entity);
	}

	public List<MateriaisAtividadeTO> getAllTOPorAtividade(Long id) {
		List<MateriaisAtividade> lista = repository.getPorAtividade(id).orElseThrow(() -> new NotFoundException("Material da Atividade não encontrado."));
		return toBuilder.buildAll(lista);
	}

	public List<MateriaisAtividade> getAllPorAtividade(Long id) {
		return repository.getPorAtividade(id).orElseThrow(() -> new NotFoundException("Material da Atividade não encontrado."));
	}
}
