package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MetasTOBuilder;
import br.com.crux.dao.repository.MetasRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Metas;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.MetasTO;

@Component
public class GetMetasCmd {

	@Autowired private MetasRepository metasRepository;
	@Autowired private MetasTOBuilder metasTOBuilder;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<MetasTO> getAll() {
		Optional<Unidade> unidade = unidadeRepository.findById(getUnidadeLogadaCmd.get().getIdUnidade());
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		
		Optional<List<Metas>> perspectivas = metasRepository.findByIdUnidade(unidade.get().getIdUnidade());
		if(perspectivas.isPresent()) {
			return metasTOBuilder.buildAll(perspectivas.get());
		}
		return null;
	}
	
	public MetasTO getById(Long id) {
		Optional<Metas> entityOptional = metasRepository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Meta não encontrado");
		}
		return metasTOBuilder.buildTO(entityOptional.get());
	}
			
}
