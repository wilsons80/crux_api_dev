package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProjetoTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProjetoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.ColaboradoresProjetoTO;

@Component
public class GetColaboradoresProjetoCmd {

	@Autowired private ColaboradoresProjetoRepository repository;
	@Autowired private ColaboradoresProjetoTOBuilder toBuilder;
	
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<ColaboradoresProjetoTO> getAll() {
		Optional<Unidade> unidade = unidadeRepository.findById(getUnidadeLogadaCmd.get().getIdUnidade());
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		
		Optional<List<ColaboradoresProjeto>> listaRetorno = repository.findByIdUnidade(unidade.get().getIdUnidade());
		if(listaRetorno.isPresent()) {
			return toBuilder.buildAll(listaRetorno.get());
		}
		return null;
	}
	
	public ColaboradoresProjetoTO getById(Long id) {
		Optional<ColaboradoresProjeto> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Colaborador do Projeto não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
