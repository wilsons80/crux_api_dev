package br.com.crux.cmd;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.crux.builder.MateriaisProjetoTOBuilder;
import br.com.crux.dao.repository.MateriaisProjetoRepository;
import br.com.crux.entity.MateriaisProjeto;
import br.com.crux.entity.Projeto;
import br.com.crux.to.MateriaisProjetoTO;

@Component
public class CadastrarMateriaisProjetoCmd {

	@Autowired MateriaisProjetoRepository materiaisProjetoRepository;
	@Autowired MateriaisProjetoTOBuilder materiaisProjetoTOBuilder;

	public MateriaisProjeto cadastrar(Projeto projeto, MateriaisProjetoTO materiaisProjetoTO) {
		MateriaisProjeto materiaisProjeto = materiaisProjetoTOBuilder.build(projeto, materiaisProjetoTO);
		return materiaisProjetoRepository.save(materiaisProjeto);
	}

	public List<MateriaisProjeto> cadastrarLista(Projeto projeto, List<MateriaisProjetoTO> materiaisProjetoTO) {
		return materiaisProjetoTO.stream().map(composicaoRhProjeto -> cadastrar(projeto, composicaoRhProjeto)).collect(Collectors.toList());

	}

}
