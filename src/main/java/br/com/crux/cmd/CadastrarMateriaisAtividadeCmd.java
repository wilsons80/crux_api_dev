package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisAtividadeTOBuilder;
import br.com.crux.dao.repository.MateriaisAtividadeRepository;
import br.com.crux.entity.MateriaisAtividade;
import br.com.crux.rule.CamposObrigatoriosMateriaisAtividadeRule;
import br.com.crux.to.MateriaisAtividadeTO;

@Component
public class CadastrarMateriaisAtividadeCmd {

	@Autowired private MateriaisAtividadeRepository repository;
	@Autowired private MateriaisAtividadeTOBuilder produtosAtividadeTOBuilder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosMateriaisAtividadeRule camposObrigatoriosRule;

	public void cadastrar(MateriaisAtividadeTO to) {

		camposObrigatoriosRule.verificar(to);

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		MateriaisAtividade entity = produtosAtividadeTOBuilder.build(to);

		repository.save(entity);

	}
}
