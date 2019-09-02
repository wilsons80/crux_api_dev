package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.CargoRepository;
import br.com.crux.dao.repository.ColaboradoresProgramaRepository;
import br.com.crux.dao.repository.FuncionarioRepository;
import br.com.crux.dao.repository.ProgramaRepository;
import br.com.crux.entity.Cargo;
import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.entity.Funcionario;
import br.com.crux.entity.Programa;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.exception.TabaleReferenciaEncontradaException;

@Component
public class ExcluirColaboradoresProgramaCmd {

	@Autowired private ColaboradoresProgramaRepository repository;
	
	@Autowired private ProgramaRepository programaRepository;
	@Autowired private CargoRepository cargoRepository;
	@Autowired private FuncionarioRepository funcionarioRepository;
	
	
	public void excluir(Long id) {
		if(Objects.isNull(id)) {
			throw new ParametroNaoInformadoException("Erro ao excluir, parâmetro ausente.");
		}
		
		Optional<ColaboradoresPrograma> entity = repository.findById(id);
		if(!entity.isPresent()) {
			throw new NotFoundException("Colaborador do Programa informado não existe.");
		}
		
		
		Optional<Programa> iniciativa = programaRepository.findById(entity.get().getPrograma().getId());
		if(iniciativa.isPresent()) {
			throw new TabaleReferenciaEncontradaException("Por favor, excluir o programa primeiro!");
		}
		
		Optional<Cargo> cargo = cargoRepository.findById(entity.get().getCargo().getId());
		if(cargo.isPresent()) {
			throw new TabaleReferenciaEncontradaException("Por favor, excluir o cargo primeiro!");
		}
		
		Optional<Funcionario> funcionario = funcionarioRepository.findById(entity.get().getCargo().getId());
		if(funcionario.isPresent()) {
			throw new TabaleReferenciaEncontradaException("Por favor, excluir o funcionário primeiro!");
		}		
		
		repository.deleteById(id);
	}
}
