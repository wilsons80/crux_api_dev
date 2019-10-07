package br.com.crux.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.ColaboradoresProjetoTOBuilder;
import br.com.crux.dao.repository.ColaboradoresProjetoRepository;
import br.com.crux.entity.ColaboradoresProjeto;
import br.com.crux.exception.NotFoundException;
import br.com.crux.rule.CamposObrigatoriosColaboradoresProjetoRule;
import br.com.crux.to.ColaboradoresProjetoTO;

@Component
public class AlterarColaboradoresProjetoCmd {

	@Autowired private ColaboradoresProjetoRepository repository;
	@Autowired private CamposObrigatoriosColaboradoresProjetoRule camposObrigatoriosRule;
	@Autowired private ColaboradoresProjetoTOBuilder colaboradoresProjetoTOBuilder;
	@Autowired private GetUsuarioLogadoCmd getUsuarioLogadoCmd;

	public void alterar(ColaboradoresProjetoTO to) {

		ColaboradoresProjeto entity = repository.findById(to.getId()).orElseThrow(() -> new NotFoundException("Colaborador do Projeto informado não existe."));
		
		camposObrigatoriosRule.verificar(to);

		to.setUsuarioAlteracao(getUsuarioLogadoCmd.getUsuarioLogado().getIdUsuario());

		entity = colaboradoresProjetoTOBuilder.build(to);

		repository.save(entity);

	}

}
