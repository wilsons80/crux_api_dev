package br.com.crux.cmd;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisProgramaTOBuilder;
import br.com.crux.dao.repository.MateriaisProgramaRepository;
import br.com.crux.entity.MateriaisPrograma;
import br.com.crux.entity.Programa;
import br.com.crux.rule.CamposObrigatoriosMateriaisProjetoRule;
import br.com.crux.to.MateriaisProgramaTO;

@Component
public class CadastrarMateriaisProgramaCmd {

	@Autowired MateriaisProgramaRepository materiaisProgramaRepository;
	@Autowired MateriaisProgramaTOBuilder materiaisProgramaTOBuilder;
	@Autowired CamposObrigatoriosMateriaisProjetoRule camposObrigatoriosMateriaisProjetoRule;

	public MateriaisPrograma cadastrar(Programa programa, MateriaisProgramaTO composicaoRhProjetoTO) {
		MateriaisPrograma materiaisPrograma = materiaisProgramaTOBuilder.build(programa, composicaoRhProjetoTO);
		return materiaisProgramaRepository.save(materiaisPrograma);
	}

	public List<MateriaisPrograma> cadastrarLista(Programa programa, List<MateriaisProgramaTO> list) {
		return list.stream().map(composicaoRhProjeto -> cadastrar(programa, composicaoRhProjeto)).collect(Collectors.toList());

	}

}
