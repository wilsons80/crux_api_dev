package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.entity.Atividades;
import br.com.crux.rule.CamposObrigatoriosAtividadeRule;
import br.com.crux.to.AtividadesTO;

@Component
public class CadastrarAtividadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AtividadeRepository repository;
	@Autowired private AtividadesTOBuilder atividadesTOBuilder;
	@Autowired private CadastrarColaboradoresAtividadeCmd cadastrarColaboradoresAtividadeCmd;
	@Autowired private CamposObrigatoriosAtividadeRule camposObrigatoriosRule;

	public void cadastrar(AtividadesTO to) {

		camposObrigatoriosRule.verificar(to);

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		Atividades entity = atividadesTOBuilder.build(to);
		
		Atividades atividade = repository.save(entity);
		
		if(!to.getColaboradoresAtividade().isEmpty()) {
			cadastrarColaboradoresAtividadeCmd.cadastrar(to.getColaboradoresAtividade());
		}

	}
}
