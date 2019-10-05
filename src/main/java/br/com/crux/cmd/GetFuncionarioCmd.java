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
		
		Optional<List<Funcionario>> funcionariosOptional = repository.findAllByIdUnidade(acessoUnidadeTO.getId());
		if(!funcionariosOptional.isPresent()) {
			return new ArrayList<FuncionarioTO>();
		}
		
		List<FuncionarioTO> lista = toBuilder.buildAll(funcionariosOptional.get());
		return lista;
	}
	
	public FuncionarioTO getTOById(Long id) {
		Funcionario entity = repository.findById(id).orElseThrow(() -> new NotFoundException("Funcionario não encontrado."));
		return toBuilder.buildTO(entity);
	}

	public Funcionario getById(Long id) {
		Optional<Funcionario> funcionario = repository.findById(id);
		if(!funcionario.isPresent()) {
			return null;
		}
		return funcionario.get();
		
	}
			
}
