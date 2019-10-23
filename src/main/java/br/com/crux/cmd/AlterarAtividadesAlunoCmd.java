package br.com.crux.cmd;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesAlunoTOBuilder;
import br.com.crux.dao.repository.AtividadesAlunoRepository;
import br.com.crux.entity.AtividadesAluno;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAtividadesAlunoRule;
import br.com.crux.to.AtividadesAlunoTO;

@Component
public class AlterarAtividadesAlunoCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	@Autowired private AtividadesAlunoRepository repository;
	@Autowired private CamposObrigatoriosAtividadesAlunoRule camposObrigatoriosRule;
	@Autowired private AtividadesAlunoTOBuilder atividadesAlunoTOBuilder;

	public void alterar(AtividadesAlunoTO to) {
		AtividadesAluno entity = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Atividade do Aluno informada não existe."));

		camposObrigatoriosRule.verificar(to);

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		entity = atividadesAlunoTOBuilder.build(to);

		entity.setDataAlteracaoAtividade(LocalDateTime.now());

		repository.save(entity);

	}
}
