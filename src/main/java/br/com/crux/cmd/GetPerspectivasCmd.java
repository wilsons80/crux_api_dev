package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PerspectivaTOBuilder;
import br.com.crux.dao.repository.PerspectivaRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Perspectiva;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.PerspectivaTO;

@Component
public class GetPerspectivasCmd {

	@Autowired
	private PerspectivaRepository perspectivaRepository;
	@Autowired
	private PerspectivaTOBuilder perspectivaTOBuilder;
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public List<PerspectivaTO> getAll(Long idUnidade) {
		Optional<Unidade> unidade = unidadeRepository.findById(idUnidade);
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		
		Optional<List<Perspectiva>> perspectivas = perspectivaRepository.findByUnidade(unidade.get());
		if(perspectivas.isPresent()) {
			return perspectivaTOBuilder.buildAll(perspectivas.get());
		}
		return null;
	}
	
	public PerspectivaTO getById(Long id) {
		Optional<Perspectiva> entityOptional = perspectivaRepository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Perspectiva não encontrado");
		}
		return perspectivaTOBuilder.buildTO(entityOptional.get());
	}
			
}
