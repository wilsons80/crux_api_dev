package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProgramaTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProgramaRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.ColaboradoresProgramaTO;

@Component
public class GetColaboradoresProgramaCmd {

	@Autowired private ColaboradoresProgramaRepository repository;
	@Autowired private ColaboradoresProgramaTOBuilder toBuilder;
	
	@Autowired private UnidadeRepository unidadeRepository;
	
	
	public List<ColaboradoresProgramaTO> getAll(Long idUnidade) {
		Optional<Unidade> unidade = unidadeRepository.findById(idUnidade);
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		
		Optional<List<ColaboradoresPrograma>> listaRetorno = repository.findByIdUnidade(unidade.get().getIdUnidade());
		if(listaRetorno.isPresent()) {
			return toBuilder.buildAll(listaRetorno.get());
		}
		return null;
	}
	
	public ColaboradoresProgramaTO getById(Long id) {
		Optional<ColaboradoresPrograma> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Colaborador do Programa não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
