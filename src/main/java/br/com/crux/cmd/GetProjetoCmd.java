package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ProjetoTOBuilder;
import br.com.crux.dao.repository.ProjetoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Projeto;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.ProjetoTO;

@Component
public class GetProjetoCmd {

	@Autowired private ProjetoRepository repository;
	@Autowired private ProjetoTOBuilder toBuilder;
	
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<ProjetoTO> getAll() {
		Optional<Unidade> unidade = unidadeRepository.findById(getUnidadeLogadaCmd.get().getIdUnidade());
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		
		Optional<List<Projeto>> listaRetorno = repository.findByIdUnidade(unidade.get().getIdUnidade());
		if(listaRetorno.isPresent()) {
			return toBuilder.buildAll(listaRetorno.get());
		}
		return null;
	}
	
	public ProjetoTO getById(Long id) {
		Optional<Projeto> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Projeto não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
