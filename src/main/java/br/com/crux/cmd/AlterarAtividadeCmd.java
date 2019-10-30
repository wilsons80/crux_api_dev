package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.AtividadesTOBuilder;
import br.com.crux.dao.repository.AtividadeRepository;
import br.com.crux.entity.Atividades;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosAtividadeRule;
import br.com.crux.to.AtividadesTO;

@Component
public class AlterarAtividadeCmd {

	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AtividadeRepository repository;
	@Autowired private AtividadesTOBuilder atividadesTOBuilder;
	@Autowired private AlterarColaboradesAtividadeCmd alterarColaboradesAtividadeCmd;

	@Autowired private CamposObrigatoriosAtividadeRule camposObrigatoriosRule;

	public void alterar(AtividadesTO to) {
		camposObrigatoriosRule.verificar(to);

		Atividades entity = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Atividade informado não existe."));

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		entity = atividadesTOBuilder.build(to);
		
		repository.save(entity);
		
		alterarColaboradesAtividadeCmd.alterarAll(to.getColaboradoresAtividade(),entity.getId());

	}
}
