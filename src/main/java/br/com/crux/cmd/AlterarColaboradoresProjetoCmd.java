package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.CargosTOBuilder;
import br.com.crux.builder.FuncionarioTOBuilder;
import br.com.crux.builder.ProjetoTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProjetoRepository;
import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.exception.NotFoundException;
import br.com.crux.exception.ParametroNaoInformadoException;
import br.com.crux.rule.CamposObrigatoriosColaboradoresProjetoRule;
import br.com.crux.to.ColaboradoresProjetoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarColaboradoresProjetoCmd {

	@Autowired private ColaboradoresProjetoRepository repository;
	@Autowired private CamposObrigatoriosColaboradoresProjetoRule camposObrigatoriosRule;
	
	@Autowired private ProjetoTOBuilder projetoTOBuilder; 
	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;
	@Autowired private CargosTOBuilder cargoTOBuilder;
	
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	
	public void alterar(ColaboradoresProjetoTO to) {
		Optional<ColaboradoresProjeto> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Colaborador do Projeto informado não existe.");
		}
		
		if(Objects.isNull(to.getProjeto())) {
			throw new ParametroNaoInformadoException("Projeto não foi informado.");
		}
		if(Objects.isNull(to.getCargo())) {
			throw new ParametroNaoInformadoException("Cargo não foi informado.");
		}
		if(Objects.isNull(to.getFuncionario())) {
			throw new ParametroNaoInformadoException("Funcionário não foi informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getDataInicio(), to.getFuncionario().getId(), to.getProjeto().getId(), to.getCargo().getId());

		
		ColaboradoresProjeto entityUpdate = entityOptional.get();

		entityUpdate.setDataInicio(to.getDataInicio());
		entityUpdate.setDataFim(to.getDataFim());
		
		entityUpdate.setProjeto(projetoTOBuilder.build(to.getProjeto()));
		entityUpdate.setCargo(cargoTOBuilder.build(to.getCargo()));
		entityUpdate.setFuncionario(funcionarioTOBuilder.build(to.getFuncionario()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entityUpdate.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entityUpdate);
		
	}

}
