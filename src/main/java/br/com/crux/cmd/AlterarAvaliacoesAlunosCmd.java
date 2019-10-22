package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AvaliacoesAlunosTOBuilder;
import br.com.crux.dao.repository.AvaliacoesAlunosRepository;
import br.com.crux.entity.AvaliacoesAlunos;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAvaliacoesAlunosRule;
import br.com.crux.to.AvaliacoesAlunosTO;

@Component
public class AlterarAvaliacoesAlunosCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	@Autowired private AvaliacoesAlunosRepository repository;
	@Autowired private CamposObrigatoriosAvaliacoesAlunosRule camposObrigatoriosRule;
	@Autowired private AvaliacoesAlunosTOBuilder avaliacoesAlunosTOBuilder;

	public void alterar(AvaliacoesAlunosTO to) {
		AvaliacoesAlunos entity = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Avaliação do aluno informada não existe."));

		camposObrigatoriosRule.verificar(to);

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		entity = avaliacoesAlunosTOBuilder.build(to);

		repository.save(entity);

	}
}
