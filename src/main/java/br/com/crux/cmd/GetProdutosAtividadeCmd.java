package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

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
		return toBuilder.buildAll(repository.findAll());
	}
	
	public ProdutosAtividadeTO getById(Long id) {
		Optional<ProdutosAtividade> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Produto da Atividade não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
