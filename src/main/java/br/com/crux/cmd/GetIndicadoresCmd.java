package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IndicadoresTOBuilder;
import br.com.crux.dao.repository.IndicadoresRepository;
import br.com.crux.entity.Indicadores;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.IndicadoresTO;

@Component
public class GetIndicadoresCmd {

	@Autowired private IndicadoresRepository indicadoresRepository;
	@Autowired private IndicadoresTOBuilder indicadoresTOBuilder;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<IndicadoresTO> getAll() {
		Long idUnidade = getUnidadeLogadaCmd.get().getId();
		Optional<List<Indicadores>> entitys = indicadoresRepository.findByIdUnidade(idUnidade);
		if(entitys.isPresent()) {
			return indicadoresTOBuilder.buildAll(entitys.get());
		}
		return new ArrayList<IndicadoresTO>();
	}
	
	public IndicadoresTO getById(Long id) {
		Optional<Indicadores> entityOptional = indicadoresRepository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Indicador não encontrado");
		}
		return indicadoresTOBuilder.buildTO(entityOptional.get());
	}
			
}
