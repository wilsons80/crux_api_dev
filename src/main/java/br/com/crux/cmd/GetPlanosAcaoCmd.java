package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.PlanosAcaoTOBuilder;
import br.com.crux.dao.repository.PlanosAcaoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.PlanosAcao;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.PlanosAcaoTO;

@Component
public class GetPlanosAcaoCmd {

	@Autowired
	private PlanosAcaoRepository repository;
	@Autowired
	private PlanosAcaoTOBuilder toBuilder;
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	public List<PlanosAcaoTO> getAll(Long idUnidade) {
		Optional<Unidade> unidade = unidadeRepository.findById(idUnidade);
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		
		Optional<List<PlanosAcao>> listaRetorno = repository.findByIdUnidade(unidade.get().getIdUnidade());
		if(listaRetorno.isPresent()) {
			return toBuilder.buildAll(listaRetorno.get());
		}
		return null;
	}
	
	public PlanosAcaoTO getById(Long id) {
		Optional<PlanosAcao> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Planos de Acao não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
