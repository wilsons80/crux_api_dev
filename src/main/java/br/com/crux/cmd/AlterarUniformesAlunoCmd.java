package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.UniformesAlunoTOBuilder;
import br.com.crux.dao.repository.UniformesAlunoRepository;
import br.com.crux.entity.UniformesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosUniformesAlunoRule;
import br.com.crux.to.UniformesAlunoTO;

@Component
public class AlterarUniformesAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	@Autowired private UniformesAlunoRepository repository;
	@Autowired private CamposObrigatoriosUniformesAlunoRule camposObrigatoriosRule;
	@Autowired private UniformesAlunoTOBuilder uniformesAlunoTOBuilder;
	
	
	public void alterar(UniformesAlunoTO to) {
		camposObrigatoriosRule.verificar(to);
		
		UniformesAluno entity = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Uniforme do aluno informado não existe.") );
		
		entity = uniformesAlunoTOBuilder.build(to);
		entity.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		
		repository.save(entity);
		
	}
}
