package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.CargosTOBuilder;
import br.com.crux.builder.FuncionarioTOBuilder;
import br.com.crux.builder.ProjetoTOBuilder;
import br.com.crux.dao.repository.CargoRepository;
import br.com.crux.dao.repository.ColaboradoresProjetoRepository;
import br.com.crux.dao.repository.FuncionarioRepository;
import br.com.crux.dao.repository.ProjetoRepository;
import br.com.crux.entity.Cargo;
import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.entity.Funcionario;
import br.com.crux.entity.Projeto;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosColaboradoresProjetoRule;
import br.com.crux.to.ColaboradoresProjetoTO;

@Component
public class CadastrarColaboradoresProjetoCmd {

	@Autowired private ColaboradoresProjetoRepository repository;
	
	@Autowired private ProjetoRepository projetoRepository;
	@Autowired private FuncionarioRepository funcionarioRepository;
	@Autowired private CargoRepository cargoRepository;
	
	@Autowired private ProjetoTOBuilder projetoTOBuilder; 
	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;
	@Autowired private CargosTOBuilder cargoTOBuilder;
	
	@Autowired private CamposObrigatoriosColaboradoresProjetoRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(ColaboradoresProjetoTO to) {
		
		if(Objects.isNull(to.getProjeto())) {
			throw new ParametroNaoInformadoException("Projeto não foi informado.");
		}
		if(Objects.isNull(to.getCargo())) {
			throw new ParametroNaoInformadoException("Cargo não foi informado.");
		}
		if(Objects.isNull(to.getFuncionario())) {
			throw new ParametroNaoInformadoException("Funcionário não foi informado.");
		}

		
		Optional<Projeto> projeto = projetoRepository.findById(to.getProjeto().getId());
		if(!projeto.isPresent()) {
			throw new NotFoundException("Projeto informado não existe.");
		}
		
		Optional<Funcionario> funcionario = funcionarioRepository.findById(to.getFuncionario().getId());
		if(!funcionario.isPresent()) {
			throw new NotFoundException("Funcionario informado não existe.");
		}

		Optional<Cargo> cargo = cargoRepository.findById(to.getCargo().getId());
		if(!cargo.isPresent()) {
			throw new NotFoundException("Cargo informado não existe.");
		}		
		
		
		camposObrigatoriosRule.verificar(to.getDataInicio(), to.getFuncionario().getId(), to.getProjeto().getId(), to.getCargo().getId());
		
		ColaboradoresProjeto entity = new ColaboradoresProjeto();

		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		entity.setProjeto(projetoTOBuilder.build(to.getProjeto()));
		entity.setCargo(cargoTOBuilder.build(to.getCargo()));
		entity.setFuncionario(funcionarioTOBuilder.build(to.getFuncionario()));
		
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
