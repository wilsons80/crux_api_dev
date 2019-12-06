package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ProdutosAtividadeTOBuilder;
import br.com.crux.dao.repository.ProdutosAtividadeRepository;
import br.com.crux.entity.MateriaisAtividade;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosProdutosAtividadeRule;
import br.com.crux.to.MateriaisAtividadeTO;

@Component
public class AlterarProdutosAtividadeCmd {

	@Autowired private ProdutosAtividadeRepository repository;

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private ProdutosAtividadeTOBuilder produtosAtividadeTOBuilder;
	@Autowired private CamposObrigatoriosProdutosAtividadeRule camposObrigatoriosRule;

	public void alterar(MateriaisAtividadeTO to) {

		camposObrigatoriosRule.verificar(to);

		MateriaisAtividade entity = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Produto da atividade informado não existe."));

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		entity = produtosAtividadeTOBuilder.build(to);

		repository.save(entity);

	}
}
