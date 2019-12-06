package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisAtividadeTOBuilder;
import br.com.crux.dao.repository.MateriaisAtividadeRepository;
import br.com.crux.entity.MateriaisAtividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosMateriaisAtividadeRule;
import br.com.crux.to.MateriaisAtividadeTO;

@Component
public class AlterarMateriaisAtividadeCmd {

	@Autowired private MateriaisAtividadeRepository repository;

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private MateriaisAtividadeTOBuilder produtosAtividadeTOBuilder;
	@Autowired private CamposObrigatoriosMateriaisAtividadeRule camposObrigatoriosRule;

	public void alterar(MateriaisAtividadeTO to) {

		camposObrigatoriosRule.verificar(to);

		MateriaisAtividade entity = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Produto da atividade informado não existe."));

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		entity = produtosAtividadeTOBuilder.build(to);

		repository.save(entity);

	}
}
