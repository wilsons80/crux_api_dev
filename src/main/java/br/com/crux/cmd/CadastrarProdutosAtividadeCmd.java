package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ProdutosAtividadeTOBuilder;
import br.com.crux.dao.repository.ProdutosAtividadeRepository;
import br.com.crux.entity.ProdutosAtividade;
import br.com.crux.rule.CamposObrigatoriosProdutosAtividadeRule;
import br.com.crux.to.ProdutosAtividadeTO;

@Component
public class CadastrarProdutosAtividadeCmd {

	@Autowired private ProdutosAtividadeRepository repository;
	@Autowired private ProdutosAtividadeTOBuilder produtosAtividadeTOBuilder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private CamposObrigatoriosProdutosAtividadeRule camposObrigatoriosRule;

	public void cadastrar(ProdutosAtividadeTO to) {

		camposObrigatoriosRule.verificar(to);

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		ProdutosAtividade entity = produtosAtividadeTOBuilder.build(to);

		repository.save(entity);

	}
}
