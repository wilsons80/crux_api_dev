package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.CargosTOBuilder;
import br.com.crux.builder.FuncionarioTOBuilder;
import br.com.crux.builder.ProgramaTOBuilder;
import br.com.crux.dao.repository.CargoRepository;
import br.com.crux.dao.repository.ColaboradoresProgramaRepository;
import br.com.crux.dao.repository.FuncionarioRepository;
import br.com.crux.dao.repository.ProgramaRepository;
import br.com.crux.entity.Cargo;
import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.entity.Funcionario;
import br.com.crux.entity.Programa;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosColaboradoresProgramaRule;
import br.com.crux.to.ColaboradoresProgramaTO;

@Component
public class CadastrarColaboradoresProgramaCmd {

	@Autowired private ColaboradoresProgramaRepository repository;
	
	@Autowired private ProgramaRepository programaRepository;
	@Autowired private FuncionarioRepository funcionarioRepository;
	@Autowired private CargoRepository cargoRepository;
	
	@Autowired private ProgramaTOBuilder programaTOBuilder; 
	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;
	@Autowired private CargosTOBuilder cargoTOBuilder;
	
	@Autowired private CamposObrigatoriosColaboradoresProgramaRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(ColaboradoresProgramaTO to) {
		
		if(Objects.isNull(to.getPrograma())) {
			throw new ParametroNaoInformadoException("Programa não foi informado.");
		}
		if(Objects.isNull(to.getCargo())) {
			throw new ParametroNaoInformadoException("Cargo não foi informado.");
		}
		if(Objects.isNull(to.getFuncionario())) {
			throw new ParametroNaoInformadoException("Funcionário não foi informado.");
		}

		
		Optional<Programa> programa = programaRepository.findById(to.getPrograma().getId());
		if(!programa.isPresent()) {
			throw new NotFoundException("Programa informado não existe.");
		}
		
		Optional<Funcionario> funcionario = funcionarioRepository.findById(to.getFuncionario().getId());
		if(!funcionario.isPresent()) {
			throw new NotFoundException("Funcionario informado não existe.");
		}

		Optional<Cargo> cargo = cargoRepository.findById(to.getCargo().getId());
		if(!cargo.isPresent()) {
			throw new NotFoundException("Cargo informado não existe.");
		}		
		
		
		camposObrigatoriosRule.verificar(to.getDataInicio(), to.getFuncionario().getId(), to.getPrograma().getId(), to.getCargo().getId());
		
		ColaboradoresPrograma entity = new ColaboradoresPrograma();

		entity.setDataInicio(to.getDataInicio());
		entity.setDataFim(to.getDataFim());
		entity.setPrograma(programaTOBuilder.build(to.getPrograma()));
		entity.setCargo(cargoTOBuilder.build(to.getCargo()));
		entity.setFuncionario(funcionarioTOBuilder.build(to.getFuncionario()));
		
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
