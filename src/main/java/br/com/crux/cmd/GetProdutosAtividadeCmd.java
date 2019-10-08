package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ProdutosAtividadeTOBuilder;
import br.com.crux.dao.repository.ProdutosAtividadeRepository;
import br.com.crux.entity.ProdutosAtividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.ProdutosAtividadeTO;

@Component
public class GetProdutosAtividadeCmd {

	@Autowired private ProdutosAtividadeRepository repository;
	@Autowired private ProdutosAtividadeTOBuilder toBuilder;

	public List<ProdutosAtividadeTO> getAll() {
		List<ProdutosAtividadeTO> entitys = toBuilder.buildAll(repository.findAll());
		if (entitys == null || entitys.isEmpty()) {
			return new ArrayList<ProdutosAtividadeTO>();
		}
		return entitys;
	}

	public ProdutosAtividadeTO getTOById(Long id) {
		ProdutosAtividade entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Produto da Atividade não encontrado."));
		return toBuilder.buildTO(entity);
	}

	public List<ProdutosAtividadeTO> getPorAtividade(Long id) {
		List<ProdutosAtividade> lista = repository.getPorAtividade(id).orElseThrow(() -> new NotFoundException("Produto da Atividade não encontrado."));
		return toBuilder.buildAll(lista);
	}

}
