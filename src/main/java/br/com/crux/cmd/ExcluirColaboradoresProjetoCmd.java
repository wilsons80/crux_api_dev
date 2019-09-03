package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.dao.repository.CargoRepository;
import br.com.crux.dao.repository.ColaboradoresProjetoRepository;
import br.com.crux.dao.repository.FuncionarioRepository;
import br.com.crux.dao.repository.ProjetoRepository;
import br.com.crux.entity.Cargo;
import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.entity.Funcionario;
import br.com.crux.entity.Projeto;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.exception.TabaleReferenciaEncontradaException;

@Component
public class ExcluirColaboradoresProjetoCmd {

	@Autowired private ColaboradoresProjetoRepository repository;
	
	@Autowired private ProjetoRepository projetoRepository;
	@Autowired private CargoRepository cargoRepository;
	@Autowired private FuncionarioRepository funcionarioRepository;
	
	
	public void excluir(Long id) {
		if(Objects.isNull(id)) {
			throw new ParametroNaoInformadoException("Erro ao excluir, parâmetro ausente.");
		}
		
		Optional<ColaboradoresProjeto> entity = repository.findById(id);
		if(!entity.isPresent()) {
			throw new NotFoundException("Colaborador do Projeto informado não existe.");
		}
		
		
		Optional<Projeto> projeto = projetoRepository.findById(entity.get().getProjeto().getId());
		if(projeto.isPresent()) {
			throw new TabaleReferenciaEncontradaException("Por favor, excluir o projeto primeiro!");
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
