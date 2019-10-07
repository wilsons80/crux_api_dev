package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProgramaTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProgramaRepository;
import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.rule.CamposObrigatoriosColaboradoresProgramaRule;
import br.com.crux.to.ColaboradoresProgramaTO;

@Component
public class CadastrarColaboradoresProgramaCmd {

	@Autowired private ColaboradoresProgramaRepository repository;
	@Autowired private ColaboradoresProgramaTOBuilder colaboradoresProgramaTOBuilder;
	@Autowired private CamposObrigatoriosColaboradoresProgramaRule camposObrigatoriosRule;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	public void cadastrar(ColaboradoresProgramaTO to) {

		camposObrigatoriosRule.verificar(to);

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		ColaboradoresPrograma cPrograma = colaboradoresProgramaTOBuilder.build(to);

		repository.save(cPrograma);

	}
}
