package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.TurmasTOBuilder;
import br.com.crux.dao.repository.TurmasRepository;
import br.com.crux.entity.Turmas;
import br.com.crux.rule.CamposObrigatoriosTurmasRule;
import br.com.crux.to.TurmasTO;

@Component
public class AlterarTurmasCmd {

	@Autowired private TurmasRepository repository;
	@Autowired private CamposObrigatoriosTurmasRule camposObrigatoriosRule;
	@Autowired private TurmasTOBuilder programaTOBuilder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;
	@Autowired private AlterarColaboradoresTurmaCmd alterarColaboradoresTurmaCmd;

	public void alterar(TurmasTO to) {
		camposObrigatoriosRule.verificar(to);
		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());
		Turmas turma = repository.save(programaTOBuilder.build(to));

		alterarColaboradoresTurmaCmd.alterarAll(to.getColaboradoresTurma(), programaTOBuilder.buildTO(turma));

	}
}
