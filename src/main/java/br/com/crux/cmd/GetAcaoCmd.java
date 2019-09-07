package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AcaoTOBuilder;
import br.com.crux.dao.repository.AcaoRepository;
import br.com.crux.entity.Acoes;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AcaoTO;

@Component
public class GetAcaoCmd {

	@Autowired private AcaoRepository repository;
	@Autowired private AcaoTOBuilder toBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<AcaoTO> getAll() {
		Optional<Acoes> unidade = repository.findById(getUnidadeLogadaCmd.get().getId());
		
		return toBuilder.buildAll(repository.findByUnidade(unidade.get().getId()).get());
	}
	
	public AcaoTO getById(Long id) {
		Optional<Acoes> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Acao não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
