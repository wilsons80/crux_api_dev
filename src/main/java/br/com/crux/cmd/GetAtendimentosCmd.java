package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtendimentosTOBuilder;
import br.com.crux.dao.repository.AtendimentosRepository;
import br.com.crux.entity.Atendimentos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AtendimentosTO;

@Component
public class GetAtendimentosCmd {

	@Autowired private AtendimentosRepository repository;
	@Autowired private AtendimentosTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<AtendimentosTO> getAll() {
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		Optional<List<Atendimentos>> entitys = repository.findByUnidade(idUnidade);
		if(entitys.isPresent()) {
			return toBuilder.buildAll(entitys.get());
		}
		return new ArrayList<AtendimentosTO>();
	}
	
	public AtendimentosTO getById(Long id) {
		Optional<Atendimentos> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Atendimento não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
