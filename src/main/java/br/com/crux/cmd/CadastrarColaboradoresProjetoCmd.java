package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProjetoTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProjetoRepository;
import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.rule.CamposObrigatoriosColaboradoresProjetoRule;
import br.com.crux.to.ColaboradoresProjetoTO;

@Component
public class CadastrarColaboradoresProjetoCmd {

	@Autowired private ColaboradoresProjetoRepository repository;
	@Autowired private ColaboradoresProjetoTOBuilder colaboradoresProjetoTOBuilder;
	@Autowired private CamposObrigatoriosColaboradoresProjetoRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	public void cadastrar(ColaboradoresProjetoTO to) {

		camposObrigatoriosRule.verificar(to);

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		ColaboradoresProjeto entity = colaboradoresProjetoTOBuilder.build(to);

		repository.save(entity);

	}
}
