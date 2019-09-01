package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.IndicadoresTOBuilder;
import br.com.crux.dao.repository.IndicadoresRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Indicadores;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.IndicadoresTO;

@Component
public class GetIndicadoresCmd {

	@Autowired
	private IndicadoresRepository indicadoresRepository;
	@Autowired
	private IndicadoresTOBuilder indicadoresTOBuilder;
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public List<IndicadoresTO> getAll(Long idUnidade) {
		Optional<Unidade> unidade = unidadeRepository.findById(idUnidade);
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		
		Optional<List<Indicadores>> perspectivas = indicadoresRepository.findByIdUnidade(unidade.get().getIdUnidade());
		if(perspectivas.isPresent()) {
			return indicadoresTOBuilder.buildAll(perspectivas.get());
		}
		return null;
	}
	
	public IndicadoresTO getById(Long id) {
		Optional<Indicadores> entityOptional = indicadoresRepository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Indicador não encontrado");
		}
		return indicadoresTOBuilder.buildTO(entityOptional.get());
	}
			
}
