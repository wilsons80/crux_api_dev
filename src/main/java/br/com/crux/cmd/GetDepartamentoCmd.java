package br.com.crux.cmd;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.DepartamentoTOBuilder;
import br.com.crux.dao.repository.DepartamentoRepository;
import br.com.crux.dao.repository.UnidadeRepository;
import br.com.crux.entity.Departamentos;
import br.com.crux.entity.Unidade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.to.DepartamentoTO;

@Component
public class GetDepartamentoCmd {

	@Autowired private DepartamentoRepository departamentoRepository;
	@Autowired private DepartamentoTOBuilder departamentoTOBuilder;
	@Autowired private UnidadeRepository unidadeRepository;
	@Autowired private GetUnidadeLogadaCmd getUnidadeLogadaCmd;
	
	
	public List<DepartamentoTO> getAll() {
		Optional<Unidade> unidade = unidadeRepository.findById(getUnidadeLogadaCmd.get().getIdUnidade());
		if(!unidade.isPresent()) {
			throw new ParametroNaoInformadoException("Unidade não informada.");
		}
		return departamentoTOBuilder.buildAll(departamentoRepository.findByUnidade(unidade.get()));
	}
	
	public DepartamentoTO getById(Long idDepartamento) {
		Optional<Departamentos> departamentoOptional = departamentoRepository.findById(idDepartamento);
		if(!departamentoOptional.isPresent()) {
			throw new NotFoundException("Departamento não encontrado");
		}
		return departamentoTOBuilder.buildTO(departamentoOptional.get());
	}
			
}
