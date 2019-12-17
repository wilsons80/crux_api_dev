package br.com.crux.cmd;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

	private void alterar(AtividadesAlunoTO to) {
		AtividadesAluno entity = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Oficina do Aluno informada não existe."));

		camposObrigatoriosRule.verificar(to);
		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		entity = atividadesAlunoTOBuilder.build(to);
		entity.setDataAlteracaoAtividade(LocalDateTime.now());
		repository.save(entity);

	}
	
	public void alterarAll(List<AtividadesAlunoTO> atividadesAlunosTO) {
		Optional<List<AtividadesAlunoTO>> listaTO = Optional.ofNullable(atividadesAlunosTO);
		if(listaTO.isPresent()) {
			listaTO.get().forEach(to -> alterar(to));
		}
	}
}
