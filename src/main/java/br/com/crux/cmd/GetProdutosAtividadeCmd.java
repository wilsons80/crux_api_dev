package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ProdutosAtividadeTOBuilder;
import br.com.crux.dao.repository.ProdutosAtividadeRepository;
import br.com.crux.entity.MateriaisAtividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.MateriaisAtividadeTO;

@Component
public class GetProdutosAtividadeCmd {

	@Autowired private ProdutosAtividadeRepository repository;
	@Autowired private ProdutosAtividadeTOBuilder toBuilder;

	public List<MateriaisAtividadeTO> getAll() {
		List<MateriaisAtividadeTO> entitys = toBuilder.buildAll(repository.findAll());
		if (entitys == null || entitys.isEmpty()) {
			return new ArrayList<MateriaisAtividadeTO>();
		}
		return entitys;
	}

	public MateriaisAtividadeTO getTOById(Long id) {
		MateriaisAtividade entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Produto da Atividade não encontrado."));
		return toBuilder.buildTO(entity);
	}

	public List<MateriaisAtividadeTO> getPorAtividade(Long id) {
		List<MateriaisAtividade> lista = repository.getPorAtividade(id).orElseThrow(() -> new NotFoundException("Produto da Atividade não encontrado."));
		return toBuilder.buildAll(lista);
	}

}
