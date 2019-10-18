package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ProjetoTOBuilder;
import br.com.crux.dao.repository.ProjetoRepository;
import br.com.crux.entity.Projeto;
import br.com.crux.rule.CamposObrigatoriosProjetoRule;
import br.com.crux.to.ProjetoTO;

@Component
public class CadastrarProjetoCmd {

	@Autowired private ProjetoRepository repository;
	@Autowired private ProjetoTOBuilder projetoTOBuilder;
	@Autowired private CamposObrigatoriosProjetoRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	public void cadastrar(ProjetoTO to) {

		camposObrigatoriosRule.verificar(to);

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		Projeto entity = projetoTOBuilder.build(to);

		repository.save(entity);

	}
}
