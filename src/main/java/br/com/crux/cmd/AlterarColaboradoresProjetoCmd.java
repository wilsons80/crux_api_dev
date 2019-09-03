package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.CargosTOBuilder;
import br.com.crux.builder.FuncionarioTOBuilder;
import br.com.crux.builder.ProgramaTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProgramaRepository;
import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.entity.UsuariosSistema;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosColaboradoresProgramaRule;
import br.com.crux.to.ColaboradoresProgramaTO;

@Component
public class AlterarColaboradoresProjetoCmd {

	@Autowired private ColaboradoresProgramaRepository repository;
	@Autowired private CamposObrigatoriosColaboradoresProgramaRule camposObrigatoriosRule;
	
	@Autowired private ProgramaTOBuilder programaTOBuilder; 
	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;
	@Autowired private CargosTOBuilder cargoTOBuilder;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	
	public void alterar(ColaboradoresProgramaTO to) {
		Optional<ColaboradoresPrograma> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Colaborador do Programa informado não existe.");
		}
		
		if(Objects.isNull(to.getPrograma())) {
			throw new ParametroNaoInformadoException("Programa não foi informado.");
		}
		if(Objects.isNull(to.getCargo())) {
			throw new ParametroNaoInformadoException("Cargo não foi informado.");
		}
		if(Objects.isNull(to.getFuncionario())) {
			throw new ParametroNaoInformadoException("Funcionário não foi informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getDataInicio(), to.getFuncionario().getId(), to.getPrograma().getId(), to.getCargo().getId());

		
		ColaboradoresPrograma entityUpdate = entityOptional.get();

		entityUpdate.setDataInicio(to.getDataInicio());
		entityUpdate.setDataFim(to.getDataFim());
		
		entityUpdate.setPrograma(programaTOBuilder.build(to.getPrograma()));
		entityUpdate.setCargo(cargoTOBuilder.build(to.getCargo()));
		entityUpdate.setFuncionario(funcionarioTOBuilder.build(to.getFuncionario()));
		
		UsuariosSistema usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entityUpdate.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entityUpdate);
		
	}
}
