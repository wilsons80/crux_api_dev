package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ProdutoTOBuilder;
import br.com.crux.dao.repository.ProdutoRepository;
import br.com.crux.entity.Produto;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.ProdutoTO;

@Component
public class GetProdutoCmd {

	@Autowired private ProdutoRepository repository;
	@Autowired private ProdutoTOBuilder toBuilder;

	public List<ProdutoTO> getAll() {
		List<ProdutoTO> entitys = toBuilder.buildAll(repository.findAll());
		if (entitys == null || entitys.isEmpty()) {
			return new ArrayList<ProdutoTO>();
		}
		return entitys;
	}

	public ProdutoTO getTOById(Long id) {
		Produto entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Produto não encontrado."));
		return toBuilder.buildTO(entity);
	}

	public Produto getById(Long id) {
		return repository.findById(id).orElseGet(null);
	}

}
