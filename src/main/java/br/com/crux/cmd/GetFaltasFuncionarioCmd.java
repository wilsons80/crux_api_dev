package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FaltasFuncionarioTOBuilder;
import br.com.crux.dao.repository.FaltasFuncionarioRepository;
import br.com.crux.entity.FaltasFuncionario;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AcessoUnidadeTO;
import br.com.crux.to.FaltasFuncionarioTO;

@Component
public class GetFaltasFuncionarioCmd {

	@Autowired private FaltasFuncionarioRepository repository;
	@Autowired private FaltasFuncionarioTOBuilder toBuilder;
	
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<FaltasFuncionarioTO> getAllPorUnidadeLogada() {
		AcessoUnidadeTO acessoUnidadeTO = getUnidadeLogadaCmd.get();
		List<FaltasFuncionarioTO> lista = toBuilder.buildAll(repository.findByIdUnidade(acessoUnidadeTO.getId()).get());
		
		if(lista == null || lista.isEmpty()) {
			return new ArrayList<FaltasFuncionarioTO>();
		}
		
		return lista;
	}
	
	public FaltasFuncionarioTO getById(Long id) {
		Optional<FaltasFuncionario> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Faltas do Funcionario não encontrada.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
