package br.com.crux.cmd;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesAlunoTOBuilder;
import br.com.crux.builder.AvaliacoesTOBuilder;
import br.com.crux.dao.repository.AtividadesAlunoRepository;
import br.com.crux.dao.repository.AvaliacoesAlunosRepository;
import br.com.crux.dao.repository.AvaliacoesRepository;
import br.com.crux.entity.AtividadesAluno;
import br.com.crux.entity.Avaliacoes;
import br.com.crux.entity.AvaliacoesAlunos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAvaliacoesAlunosRule;
import br.com.crux.to.AvaliacoesAlunosTO;
import br.com.crux.to.UsuarioLogadoTO;

@Component
public class AlterarAvaliacoesAlunosCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	@Autowired private AvaliacoesAlunosRepository repository;
	@Autowired private CamposObrigatoriosAvaliacoesAlunosRule camposObrigatoriosRule;

	
	@Autowired private AvaliacoesRepository avaliacoesRepository;
	@Autowired private AtividadesAlunoRepository atividadesAlunoRepository;
	
	@Autowired private AvaliacoesTOBuilder avaliacoesBuilder;
	@Autowired private AtividadesAlunoTOBuilder atividadesBuilder;
	
	
	public void alterar(AvaliacoesAlunosTO to) {
		Optional<AvaliacoesAlunos> entityOptional = repository.findById(to.getId());
		if(!entityOptional.isPresent()) {
			throw new NotFoundException("Avaliação do aluno informada não existe.");
		}
		
		if(Objects.isNull(to.getAvaliacoes())) {
			throw new NotFoundException("Avaliação não informada.");
		}
		if(Objects.isNull(to.getAtividadesAluno())) {
			throw new NotFoundException("Atividade não informada.");
		}
		
		camposObrigatoriosRule.verificar(to.getAtividadesAluno().getId(), to.getAvaliacoes().getId());
		
		Optional<Avaliacoes> avaliacaoOptional = avaliacoesRepository.findById(to.getAvaliacoes().getId());
		if(!avaliacaoOptional.isPresent()) {
			throw new NotFoundException("Avaliação informada não existe.");
		}
		Optional<AtividadesAluno> atividadesAlunoOptional = atividadesAlunoRepository.findById(to.getAtividadesAluno().getId());
		if(!atividadesAlunoOptional.isPresent()) {
			throw new NotFoundException("Atividade do aluno informada não existe.");
		}
		
		AvaliacoesAlunos entity = entityOptional.get();

		entity.setDescriaoAvaliacao(to.getDescriaoAvaliacao());
		entity.setDataAvaliacao(to.getDataAvaliacao());
		entity.setAtividadesAluno(atividadesBuilder.build(to.getAtividadesAluno()));
		entity.setAvaliacoes(avaliacoesBuilder.build(to.getAvaliacoes()));
		entity.setNotaAvaliacao(to.getNotaAvaliacao());
		
		UsuarioLogadoTO usuarioLogado = getUsuarioLogadoCmd.getUsuarioLogado();
		entity.setUsuarioAlteracao(usuarioLogado.getIdUsuario());
		
		repository.save(entity);
		
	}
}
