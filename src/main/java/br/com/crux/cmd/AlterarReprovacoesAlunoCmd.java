package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AlunoTOBuilder;
import br.com.crux.dao.repository.ReprovacoesAlunoRepository;
import br.com.crux.entity.ReprovacoesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosReprovacoesAlunoRule;
import br.com.crux.to.ReprovacoesAlunoTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarReprovacoesAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	
	@Autowired private ReprovacoesAlunoRepository repository;
	@Autowired private CamposObrigatoriosReprovacoesAlunoRule camposObrigatoriosRule;
	
	@Autowired private AlunoTOBuilder alunoTOBuilder;
	
	
	public void alterar(ReprovacoesAlunoTO to) {
		Optional<ReprovacoesAluno> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Reprovação do aluno informada não existe.");
		}
		
		if(Objects.isNull(to.getAluno())) {
			throw new NotFoundException("Aluno não informado.");
		}
		
		camposObrigatoriosRule.verificar(to.getAluno().getId());
		
		ReprovacoesAluno entity = entityOptional.get();

		entity.setDataReprovacao(to.getDataReprovacao());
		entity.setDescricaoMotivo(to.getDescricaoMotivo());
		entity.setSerieReprovacao(to.getSerieReprovacao());
		entity.setQtdReprovacao(to.getQtdReprovacao());
		entity.setAluno(alunoTOBuilder.build(to.getAluno()));
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
