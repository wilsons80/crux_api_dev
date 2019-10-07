package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProgramaTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProgramaRepository;
import br.com.crux.entity.ColaboradoresPrograma;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosColaboradoresProgramaRule;
import br.com.crux.to.ColaboradoresProgramaTO;

@Component
public class AlterarColaboradoresProgramaCmd {

	@Autowired private ColaboradoresProgramaRepository repository;
	@Autowired private CamposObrigatoriosColaboradoresProgramaRule camposObrigatoriosRule;
	@Autowired private ColaboradoresProgramaTOBuilder colaboradoresProgramaTOBuilder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	public void alterar(ColaboradoresProgramaTO to) {

		camposObrigatoriosRule.verificar(to);

		ColaboradoresPrograma cPrograma = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Colaborador do Programa informado não existe."));

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		cPrograma = colaboradoresProgramaTOBuilder.build(to);

		repository.save(cPrograma);

	}
}
