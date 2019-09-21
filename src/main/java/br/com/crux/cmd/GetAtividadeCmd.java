package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.entity.Atividades;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AtividadesTO;

@Component
public class GetAtividadeCmd {

	@Autowired private AtividadeRepository repository;
	@Autowired private AtividadesTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<AtividadesTO> getAll() {
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		Optional<List<Atividades>> entitys = repository.findByIdUnidade(idUnidade);
		if(entitys.isPresent()) {
			return toBuilder.buildAll(entitys.get());
		}
		return new ArrayList<AtividadesTO>();
	}
	
	public AtividadesTO getById(Long id) {
		Optional<Atividades> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Atividade não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
