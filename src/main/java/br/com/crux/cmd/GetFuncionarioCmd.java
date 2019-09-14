package br.com.crux.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FuncionarioTOBuilder;
import br.com.crux.dao.repository.FuncionarioRepository;
import br.com.crux.entity.Funcionario;
import br.com.crux.exception.NotFoundException;
import br.com.crux.to.AcessoUnidadeTO;
import br.com.crux.to.FuncionarioTO;

@Component
public class GetFuncionarioCmd {

	@Autowired private FuncionarioRepository repository;
	@Autowired private FuncionarioTOBuilder toBuilder;
	
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	public List<FuncionarioTO> getAllPorUnidadeLogada() {
		AcessoUnidadeTO acessoUnidadeTO = getUnidadeLogadaCmd.get();
		List<FuncionarioTO> lista = toBuilder.buildAll(repository.findAllByIdUnidade(acessoUnidadeTO.getId()).get());
		
		if(lista == null || lista.isEmpty()) {
			return new ArrayList<FuncionarioTO>();
		}
		
		return lista;
	}
	
	public FuncionarioTO getById(Long id) {
		Optional<Funcionario> entityOptional = repository.findById(id);
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Funcionario não encontrado.");
		}
		return toBuilder.buildTO(entityOptional.get());
	}
			
}
