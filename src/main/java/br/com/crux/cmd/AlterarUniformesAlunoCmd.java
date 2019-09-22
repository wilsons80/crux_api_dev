package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesAlunoTOBuilder;
import br.com.crux.dao.repository.AtividadesAlunoRepository;
import br.com.crux.dao.repository.UniformesAlunoRepository;
import br.com.crux.entity.AtividadesAluno;
import br.com.crux.entity.UniformesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosUniformesAlunoRule;
import br.com.crux.to.UniformesAlunoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarUniformesAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	@Autowired private UniformesAlunoRepository repository;
	@Autowired private CamposObrigatoriosUniformesAlunoRule camposObrigatoriosRule;

	@Autowired private AtividadesAlunoRepository atividadeRepository;
	@Autowired private AtividadesAlunoTOBuilder atividadeBuilder;
	
	
	
	public void alterar(UniformesAlunoTO to) {
		Optional<UniformesAluno> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Uniforme do aluno informado não existe.");
		}
		
		if(Objects.isNull(to.getAtividadesAluno())) {
			throw new NotFoundException("Atividade não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getAtividadesAluno().getId());
		
		Optional<AtividadesAluno> atividadeOptional = atividadeRepository.findById(to.getAtividadesAluno().getId());
		if(!atividadeOptional.isPresent()) {
			throw new NotFoundException("Atividade informado não existe.");
		}
		
		UniformesAluno entity = entityOptional.get();

		entity.setNomeUniforme(to.getNomeUniforme());
		entity.setDataUniformeEntregue(to.getDataUniformeEntregue());
		entity.setQtdUniformeEntregue(to.getQtdUniformeEntregue());
		entity.setAtividadesAluno(atividadeBuilder.build(to.getAtividadesAluno()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
