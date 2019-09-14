package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.FuncionarioTOBuilder;
import br.com.crux.dao.repository.FaltasFuncionarioRepository;
import br.com.crux.entity.FaltasFuncionario;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosFaltasFuncionarioRule;
import br.com.crux.to.FaltasFuncionarioTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class CadastrarFaltasFuncionarioCmd {

	@Autowired private FaltasFuncionarioRepository repository;
	
	@Autowired private FuncionarioTOBuilder funcionarioTOBuilder;
	@Autowired private CamposObrigatoriosFaltasFuncionarioRule camposObrigatoriosCargosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	public void cadastrar(FaltasFuncionarioTO to) {
		Optional<FaltasFuncionario> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Falta Funcionario informado não existe.");
		}
		
		if(Objects.isNull(to.getFuncionarioFaltou())) {
			throw new NotFoundException("Funcionário que faltou não informado.");
		}
		
		if(Objects.isNull(to.getFuncionarioCadastrouFalta())) {
			throw new NotFoundException("Funcionário cadastro não informado.");
		}
		
		camposObrigatoriosCargosRule.verificar(to.getDescricao(), to.getFuncionarioCadastrouFalta().getId(), to.getFuncionarioFaltou().getId());		
		FaltasFuncionario entity = new FaltasFuncionario();
		
		entity.setDescricao(to.getDescricao());
		entity.setJutificativaFalta(to.getJutificativaFalta());
		entity.setDataCadastro(to.getDataCadastro());
		entity.setDataFaltaFuncionario(to.getDataFaltaFuncionario());
		entity.setFuncionarioFaltou(funcionarioTOBuilder.build(to.getFuncionarioFaltou()));
		entity.setFuncionarioCadastrouFalta(funcionarioTOBuilder.build(to.getFuncionarioCadastrouFalta()));
		entity.setUsuarioAlteracao(to.getUsuarioAlteracao());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
