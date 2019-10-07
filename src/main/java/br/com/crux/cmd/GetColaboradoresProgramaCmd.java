package br.com.crux.cmd;

import java.util.ArrayList;
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
import br.com.crux.to.ColaboradoresProgramaTO;

@Component
public class GetColaboradoresProgramaCmd {

	@Autowired private ColaboradoresProgramaRepository repository;
	@Autowired private ColaboradoresProgramaTOBuilder toBuilder;
	
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<ColaboradoresProgramaTO> getAll() {
		Optional<Unidade> unidade = unidadeRepository.findById(getUnidadeLogadaCmd.get().getId());
		Optional<List<ColaboradoresPrograma>> listaRetorno = repository.findByIdUnidade(unidade.get().getIdUnidade());
		if(listaRetorno.isPresent()) {
			return toBuilder.buildAll(listaRetorno.get());
		}
		return new ArrayList<ColaboradoresProgramaTO>();
	}
	
	public ColaboradoresProgramaTO getById(Long id) {
		ColaboradoresPrograma entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Colaborador do Programa não encontrado.") );
		return toBuilder.buildTO(entity);
	}

	public List<ColaboradoresProgramaTO> getPorPrograma(Long id) {
		List<ColaboradoresPrograma> lista = repository.getPorPrograma(id).orElseThrow(() -> new NotFoundException("Colaborador do Programa não encontrado."));
		return toBuilder.buildAll(lista);
	}
			
}
