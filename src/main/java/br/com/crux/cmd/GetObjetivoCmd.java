package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ObjetivoTOBuilder;
import br.com.crux.dao.repository.ObjetivoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Objetivo;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.ObjetivoTO;

@Component
public class GetObjetivoCmd {

	@Autowired private ObjetivoRepository objetivoRepository;
	@Autowired private ObjetivoTOBuilder objetivoTOBuilder;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<ObjetivoTO> getAll() {
		Optional<Unidade> unidade = unidadeRepository.findById(getUnidadeLogadaCmd.get().getIdUnidade());
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		
		Optional<List<Objetivo>> perspectivas = objetivoRepository.findByIdUnidade(unidade.get().getIdUnidade());
		if(perspectivas.isPresent()) {
			return objetivoTOBuilder.buildAll(perspectivas.get());
		}
		return null;
	}
	
	public ObjetivoTO getById(Long id) {
		Optional<Objetivo> entityOptional = objetivoRepository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Objetivo não encontrado");
		}
		return objetivoTOBuilder.buildTO(entityOptional.get());
	}
			
}
